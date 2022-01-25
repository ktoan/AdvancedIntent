package com.example.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hyperLink;
    EditText txtEmail, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check message Intent
        Intent get = getIntent();
        String fullname = get.getStringExtra("fullname");
        String emailRegister = get.getStringExtra("emailRegister");
        String passwordRegister = get.getStringExtra("passwordRegister");
        String dob = get.getStringExtra("dob");
        String sex = get.getStringExtra("sex");

        if (emailRegister!=null && passwordRegister!=null && fullname!=null && dob!=null && sex!=null) {
            Toast.makeText(getApplicationContext(), "Email: " + emailRegister + ", Password: " + passwordRegister +
                    ", Full name: " + fullname + ", DOB: " + dob + ", Sex: " + sex, Toast.LENGTH_LONG).show();
        }

        hyperLink = findViewById(R.id.hyperLinkRegister);
        hyperLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RegisterActivity.class);
                txtEmail = findViewById(R.id.txtEmail);
                txtPassword = findViewById(R.id.txtPasswordRegister);
                intent.putExtra("email", txtEmail.getText().toString());
                intent.putExtra("password", txtPassword.getText().toString());
                startActivity(intent);
            }
        });
    }
}