package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(

                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()

            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public Ad getAdById(Long adId) {
        Ad ad = null;
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, String.valueOf(adId));
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ad = extractAd(rs);
            }
            return ad;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding the Ad by the ID.", e);
        }
    }

    public List<Ad> searchAdByTitle(String searchTerm) {
        String query = "SELECT * FROM ads WHERE title LIKE ?";
        String searchTermWithWildCards = "%" + searchTerm + "%";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, searchTermWithWildCards);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Ad> searchAdByUser(long user_id) {
        String sql = "SELECT * FROM ads WHERE user_id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, user_id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Ad> searchAdByCategory(long cat_id, String searchTerm) {
        String sql = "SELECT * FROM ads inner join ad_category on ad_category.ad_id = ads.id WHERE ad_category.cat_id = ? AND ads.title LIKE ?";
        String searchTermWithWildCards = "%" + searchTerm + "%";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, cat_id);
            stmt.setString(2, searchTermWithWildCards);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void deleteAdById(long ad_id) {
        String sql = "DELETE FROM ads WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, String.valueOf(ad_id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error finding the Ad!");
        }
    }

    public void editAdById(Ad ad) {
        String query = "UPDATE ads SET title = ?, description = ?";
        query += "WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("error finding the ad by the id", e);
        }
    }
}