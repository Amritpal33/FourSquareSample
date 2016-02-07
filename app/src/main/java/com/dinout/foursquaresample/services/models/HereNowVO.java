package com.dinout.foursquaresample.services.models;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class HereNowVO
{
    int count;
    String summary;
    ArrayList<Groups> groups;

    public int getCount()
    {
        return count;
    }

    public String getSummary()
    {
        return summary;
    }

    public ArrayList<Groups> getGroups()
    {
        return groups;
    }

    private static class Groups
    {
        private String type;
        private int count;
        private ArrayList<String> items;
    }
}
