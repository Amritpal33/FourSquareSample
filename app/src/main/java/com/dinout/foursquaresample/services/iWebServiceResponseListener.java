package com.dinout.foursquaresample.services;

import com.dinout.foursquaresample.services.processors.iSectionDataProcessor;

/**
 * Created by Amritpal.Makkar on 04-feb-16.
 */
public interface iWebServiceResponseListener
{
    public void onWebServiceSuccess(iSectionDataProcessor sectionDataProcessor);

    public void onWebServiceFailed();
}
