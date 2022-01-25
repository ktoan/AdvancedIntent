package com.example.loginregister;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    TextView hyperText, lblDob;
    EditText txtFullname, txtEmail, txtPassword, txtDob;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Check message Intent
        Intent get = getIntent();
        String email = get.getStringExtra("email");
        String password = get.getStringExtra("password");

        if (email!=null && password!=null) {
            Toast.makeText(getApplication().getBaseContext(), "Email: " + email + ", Password: " + password, Toast.LENGTH_LONG).show();
        }

        // Date dialog
        txtDob = findViewById(R.id.txtDob);

        txtDob.setShowSoftInputOnFocus(false);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dom) {
                month+=1;
                String date = day+"/"+month+"/"+year;
                txtDob.setText(date);
            }
        };

        txtDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month+=1;
                        String date = day+"/"+month+"/"+year;
                        txtDob.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        // Main
        txtFullname = findViewById(R.id.txtFullnameRegister);
        txtEmail = findViewById(R.id.txtEmailRegister);
        txtPassword = findViewById(R.id.txtPasswordRegister);
        radioGroup = (RadioGroup) findViewById(R.id.radioSex);

        hyperText = findViewById(R.id.hyperLinkRegister);
        hyperText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("fullname", txtFullname.getText().toString());
                intent.putExtra("emailRegister", txtEmail.getText().toString());
                intent.putExtra("passwordRegister", txtPassword.getText().toString());
                intent.putExtra("dob", txtDob.getText().toString());

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                intent.putExtra("sex", radioButton.getText().toString());
                startActivity(intent);
            }
        });
    }
}