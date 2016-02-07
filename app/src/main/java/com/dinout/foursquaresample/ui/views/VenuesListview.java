package com.dinout.foursquaresample.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.dinout.foursquaresample.services.models.VenuesVO;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class VenuesListview extends ListView
{

    private VenuesListAdapter _venuesListAdapter;

    public VenuesListview(Context context)
    {
        super(context);
    }

    public VenuesListview(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public VenuesListview(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        init();
    }

    private void init()
    {
        _venuesListAdapter = new VenuesListAdapter(getContext(), new ArrayList<VenuesVO>());
        setAdapter(_venuesListAdapter);
    }

    public void setData(ArrayList<VenuesVO> dataList)
    {
        if (_venuesListAdapter != null)
        {
            _venuesListAdapter.addData(dataList);
        }

    }
}
