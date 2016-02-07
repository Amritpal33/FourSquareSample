package com.dinout.foursquaresample.services.network;

import android.os.AsyncTask;

import com.dinout.foursquaresample.services.iWebServiceResponseListener;
import com.dinout.foursquaresample.services.processors.iSectionDataProcessor;
import com.dinout.foursquaresample.services.request.RequestBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Amritpal.Makkar on 04-feb-16.
 */
public class DataFetcher
{

    private iSectionDataProcessor _processor;
    private WeakReference<iWebServiceResponseListener> _listener;

    protected final static int REQUEST_READ_TIME_OUT = 10000;
    protected final static int REQUEST_CONNECTION_TIME_OUT = 15000;

    public void fetchData(RequestBuilder request, iSectionDataProcessor processor, iWebServiceResponseListener listener)
    {
        _processor = processor;
        _listener = new WeakReference<iWebServiceResponseListener>(listener);
        new DataFetcherTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, request);
    }

    private class DataFetcherTask extends AsyncTask<RequestBuilder, Object, Boolean>
    {
        @Override
        protected Boolean doInBackground(RequestBuilder... params)
        {
            String response = executeNetworkRequest(params[0]);
            return _processor.parseData(response);
        }

        private String executeNetworkRequest(RequestBuilder requestBuilder)
        {
            URL url;
            HttpURLConnection connection = null;
            try
            {
                url = new URL(requestBuilder.getRequestUrl());
                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(REQUEST_READ_TIME_OUT);
                connection.setConnectTimeout(REQUEST_CONNECTION_TIME_OUT);
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                //connection.setRequestProperty("Accept", "application/json");

                connection.setUseCaches(false);
                //connection.setDoInput(false);
                //connection.setDoOutput(true);

                int statusCode = connection.getResponseCode();
                if (statusCode != HttpURLConnection.HTTP_OK)
                {
                    throw new Exception();
                }
                //Get Response
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = rd.readLine()) != null)
                {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                return response.toString();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                return null;// we can create custom classes to handle multiple type of scenerios.
            }
            finally
            {
                if (connection != null)
                {
                    connection.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(Boolean result)
        {
            if (result)
            {
                if (_listener != null)
                {
                    _listener.get().onWebServiceSuccess(_processor);
                }
            }
            else
            {
                if (_listener != null)
                {
                    _listener.get().onWebServiceFailed();
                }
            }
        }
    }
}
