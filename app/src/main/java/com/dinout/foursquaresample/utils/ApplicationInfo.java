package com.dinout.foursquaresample.utils;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class ApplicationInfo
{
    private static final String CLIENT_ID = "BFMTPG3I4RH2DBYL11LLRH2G5OTPXACX51DK0UJ1TMIQSDRC";
    private static final String CLIENT_SECRET = "IEPTDICHBVMAWD4415HCXRMB5XWR0IY1B0T5JB0RKDKA1GBF";

    private static final String BASE_URL = "https://api.foursquare.com/v2";
    private static final String VENUE_EXPLORE = "/venues/explore";
    private static final String CURRENT_VERSION_DATE="20160207";

    public static String getVenueDetailsUrl(String location)
    {
        return String.format("%s%s?ll=%s&client_id=%s&venuePhotos=1&client_secret=%s&v=%s", BASE_URL, VENUE_EXPLORE, location, CLIENT_ID, CLIENT_SECRET,CURRENT_VERSION_DATE);
    }



}
