package dao;

import models.Ad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    //    return list of ads for individual user
    List<Ad> findByUser(Long userId);
}
