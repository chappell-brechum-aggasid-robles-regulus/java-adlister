package com.codeup.adlister.models;

public class AdCategory {
    private int catId;
    private int adId;

    public AdCategory(int catId, int adId) {
        this.catId = catId;
        this.adId = adId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }
}
