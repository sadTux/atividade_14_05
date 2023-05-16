package com.example.promofeed;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonRegister;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    public static final String myPREFERENCES = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("file", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonRegister = (Button) findViewById(R.id.button_Register);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    // NOTIFICAÇÃO NO APP
                    Toast.makeText(MainActivity.this, "Dados Cadastrados no arquivo .xml com sucesso!", Toast.LENGTH_LONG).show();

                    editor.putString("name", editTextName.getText().toString());
                    editor.putString("email", editTextEmail.getText().toString());
                    editor.putString("senha", editTextPassword.getText().toString());
                    editor.apply();
                    finish();
                } catch (Exception e) {
                    // Lidar com exceção, se ocorrer
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Ocorreu um erro ao cadastrar os dados", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}