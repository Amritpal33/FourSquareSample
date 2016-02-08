package com.dinout.foursquaresample.services.processors;

import com.dinout.foursquaresample.services.models.GroupVO;
import com.dinout.foursquaresample.services.models.details.VenueDetailsVO;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 08/02/16.
 */
public class VenueDetailsDataProcessor implements iSectionDataProcessor
{
    VenueDetailsVO _venueDetailsVO;

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

                _venueDetailsVO = gson.fromJson(response.optJSONObject("response").optJSONObject("venue").toString(), VenueDetailsVO.class);
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

    public VenueDetailsVO getVenueDetailsVO()
    {
        return _venueDetailsVO;
    }
}
