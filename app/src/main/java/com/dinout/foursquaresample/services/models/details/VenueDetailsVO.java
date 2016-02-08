package com.dinout.foursquaresample.services.models.details;

import com.dinout.foursquaresample.services.models.PhotosVO;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 08/02/16.
 */

public class VenueDetailsVO
{
    private LikesVO likes;
    private StatsVO stats;
    private HereNowVO hereNow;
    private SpecialsVO specials;
    private ArrayList<CategoriesVO> categories;
    private boolean verified;
    private String url;
    private String referralId;
    private ContactVO contact;
    private PhotosVO photos;
    private ReviewsVO tips;

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

    public LikesVO getLikes()
    {
        return likes;
    }

    public ReviewsVO getTips()
    {
        return tips;
    }

    public PhotosVO getPhotos()
    {
        return photos;
    }
}
