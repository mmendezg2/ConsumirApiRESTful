package com.example.consumirapirestful.Modelo;

import java.util.List;

public class ModeloMeta {

List<InfoUser> data;

    public ModeloMeta(List<InfoUser> data) {
        this.data = data;
    }

    public ModeloMeta() {
    }

    public List<InfoUser> getData() {
        return data;
    }

    public void setData(List<InfoUser> data) {
        this.data = data;
    }
}
