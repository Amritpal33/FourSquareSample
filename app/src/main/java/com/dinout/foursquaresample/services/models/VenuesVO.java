package com.dinout.foursquaresample.services.models;

import com.dinout.foursquaresample.services.models.details.VenueDetailsVO;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class VenuesVO
{
    private String id;
    private String name;
    private LocationVO location;
    private PhotosVO photos;
    private double rating;
    private VenueDetailsVO _venueDetailsVO;

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public LocationVO getLocation()
    {
        return location;
    }

    public double getRating()
    {
        return rating;
    }

    public PhotosVO getPhotos()
    {
        return photos;
    }

    public void setVenueDetailsVO(VenueDetailsVO venueDetailsVO)
    {
        _venueDetailsVO = venueDetailsVO;
    }

    public VenueDetailsVO getVenueDetailsVO()
    {
        return _venueDetailsVO;
    }
}
