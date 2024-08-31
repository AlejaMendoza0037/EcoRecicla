package com.example.ecorecicla;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecorecicla.models.Material;
import com.example.ecorecicla.models.Recycling;

import java.util.ArrayList;

public class MaterialRecyclingAdapter  extends RecyclerView.Adapter<MaterialRecyclingAdapter.MyViewHolder>{//el viewholder es la vista que vamos a utilizar

    MainActivity mainActivity;
    Recycling reciclaje;



   public MaterialRecyclingAdapter(MainActivity mainActivity, Recycling reciclaje){
       //inicializamos el adaptador
       this.mainActivity=mainActivity;
       this.reciclaje=reciclaje;




   }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//este metodo es el que hace todo para que se vea en// el lyout
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.registar_material_reciclaje,parent,false);

        return new MyViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {//aca se muestra todo lo que vamos hacer, el holder es nuestra vista
        holder.nombreMaterial.setText(reciclaje.materials.get(position).name);
        holder.price.setText(reciclaje.materials.get(position).price+"");
        holder.weight.setText(reciclaje.materials.get(position).weight+"");
        holder.gain.setText(reciclaje.materials.get(position).gain+"");

        holder.price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {//antes de que el texto sea modificado


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {//cuando durante
                String value=holder.price.getText().toString();
                if(value.length()>0){
                    double newPrice=Double.parseDouble(value);
                    reciclaje.materials.get(position).calculateGain(newPrice);
                    holder.gain.setText(reciclaje.materials.get(position).gain+"");
                    reciclaje.calculateTotalGains();
                    mainActivity.totalGains.setText(reciclaje.gains+"");
                }



            }

            @Override
            public void afterTextChanged(Editable s) {//despues de que el texto sea modificado

            }
        });

        holder.weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {//antes de que el texto sea modificado


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {//cuando durante
                String value=holder.weight.getText().toString();

                if(value.length()>0){
                    double newWeight=Double.parseDouble(value);
                    reciclaje.materials.get(position).weight=newWeight;
                    reciclaje.materials.get(position).calculateGain(newWeight);
                    holder.gain.setText(reciclaje.materials.get(position).gain+"");

                    reciclaje.calculateTotalGains();
                    mainActivity.totalGains.setText(reciclaje.gains+"");

                }




            }

            @Override
            public void afterTextChanged(Editable s) {//despues de que el texto sea modificado

            }
        });


        //cuando editemos el texto




    }

    @Override
    public int getItemCount() {
       //no olvidar
        if(reciclaje.materials!=null){
            return reciclaje.materials.size();
        }
    return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
       TextView     nombreMaterial;
       EditText     price;
       EditText     weight;
       EditText     gain;


        public MyViewHolder(@NonNull View item) {//item representa nuestra vista nuestro lyout

            super(item);
            nombreMaterial      =item.findViewById(R.id.nombreMaterial);
            price               =item.findViewById(R.id.price);
            weight              =item.findViewById(R.id.weight);
            gain                =item.findViewById(R.id.gain);

        }


    }


}
