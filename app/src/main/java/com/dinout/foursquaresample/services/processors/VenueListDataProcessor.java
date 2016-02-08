package com.dinout.foursquaresample.services.processors;

import android.util.Log;

import com.dinout.foursquaresample.services.models.GroupVO;
import com.dinout.foursquaresample.services.models.VenuesVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 07/02/16.
 */
public class VenueListDataProcessor implements iSectionDataProcessor
{
    ArrayList<VenuesVO> _venuesVO;

    public VenueListDataProcessor()
    {
        _venuesVO = new ArrayList<>();
    }

    @Override
    public boolean parseData(Object responseObject)
    {
        try
        {
            JSONObject response = new JSONObject((String) responseObject);
            JSONObject metaObject = response.optJSONObject("meta");
            int code = metaObject.optInt("code");
            if (code == 200)
            {
                Gson gson = new Gson();

                ArrayList<GroupVO> groupVOs = gson.fromJson(response.optJSONObject("response").optJSONArray("groups").toString(), new TypeToken<ArrayList<GroupVO>>()
                {
                }.getType());


                ArrayList<GroupVO.ItemVO> itemVOs = groupVOs.get(0).getItems();
                for (int i = 0; i < itemVOs.size(); i++)
                {
                    _venuesVO.add(itemVOs.get(i).getVenues());
                }

                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public ArrayList<VenuesVO> getVenuesVO()
    {
        return _venuesVO;
    }
}
