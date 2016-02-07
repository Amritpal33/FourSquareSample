package com.dinout.foursquaresample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dinout.foursquaresample.R;
import com.dinout.foursquaresample.services.controllers.ApplicationController;
import com.dinout.foursquaresample.services.iWebServiceResponseListener;
import com.dinout.foursquaresample.services.processors.VenueListDataProcessor;
import com.dinout.foursquaresample.services.processors.iSectionDataProcessor;
import com.dinout.foursquaresample.ui.views.VenuesListview;
import com.dinout.foursquaresample.utils.ApplicationInfo;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class LandingFragment extends Fragment implements iWebServiceResponseListener
{

    private VenuesListview _venuesListview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        _venuesListview = (VenuesListview) view.findViewById(R.id.lvVenues);
        ApplicationController.getInstance().getWebServiceManager().createGetRequest(this, new VenueListDataProcessor(), ApplicationInfo.getVenueDetailsUrl("40.7,-74"));
    }


    @Override
    public void onWebServiceSuccess(iSectionDataProcessor sectionDataProcessor)
    {
        Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
        if (sectionDataProcessor instanceof VenueListDataProcessor)
        {
            VenueListDataProcessor processor = (VenueListDataProcessor) sectionDataProcessor;
            _venuesListview.setData(processor.getVenuesVO());
        }


    }

    @Override
    public void onWebServiceFailed()
    {
        Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT).show();
    }
}
