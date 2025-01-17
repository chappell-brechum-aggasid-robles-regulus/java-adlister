package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);


    

    // Ad getAdById (int adId);
    Ad getAdById(Long adId);
  
    // Search for a List of Ads by Title
    List<Ad> searchAdByTitle(String param);

    // Search for a List of Ads by User ID
    List<Ad> searchAdByUser(long param);

    // Delete ad by Id
    void deleteAdById(long param);

    // Delete All Ads by User Id
    void deleteByUser(long param) throws SQLException;

    // Update Edit ad by Id
    void editAdById(Ad ad, String[] categories);

    // Search Ad by Category and Title
    List<Ad> searchAdByCategory(long category, String param);

    // Insert Ad and Category
    void insertAdAndCategory(Ad ad, String[] categories);

    // Delete Categories from Ad
    void deleteAdCategories(long ad_id);

    // Insert Categories to AD
    void addCategoriesToAd(long ad_id, String[] categories);
}
