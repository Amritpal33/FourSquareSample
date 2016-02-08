package com.dinout.foursquaresample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.dinout.foursquaresample.MainActivity;
import com.dinout.foursquaresample.R;
import com.dinout.foursquaresample.services.controllers.ApplicationController;
import com.dinout.foursquaresample.services.iWebServiceResponseListener;
import com.dinout.foursquaresample.services.models.VenuesVO;
import com.dinout.foursquaresample.services.processors.VenueListDataProcessor;
import com.dinout.foursquaresample.services.processors.iSectionDataProcessor;
import com.dinout.foursquaresample.ui.OnListItemClickListener;
import com.dinout.foursquaresample.ui.views.VenuesListview;
import com.dinout.foursquaresample.utils.ApplicationInfo;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class LandingFragment extends BaseFragment implements iWebServiceResponseListener, OnListItemClickListener
{

    private VenuesListview _venuesListview;

    @Override
    protected int getFragmentLayoutId()
    {
        return R.layout.fragment_main;
    }

    @Override
    protected int getContainerViewGroupId()
    {
        return R.id.lvVenues;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        _venuesListview = (VenuesListview) view.findViewById(R.id.lvVenues);
        _venuesListview.init(this);
        executeWebService();

    }


    private void executeWebService()
    {
        showStatus(STATUS.STATUS_LOADING, 0);
        ApplicationController.getInstance().getWebServiceManager().createGetRequest(this, new VenueListDataProcessor(), ApplicationInfo.getVenueListRequest("40.7,-74"));
    }

    @Override
    public void onWebServiceSuccess(iSectionDataProcessor sectionDataProcessor)
    {
        showStatus(STATUS.STATUS_SUCCESS, 0);
        if (sectionDataProcessor instanceof VenueListDataProcessor)
        {

            VenueListDataProcessor processor = (VenueListDataProcessor) sectionDataProcessor;
            _venuesListview.setData(processor.getVenuesVO());
        }
    }

    @Override
    public void onWebServiceFailed()
    {
        showStatus(STATUS.STATUS_NETWORK_ERROR, 0);
    }

    @Override
    public void onListItemClick(View v, VenuesVO venue)
    {
        VenuesDetailsFragment fragment = new VenuesDetailsFragment();
        fragment.setVenue(venue);
        ((MainActivity) getActivity()).navigateTo(fragment, true, true);
    }

    @Override
    public void refreshActiveFragment()
    {
        if (_venuesListview.getList() == null || _venuesListview.getList().size() == 0)
        {
            executeWebService();
        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (_venuesListview != null)
        {
            _venuesListview.onDestroy();
            _venuesListview = null;
        }
    }
}
