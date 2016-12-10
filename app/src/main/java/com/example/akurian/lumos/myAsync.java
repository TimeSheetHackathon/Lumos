package com.example.akurian.lumos;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/**
 * Created by akurian on 12/10/16.
 */
class myAsync extends AsyncTask<Void, Void, Void> {

    HashMap<String, String> idName = new HashMap<>();
    String outputString="[{\"role\":\"Project Manager\",\"home-office\":\"San Francisco\",\"name\":\"Newton,Scott E.\",\"monthend\":\"2016-09-30\",\"actual-hours\":1,\"grade\":\"Principal Consultant\",\"id\":\"10111\",\"staffing-office\":\"San Francisco\",\"weekend\":\"2016-09-18\",\"country\":\"US\",\"working-office\":\"San Francisco\"},{\"role\":\"Developer\",\"home-office\":\"Recife\",\"name\":\"Santana,Amanda Silva\",\"monthend\":\"2016-09-30\",\"actual-hours\":40,\"grade\":\"Consultant - Graduate\",\"id\":\"18646\",\"staffing-office\":\"Recife\",\"weekend\":\"2016-10-02\",\"country\":\"US\",\"working-office\":\"San Francisco\"},{\"role\":\"Experience Designer\",\"home-office\":\"Brisbane\",\"name\":\"Carter,Emma Jane\",\"monthend\":\"2016-09-30\",\"actual-hours\":40,\"grade\":\"Lead Consultant\",\"id\":\"17073\",\"staffing-office\":\"Brisbane\",\"weekend\":\"2016-09-18\",\"country\":\"Australia\",\"working-office\":\"Brisbane\"},{\"role\":\"Quality Assurance\",\"home-office\":\"Bangalore\",\"name\":\"Subramanya Hegde,Shweta\",\"monthend\":\"2016-09-30\",\"actual-hours\":40,\"grade\":\"Senior Consultant\",\"id\":\"15628\",\"staffing-office\":\"Bangalore\",\"weekend\":\"2016-09-25\",\"country\":\"India\",\"working-office\":\"Bangalore\"},{\"role\":\"Project Manager\",\"home-office\":\"San Francisco\",\"name\":\"Newton,Scott E.\",\"monthend\":\"2016-09-30\",\"actual-hours\":1,\"grade\":\"Principal Consultant\",\"id\":\"10111\",\"staffing-office\":\"San Francisco\",\"weekend\":\"2016-10-02\",\"country\":\"US\",\"working-office\":\"San Francisco\"},{\"role\":\"Project Manager\",\"home-office\":\"San Francisco\",\"name\":\"Newton,Scott E.\",\"monthend\":\"2016-09-30\",\"actual-hours\":0.4,\"grade\":\"Principal Consultant\",\"id\":\"10111\",\"staffing-office\":\"San Francisco\",\"weekend\":\"2016-09-04\",\"country\":\"US\",\"working-office\":\"San Francisco\"},{\"role\":\"Developer\",\"home-office\":\"Chengdu\",\"name\":\"Xue,Tao\",\"monthend\":\"2016-09-30\",\"actual-hours\":40,\"grade\":\"Consultant\",\"id\":\"19142\",\"staffing-office\":\"Chengdu\",\"weekend\":\"2016-09-18\",\"country\":\"China\",\"working-office\":\"Wuhan\"},{\"role\":\"Project Manager\",\"home-office\":\"San Francisco\",\"name\":\"Newton,Scott E.\",\"monthend\":\"2016-09-30\",\"actual-hours\":1,\"grade\":\"Principal Consultant\",\"id\":\"10111\",\"staffing-office\":\"San Francisco\",\"weekend\":\"2016-09-11\",\"country\":\"US\",\"working-office\":\"San Francisco\"},{\"role\":\"Product/Support Analyst\",\"home-office\":\"San Francisco\",\"name\":\"Pandya,Ashley\",\"monthend\":\"2016-09-30\",\"actual-hours\":16,\"grade\":\"Senior Consultant\",\"id\":\"16813\",\"staffing-office\":\"San Francisco\",\"weekend\":\"2016-09-11\",\"country\":\"US\",\"working-office\":\"New York\"},{\"role\":\"Project Manager\",\"home-office\":\"San Francisco\",\"name\":\"Newton,Scott E.\",\"monthend\":\"2016-09-30\",\"actual-hours\":1,\"grade\":\"Principal Consultant\",\"id\":\"10111\",\"staffing-office\":\"San Francisco\",\"weekend\":\"2016-09-25\",\"country\":\"US\",\"working-office\":\"San Francisco\"},{\"role\":\"Developer\",\"home-office\":\"Melbourne\",\"name\":\"Gandhi,Nikita Parimalkumar\",\"monthend\":\"2016-09-30\",\"actual-hours\":6.4,\"grade\":\"Consultant\",\"id\":\"14384\",\"staffing-office\":\"Melbourne\",\"weekend\":\"2016-09-25\",\"country\":\"Australia\",\"working-office\":\"Melbourne\"}]";
//    StringBuilder output;

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
//        output = getUrlContents("http://10.132.22.18:3000/api/utilisation/2016/9/missing-timesheets");

    }

    @Override
    protected Void doInBackground(Void... params) {

        // TODO Auto-generated method stub
//        output = getUrlContents("http://10.132.22.18:3000/api/utilisation/2016/9/missing-timesheets");
//         output = new StringBuilder();

//        try
//        {
//            URL url = new URL("http://10.132.22.18:3000/api/utilisation/2016/9/missing-timesheets");
//
//            URLConnection urlConnection = url.openConnection();
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null)
//            {
//                output.append(line + "\n");
//            }
//            bufferedReader.close();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        outputString=output.toString();



        JSONArray jsonArr = null;
        try {
            jsonArr = new JSONArray(outputString);


            for (int i = 0; i < jsonArr.length(); i++)
            {
                JSONObject jsonObj = jsonArr.getJSONObject(i);
                idName.put(jsonObj.get("id").toString(), jsonObj.get("name").toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

//    private String getUrlContents(String theUrl) {
//
//
//
//        return content.toString();
//
//    }
    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        // Handle/Update UI Part
    }
}