package com.dinout.foursquaresample.services.models;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class GroupVO
{
    ArrayList<ItemVO> items;

    public static class ItemVO
    {
        VenuesVO venue;

        public VenuesVO getVenues()
        {
            return venue;
        }
    }

    public ArrayList<ItemVO> getItems()
    {
        return items;
    }
}
