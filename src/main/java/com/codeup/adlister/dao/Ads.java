package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // Search for a List of Ads by Title
    List<Ad> searchAdByTitle(String param);
    // Search for a List of Ads by User ID
    List<Ad> searchAdByUser(long param);
}
