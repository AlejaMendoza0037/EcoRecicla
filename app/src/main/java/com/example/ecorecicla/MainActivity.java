package com.example.ecorecicla;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecorecicla.models.Material;
import com.example.ecorecicla.models.Recycling;
import com.example.ecorecicla.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView                lista;
    TextView                    totalGains;
    Button                      buttonRegister;
    MaterialRecyclingAdapter    adapter;
    ArrayList<Material>         baseMaterials;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//estoy creando en esta sepcion los materiales que se van a mostrar
        //tengo que enviar una lista de materiales
        baseMaterials=new ArrayList<Material>();
        baseMaterials.add(new Material("papel",1000));
        baseMaterials.add(new Material("vidrio",2000));
        baseMaterials.add(new Material("metal",3000));
        baseMaterials.add(new Material("plastico",4000));
        baseMaterials.add(new Material("carton",5000));


        //crear un nuevo reciclaje
        Recycling newRecycling= new Recycling();
        newRecycling.materials=baseMaterials;


        lista               =findViewById(R.id.Lista);
        buttonRegister      =findViewById(R.id.buttonRegister);
        totalGains          =findViewById(R.id.granTotal);
        totalGains          .setText("$ 0.00 ");


        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);
        lista.setHasFixedSize(true);
        adapter=new MaterialRecyclingAdapter(this, newRecycling );
        lista.setAdapter(adapter);

        buttonRegister.setOnClickListener(view -> {

            newRecycling.calculateTotalGains();
            Toast.makeText(this, "Tu Ganancia Total es: $"+newRecycling.gains, Toast.LENGTH_SHORT).show();

        });

















































        /*
        //creamos los materiales

        Material papel= new Material("papel", 1000);
        Material vidrio= new Material("vidrio", 2000);
        Material metal= new Material("metal", 3000);
        Material plastico= new Material("plastico", 4000);

        //creamos usuario
        User newUser= new User();
        newUser.name="Diego";

        //creamos el reciclaje de hoy
        Recycling newRecyclingJuly= new Recycling();


        //registrar la cantidad de materiales reciclados

        papel.weight=1.5;
        papel.calculateGain(2000);
        plastico.weight=1;
        vidrio.calculateGain(1000);
        vidrio.weight=2;
        vidrio.calculateGain(2000);
        metal.weight=1;
        metal.calculateGain(3000);


        newRecyclingJuly.addMaterial(papel);
        newRecyclingJuly.addMaterial(vidrio);
        newRecyclingJuly.addMaterial(metal);
        newRecyclingJuly.addMaterial(plastico);


        //creamos el nuevo usuario
        newUser.addRecycling(newRecyclingJuly);


        //mostramos datos por pantalla
        newUser.showRecyclings();





        //mostramos por pantalla las estadisticas*/





    }
}