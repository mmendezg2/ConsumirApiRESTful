package com.example.consumirapirestful.Modelo;



public class InfoUser {
    int id;
    String name;
    String email;
    String gender;
    String status;

    public int getid() {
        return id;
    }

    public String getname(){
        return name;
    }

    public String getemail(){
        return email;
    }

    public String getgender(){
        return gender;
    }

    public String getstatus(){
        return status;
    }

    public void setid(int id) {

        this.id=id;
    }

    public void setname(String name) {

        this.name = name;
    }
    public void setemail(String email) {

        this.email = email;
    }

    public void setgender(String gender) {

        this.gender = gender;
    }

    public void setstatus(String status) {

        this.status = status;
    }

    public InfoUser(int id, String name, String email, String gender, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public InfoUser() {
    }
}
