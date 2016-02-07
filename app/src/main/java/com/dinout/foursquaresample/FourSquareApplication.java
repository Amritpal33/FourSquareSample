package com.dinout.foursquaresample;

import android.app.Application;

import com.dinout.foursquaresample.services.controllers.ApplicationController;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class FourSquareApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        ApplicationController.getInstance().init();
    }
}
