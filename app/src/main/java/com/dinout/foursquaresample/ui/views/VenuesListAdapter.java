package com.dinout.foursquaresample.ui.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinout.foursquaresample.R;
import com.dinout.foursquaresample.services.models.VenuesVO;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class VenuesListAdapter extends BaseAdapter
{
    private ArrayList<VenuesVO> _venuesVOs;
    private Context _context;

    public VenuesListAdapter(Context context, ArrayList<VenuesVO> venuesVOs)
    {
        _venuesVOs = venuesVOs;
        _context = context;
    }

    @Override
    public int getCount()
    {
        return _venuesVOs.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        ViewHolder holder = null;
        if (view == null)
        {
            view = LayoutInflater.from(_context).inflate(R.layout.venue_row_layout, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        holder.setData(_context, _venuesVOs.get(position));
        return view;
    }

    private static class ViewHolder
    {
        ImageView _venueImage;
        TextView _venueName;
        TextView _venueAddress;
        TextView _venueRating;

        ViewHolder(View view)
        {
            _venueImage = (ImageView) view.findViewById(R.id.imgVenue);
            _venueName = (TextView) view.findViewById(R.id.tvVenueName);
            _venueAddress = (TextView) view.findViewById(R.id.tvVenueAddress);
            _venueRating = (TextView) view.findViewById(R.id.tvVenueRating);
        }

        public void setData(Context context, VenuesVO data)
        {
            Picasso.with(context).load(data.getPhotos().getDefaultPhotoUrl()).into(_venueImage);
            _venueName.setText(data.getName());
            _venueAddress.setText(String.format("%s, %s, %s", data.getLocation().getAddress(), data.getLocation().getCrossStreet(), data.getLocation().getCity()));
            _venueRating.setText("Rating: " + new DecimalFormat("#0.0").format(data.getRating()));
        }
    }

    public ArrayList<VenuesVO> getVenuesVOs()
    {
        return _venuesVOs;
    }

    public void addData(ArrayList<VenuesVO> venuesVOs)
    {
        if (_venuesVOs != null)
        {
            _venuesVOs.clear();
            _venuesVOs.addAll(venuesVOs);
            notifyDataSetChanged();
        }

    }
}
