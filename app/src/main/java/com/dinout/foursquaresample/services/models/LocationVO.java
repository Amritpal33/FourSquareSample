package com.dinout.foursquaresample.services.models;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class LocationVO
{
    public String getAddress()
    {
        return address;
    }

    public String getCrossStreet()
    {
        return crossStreet;
    }

    public String getLat()
    {
        return lat;
    }

    public String getLng()
    {
        return lng;
    }

    public String getDistance()
    {
        return distance;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getCc()
    {
        return cc;
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public String getCountry()
    {
        return country;
    }

    public ArrayList<String> getFormattedAddress()
    {
        return formattedAddress;
    }

    private String address;
    private String crossStreet;
    private String lat;
    private String lng;
    private String distance;
    private String postalCode;
    private String cc;
    private String city;
    private String state;
    private String country;
    private ArrayList<String> formattedAddress;
}
