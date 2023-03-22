package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;
// interface for ads
public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    //delete an ad
    void delete(Ad ad);
    //edit an Ad
    void edit(Ad ad);
    //find ad by id
    Ad findById(long id);
}
