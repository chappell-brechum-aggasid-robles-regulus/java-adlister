package com.codeup.adlister.models;

public class AdCategory {
    private long catId;
    private long adId;

    public AdCategory(long catId, long adId) {
        this.catId = catId;
        this.adId = adId;
    }

    public AdCategory(long cat_id, long ad_id, long id, String name) {
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }
}
