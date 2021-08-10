//package com.example.cguimfinalproj_dcardanalysis;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.toolbox.StringRequest;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SQLDataBaseHelper {
//
//    private List<Dcard> dcardList = new ArrayList<>();
//    private static final String DCARD_URL = "http://192.168.0.104:13306/GetData4.php";
//    private RequestQueue queue;
//
//    public interface DataStatus {
//        void DataIsLoaded(List<Dcard> dcards);
//    }
//
//    public void readDcard(final DataStatus dataStatus){
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, DCARD_URL,
//                response -> {
//                    try {
//                        JSONArray dcards = new JSONArray(response);
//
//                        for (int i = 0; i<dcards.length(); i++) {
//                            JSONObject dcardObject = dcards.getJSONObject(i);
//
//                            String title = dcardObject.getString("Title");
//                            String content = dcardObject.getString("Content");
//                            String date = dcardObject.getString("CreatedAt");
//
//                            Dcard dcard = new Dcard(title, content, date);
//                            dcardList.add(dcard);
//                        }
//                        dataStatus.DataIsLoaded((List<Dcard>) dcards);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//                error -> {
//
//                });
////        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);///******///
//    }
//}
