package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCategory;

import java.util.List;

public interface AdCategories {

    List<AdCategory> searchCategoriesByAdId(long adId);
    List<AdCategory> all();
}
