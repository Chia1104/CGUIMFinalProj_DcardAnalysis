package com.example.cguimfinalproj_dcardanalysis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnTest, btnChartTest;
    RecyclerView mRecyclerView;
    List<Dcard> dcardList;
    private static final String DCARD_URL = "http://192.168.0.104:13306/GetData4.php";
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        dcardList = new ArrayList<>();

        loadDcard();

        btnTest = findViewById(R.id.btnTest);
        btnTest.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, PageTest1.class));
        });
        btnChartTest = findViewById(R.id.btnChartTest);
        btnTest.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, PageTest2.class));
        });
    }

    private void loadDcard(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, DCARD_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject dcardObject = response.getJSONObject(i);

                        Dcard dcard = new Dcard();
                        dcard.setTitle(dcardObject.getString("Title"));
                        dcard.setDate(dcardObject.getString("CreatedAt"));
                        dcard.setContent(dcardObject.getString("Content"));
                        dcardList.add(dcard);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(), dcardList);
                mRecyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonArrayRequest);

    }
}