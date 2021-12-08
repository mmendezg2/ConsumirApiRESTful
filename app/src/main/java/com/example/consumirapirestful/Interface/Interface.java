package com.example.consumirapirestful.Interface;

import com.example.consumirapirestful.Modelo.ModeloMeta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {
    @GET("users")
    Call <ModeloMeta> getIncritosPais();

}
