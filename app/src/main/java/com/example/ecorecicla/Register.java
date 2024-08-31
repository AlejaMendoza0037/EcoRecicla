package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.Security.Validation;

public class Register extends AppCompatActivity {

    TextView        textNombre;
    TextView        textLastName;
    TextView        textEmail;
    TextView        textPassword;
    TextView        textConfirmPassword;

    EditText        editName;
    EditText        editSurname;
    EditText        editEmail;
    EditText        editPassword;
    EditText        editPasswordConfirmation;

    Button          buttonRegister;
    TextView        TextLogin;

   public enum TipoCampo {REQUERIDO, NO_REQUERIDO};// si el dato es requerido o no








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textNombre              =findViewById(R.id.textNombre);
        textLastName            = findViewById(R.id.textLastName);
        textEmail               = findViewById(R.id.textEmail);
        textPassword            = findViewById(R.id.textPassword);
        textConfirmPassword     = findViewById(R.id.textConfirmPassword);

        editName                        =findViewById(R.id.editName);
        editSurname                     =findViewById(R.id.editSurname);
        editEmail                       =findViewById(R.id.editEmail);
        editPassword                    =findViewById(R.id.editPassword);
        editPasswordConfirmation        =findViewById(R.id.editPasswordConfirmation);

        buttonRegister                  =findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(v -> {
            Validation.validateName(editName, "nombre", 3, 50, TipoCampo.REQUERIDO, this);
            Validation.validateName(editSurname, "apellido", 3, 50, TipoCampo.REQUERIDO, this);
            Validation.validateEmail(editEmail, TipoCampo.REQUERIDO, this);
            Validation.validatePassword(editPassword, editPasswordConfirmation, 6, 20,  this);

        });



        TextLogin                       = findViewById(R.id.TextLogin);
        TextLogin                       .setOnClickListener(v -> goToLogin());

    }


    public void goToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);


    }
}
