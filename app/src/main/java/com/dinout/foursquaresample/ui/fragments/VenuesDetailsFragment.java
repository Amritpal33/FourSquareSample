package com.dinout.foursquaresample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dinout.foursquaresample.ImageFullScreenActivity;
import com.dinout.foursquaresample.R;
import com.dinout.foursquaresample.services.controllers.ApplicationController;
import com.dinout.foursquaresample.services.iWebServiceResponseListener;
import com.dinout.foursquaresample.services.models.VenuesVO;
import com.dinout.foursquaresample.services.models.details.ReviewsVO;
import com.dinout.foursquaresample.services.processors.VenueDetailsDataProcessor;
import com.dinout.foursquaresample.services.processors.iSectionDataProcessor;
import com.dinout.foursquaresample.ui.OnPhotoItemClickListener;
import com.dinout.foursquaresample.ui.views.PhotosRecycler;
import com.dinout.foursquaresample.utils.ApplicationInfo;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by amritpalsingh on 08/02/16.
 */
public class VenuesDetailsFragment extends BaseFragment implements iWebServiceResponseListener, OnPhotoItemClickListener
{
    VenuesVO _venue;

    public VenuesDetailsFragment()
    {

    }

    public void setVenue(VenuesVO venue)
    {
        _venue = venue;
    }

    @Override
    protected int getFragmentLayoutId()
    {
        return R.layout.fragment_venue_details;
    }

    @Override
    protected int getContainerViewGroupId()
    {
        return R.id.containerVenueDetails;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        executeWebService();
    }


    private void executeWebService()
    {
        showStatus(STATUS.STATUS_LOADING, 0);
        ApplicationController.getInstance().getWebServiceManager().createGetRequest(this, new VenueDetailsDataProcessor(), ApplicationInfo.getVenueDetailsRequest(_venue.getId()));
    }

    @Override
    public void refreshActiveFragment()
    {

    }

    @Override
    public void onWebServiceSuccess(iSectionDataProcessor sectionDataProcessor)
    {
        Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
        if (sectionDataProcessor instanceof VenueDetailsDataProcessor)
        {
            VenueDetailsDataProcessor processor = (VenueDetailsDataProcessor) sectionDataProcessor;
            _venue.setVenueDetailsVO(processor.getVenueDetailsVO());
            setData();
        }
    }

    private void setData()
    {
        if (getView() == null)
        {
            return;
        }

        showStatus(STATUS.STATUS_SUCCESS, 0);
        View view = getView();

        if (_venue != null)
        {
            Picasso.with(getActivity()).load(_venue.getPhotos().getDefaultPhotoUrl()).into((ImageView) view.findViewById(R.id.imgPoster));
            ((TextView) view.findViewById(R.id.tvVenueName)).setText(_venue.getName());
            ((TextView) view.findViewById(R.id.tvTotalRating)).setText("Rating: " + new DecimalFormat("#0.0").format(_venue.getRating()));
            for (int i = 0; i < _venue.getLocation().getFormattedAddress().size(); i++)
            {
                ((TextView) view.findViewById(R.id.tvVenueAddress)).append(_venue.getLocation().getFormattedAddress().get(i) + "\n");
            }

            ((TextView) view.findViewById(R.id.tvTotalCheckins)).setText(String.format("Total Checkins: %d", _venue.getVenueDetailsVO().getStats().getCheckinsCount()));
            ((TextView) view.findViewById(R.id.tvTotalLikes)).setText(String.format("Summary: %s", _venue.getVenueDetailsVO().getLikes().getSummary()));
            PhotosRecycler recycler = (PhotosRecycler) view.findViewById(R.id.containerPhotos);
            recycler.setRecyclerData(_venue.getVenueDetailsVO().getPhotos().getGroups().get(0).getItems(), this);
            setReviews(view);
        }
    }


    private void setReviews(View view)
    {
        ArrayList<ReviewsVO.ReviewGroups.ReviewItems> items = _venue.getVenueDetailsVO().getTips().getGroups().get(0).getItems();
        LinearLayout container = (LinearLayout) view.findViewById(R.id.containerCustomerReviews);
        container.removeAllViews();
        for (int i = 0; i < items.size(); i++)
        {
            View v = LayoutInflater.from(getActivity()).inflate(R.layout.reviews_row_layout, null);
            ((TextView) v.findViewById(R.id.tvUserName)).setText(items.get(i).getUser().getUserName());
            ((TextView) v.findViewById(R.id.tvCreatedTime)).setText("" + items.get(i).getCreatedAt());
            ((TextView) v.findViewById(R.id.tvReviews)).setText("" + items.get(i).getText());
            Picasso.with(getActivity()).load(items.get(i).getUser().getPhoto().getUserPhotoUrl()).into((ImageView) v.findViewById(R.id.userImage));
            container.addView(v);
        }
    }


    @Override
    public void onWebServiceFailed()
    {
        showStatus(STATUS.STATUS_NETWORK_ERROR, 0);
    }

    @Override
    public void onListItemClick(View v, String url)
    {
        getActivity().startActivity(ImageFullScreenActivity.createIntent(getActivity(), url));
    }
}
