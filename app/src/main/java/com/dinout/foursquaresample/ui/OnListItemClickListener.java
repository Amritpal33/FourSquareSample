package com.dinout.foursquaresample.ui;

import android.view.View;

import com.dinout.foursquaresample.services.models.VenuesVO;

/**
 * Created by amritpalsingh on 08/02/16.
 */
public interface OnListItemClickListener
{
    public void onListItemClick(View v, VenuesVO venue);
}
