package com.example.ecorecicla.Security;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecorecicla.Register;
import com.example.ecorecicla.Register.TipoCampo;

public class Validation {


    public static void validateName(EditText editText, String nombreCampo, int minCaracter, int maxCaracter,
                                    Register.TipoCampo tipoCampo, Context context){

        String text = editText.getText().toString();

        if (tipoCampo ==TipoCampo.REQUERIDO && text.isEmpty()){

            Toast.makeText(context, "El campo " + nombreCampo + " es requerido.", Toast.LENGTH_LONG).show();
            return;


        }
        if (text.length() < minCaracter || text.length() > maxCaracter){
            Toast.makeText(context, "El campo " + nombreCampo + " debe tener entre " +
                            minCaracter + " y " + maxCaracter + " caracteres.", Toast.LENGTH_LONG).show();
            return;

        }

        //expresiones regulares              permite entre 3 y 50 caracteres
        if(tipoCampo==TipoCampo.REQUERIDO && !text.matches("[a-zA-Z0-9.-]{"+ minCaracter+","+maxCaracter+"}$")){//si no contiene esto

            Toast.makeText(context, "El campo  "+nombreCampo+"  debe contener solo letras", Toast.LENGTH_LONG).show();
            return;
        }



    }
    public static void validateEmail(EditText editText, TipoCampo tipoCampo, Context context){

        String text = editText.getText().toString();

        if (tipoCampo ==TipoCampo.REQUERIDO && text.isEmpty()){

            Toast.makeText(context, "El campo Email es requerido.", Toast.LENGTH_LONG).show();
            return;


        }


        //expresiones regulares              permite entre 3 y 50 caracteres
        if(tipoCampo==TipoCampo.REQUERIDO && !text.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")){//!-->si no contiene esto

            Toast.makeText(context, "El campo  Email debe ser valido", Toast.LENGTH_LONG).show();
            return;
        }



    }

    public static void validatePassword(EditText editPassword, EditText editPasswordConfirmation, int minCaracter, int maxCaracter,  Context context){
        String pass = editPassword.getText().toString();
        String passConfirm = editPasswordConfirmation.getText().toString();

        if ( pass.isEmpty()){

            Toast.makeText(context, "La contraseña no puede estar vacia", Toast.LENGTH_LONG).show();
            return;


        }

        if ( pass.length() < minCaracter || pass.length() > maxCaracter){
            Toast.makeText(context, "La contraseña debe tener entre " +
                            minCaracter + " y " + maxCaracter + " caracteres.", Toast.LENGTH_LONG).show();
            return;


        }


        if(!pass.equals(passConfirm)){

            Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
            return;
        }



    }
    }



