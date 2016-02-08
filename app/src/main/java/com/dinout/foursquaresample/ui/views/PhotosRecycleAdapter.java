package com.dinout.foursquaresample.ui.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dinout.foursquaresample.R;
import com.dinout.foursquaresample.services.models.PhotosVO;
import com.dinout.foursquaresample.ui.OnPhotoItemClickListener;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by amritpalsingh on 08/02/16.
 */
public class PhotosRecycleAdapter extends RecyclerView.Adapter<PhotosRecycleAdapter.ViewHolder>
{
    ArrayList<PhotosVO.PhotoGroups.PhotoItems> _photosList;
    WeakReference<OnPhotoItemClickListener> _listenerWeakReference;

    public PhotosRecycleAdapter(ArrayList<PhotosVO.PhotoGroups.PhotoItems> photosList, OnPhotoItemClickListener listener)
    {
        _photosList = photosList;
        _listenerWeakReference = new WeakReference<OnPhotoItemClickListener>(listener);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.setData(_photosList.get(position).getPhotoUrl());
    }

    @Override
    public int getItemCount()
    {
        return _photosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ViewHolder(View itemView)
        {
            super(itemView);
        }

        public void setData(String url)
        {
            ImageView imageView = (ImageView) itemView;
            Picasso.with(itemView.getContext()).load(url).into(imageView);
            itemView.setOnClickListener(this);
            itemView.setTag(url);
        }

        @Override
        public void onClick(View v)
        {
            _listenerWeakReference.get().onListItemClick(v, (String) v.getTag());
        }
    }
}
