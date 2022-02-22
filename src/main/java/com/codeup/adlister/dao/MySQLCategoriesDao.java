package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
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

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("name")
        );
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }

    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Category> searchCategoriesByAdId(long adId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories inner join ad_category on categories.id = ad_category.cat_id WHERE ad_category.ad_id = ?;");
            stmt.setLong(1,adId);
            ResultSet rs = stmt.executeQuery();
            System.out.println(stmt);
            return createCategoriesFromResults(rs);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


}
