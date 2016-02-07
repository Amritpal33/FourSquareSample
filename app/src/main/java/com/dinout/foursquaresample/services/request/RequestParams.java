package com.dinout.foursquaresample.services.request;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class RequestParams
{
    String _paramKey;
    String _paramValue;

    public RequestParams(String key, String value)
    {
        _paramKey = key;
        _paramValue = value;
    }

    public String getParamKey()
    {
        return _paramKey;
    }

    public String getParamValue()
    {
        return _paramValue;
    }
}
