package com.example.consumirapirestful;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.consumirapirestful.Interface.Interface;
import com.example.consumirapirestful.Modelo.InfoUser;
import com.example.consumirapirestful.Modelo.ModeloMeta;


import org.json.JSONArray;
import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnRetroFit;
    Button btnVolley;

    private TextView lblJsonDatitos;
    private TextView lbltext;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRetroFit = findViewById(R.id.btnRetrofit);
        btnVolley = findViewById(R.id.btnVolley);
        lblJsonDatitos = findViewById(R.id.lblDatitos);
        lbltext=findViewById(R.id.lbltextito);
        requestQueue = Volley.newRequestQueue(this);
        btnRetroFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetroFit();
            }
        });

        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIvolley();
            }
        });

    }


    private void RetroFit() {

        lbltext.append("Información con RetroFit\n\n");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gorest.co.in/public/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface interfacee = retrofit.create(Interface.class);
        Call<ModeloMeta> InfoUser = interfacee.getIncritosPais();
        InfoUser.enqueue(new Callback<ModeloMeta>() {
            @Override
            public void onResponse(Call<ModeloMeta> call, Response<ModeloMeta> response) {
                ModeloMeta body = response.body();
                for (InfoUser usuario : body.getData()) {
                    String InfoUsuario = ""; InfoUsuario += "id:" + usuario.getid() + "\n";
                    InfoUsuario += "name:" + usuario.getname() + "\n";
                    InfoUsuario += "email:" + usuario.getemail() + "\n";
                    InfoUsuario += "gender:" + usuario.getgender() + "\n";
                    InfoUsuario += "status:" + usuario.getstatus() + "\n\n";
                    lblJsonDatitos.append(InfoUsuario);


                }

            }

            @Override
            public void onFailure(Call<ModeloMeta> call, Throwable t) {

            }
        });


    }





    public void APIvolley() {

        lbltext.append("Información con Volley\n\n");
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        String url = "https://gorest.co.in/public/v1/users";
        JsonObjectRequest jsonAr = new JsonObjectRequest(Request.Method.GET,
                url, null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray U = response.getJSONArray("data");
                    for (int i = 0; i < U.length(); i++) {

                        JSONObject info= new JSONObject(U.get(i).toString());

                       int id;
                       String email, gender, status,name;

                       id=info.getInt("id");
                        name=info.getString("name");
                       email=info.getString("email");
                       gender=info.getString("gender");
                       status=info.getString("status");

                       String cadena="id: " +id +"\n" + "name: " + name +"\n"+"email: " +email +"\n" + "gender: " + gender +"\n" +"status: " + status +"\n\n\n";

                        lblJsonDatitos.append(cadena);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //lblJsonDatitos.append("Response: "+ response.toString());

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                lblJsonDatitos.setText(error.getMessage());
            }
        }
        );
        queue.add(jsonAr);


    }


}






