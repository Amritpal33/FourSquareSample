package com.dinout.foursquaresample.services.controllers;

import com.dinout.foursquaresample.services.iWebServiceResponseListener;
import com.dinout.foursquaresample.services.network.DataFetcher;
import com.dinout.foursquaresample.services.processors.iSectionDataProcessor;
import com.dinout.foursquaresample.services.request.RequestBuilder;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class WebServiceManager
{
    public void createGetRequest(iWebServiceResponseListener listener, iSectionDataProcessor responseProcessor, String url)
    {
        this.createRequest(listener, responseProcessor, url, null);
    }

    public void createPostRequest(iWebServiceResponseListener listener, iSectionDataProcessor responseProcessor, String url, String requestBody)
    {
        this.createRequest(listener, responseProcessor, url, requestBody);
    }

    private void createRequest(iWebServiceResponseListener listener, iSectionDataProcessor responseProcessor, String url, String requestBody)
    {
        RequestBuilder request = new RequestBuilder().generateRequest(url, requestBody);
        new DataFetcher().fetchData(request, responseProcessor, listener);
    }
}
