package com.dinout.foursquaresample.services.models;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class VenuesVO
{
    private String id;
    private String name;
    private boolean verified;
    private String url;
    private String referralId;
    private ContactVO contact;
    private LocationVO location;
    private SpecialsVO specials;
    private ArrayList<CategoriesVO> categories;
    private StatsVO stats;
    private HereNowVO hereNow;
    private PhotosVO photos;
    private double rating;

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public boolean isVerified()
    {
        return verified;
    }

    public String getUrl()
    {
        return url;
    }

    public String getReferralId()
    {
        return referralId;
    }

    public ContactVO getContact()
    {
        return contact;
    }

    public LocationVO getLocation()
    {
        return location;
    }

    public SpecialsVO getSpecials()
    {
        return specials;
    }

    public ArrayList<CategoriesVO> getCategories()
    {
        return categories;
    }

    public StatsVO getStats()
    {
        return stats;
    }

    public HereNowVO getHereNow()
    {
        return hereNow;
    }


    public double getRating()
    {
        return rating;
    }

    public PhotosVO getPhotos()
    {
        return photos;
    }
}
