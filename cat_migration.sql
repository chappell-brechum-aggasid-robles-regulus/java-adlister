USE adlister_db;

DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ad_category;

CREATE TABLE categories(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(240),
    PRIMARY KEY (id)
);

CREATE TABLE ad_category(
    cat_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ad_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (cat_id) REFERENCES categories(id),
    FOREIGN KEY (ad_id) REFERENCES ads(id)
);
