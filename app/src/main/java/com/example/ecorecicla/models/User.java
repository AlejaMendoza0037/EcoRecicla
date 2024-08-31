package com.example.ecorecicla.models;

import android.util.Log;

import java.util.ArrayList;

public class User {


    public String           name;
    public String           surname;
    public String           imageProfile;
    public int              age;
    public String           email;
    public String           password;
    public String           gender;
    public double           grandTotalGains;
    ArrayList<Recycling>    recyclings;        //el usuario tiene muchos reciclajes

    public User(){
        this.name=              "";
        this.surname=           "";
        this.age=               0;
        this.email=             "";
        this.password=          "";
        this.gender=            "";
        this.imageProfile=      "";
        this.grandTotalGains=        0;
        this.recyclings=        new ArrayList<Recycling>();// cada vez que creo un usuario se me crea un arreglo vacio de reciclaje
    }

    public User(String name, String surname, String imageProfile, int age, String email, String password, String gender, double grandTotalGains){
        this.name=              name;
        this.surname=           surname;
        this.imageProfile=      imageProfile;
        this.age=               age;
        this.email=             email;
        this.password=          password;
        this.gender=            gender;
        this.grandTotalGains=   grandTotalGains;
        this.recyclings=        new ArrayList<Recycling>();

    }

    public void addRecycling(Recycling recycling){//el usuario agrega un nuevo reciclaje
        this.recyclings.add(recycling);
    }

    public void calculateGranTotalGains(){
        for(Recycling i: this.recyclings){
            this.grandTotalGains= this.grandTotalGains + i.gains;
        }
    }

    public void showRecyclings(){
        Log.e("msh", ":::::::::::::::::::::::: ");
        Log.e("msh", "Reciclajes de : " + this.name);
        Log.e("msh", ":::::::::::::::::::::::: ");
        for(Recycling i: this.recyclings){
            Log.e("msh", ":::::::::::::::::::::::: ");
            Log.e("msg", "Reciclaje: " +  i.dateTime );
            Log.e("msh", ":::::::::::::::::::::::: ");


            i.showMaterials();

        }
        this.calculateGranTotalGains();
        Log.e("msh", "La ganancia total es: " + this.grandTotalGains);

    }



}
