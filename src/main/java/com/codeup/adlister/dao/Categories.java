package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {

//    Return List of All Categories
    List<Category> all();

//    Return List of Categories for the Selected Ad
    List<Category> searchCategoriesByAdId(long adId);
}
