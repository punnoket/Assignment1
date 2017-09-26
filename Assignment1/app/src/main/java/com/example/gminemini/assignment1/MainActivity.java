package com.example.gminemini.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import static com.example.gminemini.assignment1.R.string.age;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText name;
    private EditText lastname;
    private EditText age;
    private EditText email;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.submitBtn);
        name = (EditText) findViewById(R.id.edit_name);
        lastname = (EditText) findViewById(R.id.edit_lastname);
        age = (EditText) findViewById(R.id.edit_age);
        email = (EditText) findViewById(R.id.edit_email);
        phone = (EditText) findViewById(R.id.edit_Phno);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("lastname", lastname.getText().toString());
                    intent.putExtra("age", age.getText().toString());
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("phone", phone.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validate() {

        if (name.length() == 0)
            name.setError("Please enter name");

        if (lastname.length() == 0)
            lastname.setError("Please enter lastname");

        if (age.length() == 0)
            age.setError("Please enter age");

        if (email.length() == 0)
            email.setError("Please enter email");
        else if (!isEmailValid(email.getText().toString()))
            email.setError("Email wrong format");

        if (phone.length() == 0)
            phone.setError("Please enter phone");
        else if (phone.length() != 10)
            phone.setError("Phone number wrong format");

        return name.length() != 0 &&
                lastname.length() != 0 &&
                age.length() != 0 &&
                email.length() != 0 &&
                (phone.length() != 0 && phone.length() == 10) &&
                isEmailValid(email.getText().toString());
    }

}
