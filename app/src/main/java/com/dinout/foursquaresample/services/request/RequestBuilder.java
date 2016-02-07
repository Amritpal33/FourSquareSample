package com.dinout.foursquaresample.services.request;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class RequestBuilder
{
    //REQUEST_TYPE type, iWebServiceResponseListener listener, List<RequestParams> queryParams, String requestBody)

    String _requestUrl;
    String _requestBody;

    public RequestBuilder()
    {
    }

    public RequestBuilder generateRequest(String url, String requestBody)
    {
        _requestUrl = url;
        _requestBody = requestBody;
        return this;
    }

    public String getRequestUrl()
    {
        return _requestUrl;
    }

    public String getRequestBody()
    {
        return _requestBody;
    }


}
