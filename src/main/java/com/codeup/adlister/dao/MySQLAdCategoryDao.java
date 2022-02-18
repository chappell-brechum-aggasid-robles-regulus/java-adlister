package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCategory;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdCategoryDao implements AdCategories {
    private Connection connection = null;

    public MySQLAdCategoryDao(Config config) {
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


    public List<AdCategory> searchCategoriesByAdId(long adId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT name FROM categories inner join  ad_category on ad_category.cat_id = categories.id WHERE ad_category.ad_id = ?;");
            stmt.setLong(1,adId);
            ResultSet rs = stmt.executeQuery();
            return createAdCategoriesFromResults(rs);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private AdCategory extractAdCategory(ResultSet rs) throws SQLException{
        return new AdCategory(
                rs.getInt("cat_id"),
                rs.getInt("ad_id")
        );
    }

    private List<AdCategory> createAdCategoriesFromResults(ResultSet rs) throws SQLException{
        List<AdCategory> result = new ArrayList<>();
        while(rs.next()){
            result.add(extractAdCategory(rs));
        }
        return result;
    }

    @Override
    public List<AdCategory> all() {
        return null;
    }
}