package com.dinout.foursquaresample.ui.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.dinout.foursquaresample.services.models.PhotosVO;
import com.dinout.foursquaresample.ui.OnPhotoItemClickListener;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 08/02/16.
 */
public class PhotosRecycler extends RecyclerView
{
    private LinearLayoutManager linearLayoutManager;
    private boolean _isInited = false;
    private PhotosRecycleAdapter _photosRecycleAdapter;

    public PhotosRecycler(Context context)
    {
        super(context);
    }

    public PhotosRecycler(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PhotosRecycler(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        initialize();
    }

    private void initialize()
    {
        if (!_isInited)
        {
            _isInited = true;
            linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            this.setLayoutManager(linearLayoutManager);
        }
    }

    public void setRecyclerData(ArrayList<PhotosVO.PhotoGroups.PhotoItems> photosList,OnPhotoItemClickListener listener)
    {
        if (_photosRecycleAdapter == null)
        {
            _photosRecycleAdapter = new PhotosRecycleAdapter(photosList,listener);
            super.setAdapter(_photosRecycleAdapter);
        }
    }



}
