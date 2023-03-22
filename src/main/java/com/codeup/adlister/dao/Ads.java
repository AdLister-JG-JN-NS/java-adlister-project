package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // get a list of queried the ads
    List<Ad> search(String str);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    void delete(Ad ad);
    void edit(Ad ad);

    Ad findById(long id);
}
