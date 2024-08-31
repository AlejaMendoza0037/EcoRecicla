package com.example.ecorecicla.models;

import android.util.Log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Recycling {


    //private LocalDateTime     dateTime;       //fecha y hora automatica
    public Date                dateTime;
    public double               gains;          // ganancias
    public ArrayList<Material>         materials;      //hacemos un arreglo con todos los materiales, meto todos los materiales que quiero


    public Recycling() {

        //this.dateTime=        LocalDateTime.now();
        this.dateTime =         new Date();
        this.gains =            0;
        this.materials =        new ArrayList<Material>();
    }

    public Recycling( Date dateTime, double gains, ArrayList<Material> materials) {

        // this.dateTime=               LocalDateTime.now();
        this.dateTime = dateTime !=     null ? dateTime : new Date();//// Si dateTime es nulo, se asigna la fecha y hora actuales
        this.gains =                    gains;
        this.materials =                materials;

    }


    public void addMaterial(Material material){
        this.materials.add(material);

    }

    public void calculateTotalGains(){
        this.gains=0;
        for (Material m : this.materials) {
            this.gains = this.gains+ m.gain;
        }
    }




    public void showMaterials(){
        for (Material m : this.materials) {
            Log.e("msh", "Material:" +m.name);
            Log.e("msh", "Precio" +m.price);
            Log.e("msh", "Peso" +m.weight);
            Log.e("msh", "Ganancia" +m.gain);
            Log.e("msh", ":::::::::::::::::::::::: ");


        }
        this.calculateTotalGains();

        Log.e("msh", "La ganancia total es: " + this.gains);


    }
}