package com.example.ecorecicla.models;

public class Material {

    public String name;
    public double price;
    public double weight;//peso
    public double gain; //ganancia de ese material


    public Material() {
        this.name = "";
        this.price = 0;
        this.weight = 0;
        this.gain = 0;

    }

    public Material(String name, double price){
        this.name = name;
        this.price = price;

    }

    public Material(String name, double price, double weight, double gain) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.gain = gain;
    }

    //metodo para calcular la ganancia de cada material
    public void calculateGain(double price){
        this.price=price;
        this.gain=this.price*this.weight;
    }
    public void calculateGain(){
        this.gain=this.price*this.weight;
    }
}
