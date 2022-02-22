package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Categories CategoriesDao;
    private static AdCategories AdCategoriesDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Categories getCategoriesDao() {
        if (CategoriesDao == null) {
            CategoriesDao = new MySQLCategoriesDao(config);
        }
        return CategoriesDao;
    }

    public static AdCategories getAdCategoriesDao() {
        if(AdCategoriesDao == null){
            AdCategoriesDao = new MySQLAdCategoryDao(config);
        }
        return AdCategoriesDao;
    }
}
