//package com.karthick.mapsapp;
//
//import android.app.Application;
//import android.content.Context;
//import android.os.AsyncTask;
//import android.widget.Toast;
//import android.widget.Toolbar;
//
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.gson.JsonArray;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class FetchNearbyPlaces extends AsyncTask<Object, String, String> {
//
//    GoogleMap mMap;
//    String url;
//    InputStream is;
//    BufferedReader bufferedReader;
//    StringBuilder stringBuilder;
//    String data;
//
//    @Override
//    protected String doInBackground(Object[] objects) {
//
//        mMap = (GoogleMap) objects[0];
//        url = (String) objects[1];
//
//        try {
//            URL myUrl = new URL(url);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) myUrl.openConnection();
//            httpURLConnection.connect();
//            is = httpURLConnection.getInputStream();
//            bufferedReader = new BufferedReader(new InputStreamReader(is));
//
//            String line = "";
//            stringBuilder = new StringBuilder();
//
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//            data = stringBuilder.toString();
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//        }
//
//        return data;
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//
//        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
//
//        try {
//            JSONObject parentObject = new JSONObject(s);
//            JSONArray resultsArray = parentObject.getJSONArray("results");
//
//            for (int i = 0; i < resultsArray.length(); i++) {
//                JSONObject jsonObject = resultsArray.getJSONObject(i);
//                JSONObject locationObject = jsonObject.getJSONObject("geometry").getJSONObject("location");
//
//                String latitude = locationObject.getString("lat");
//                String longitude = locationObject.getString("lng");
//
//                JSONObject nameObject = resultsArray.getJSONObject(i);
//                String name_restaurant = nameObject.getString("name");
//                String vicinity = nameObject.getString("vicinity");
//
//                LatLng latLng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
//
//                MarkerOptions markerOptions = new MarkerOptions();
//                markerOptions.title(vicinity);
//                markerOptions.position(latLng);
//                mMap.addMarker(markerOptions);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
