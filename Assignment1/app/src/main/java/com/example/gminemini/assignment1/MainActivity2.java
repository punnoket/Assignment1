package com.example.gminemini.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imageView;
    private TextView nameEditText ;
    private TextView lastnameEditText;
    private TextView ageEditText;
    private TextView emailEditText ;
    private TextView phoneEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String name = getIntent().getStringExtra("name");
        String lastname = getIntent().getStringExtra("lastname");
        String age = getIntent().getStringExtra("age");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");

        imageView = (ImageView) findViewById(R.id.img);
        nameEditText = (TextView) findViewById(R.id.edit_name);
        lastnameEditText = (TextView) findViewById(R.id.edit_lastname);
        ageEditText = (TextView) findViewById(R.id.edit_age);
        emailEditText = (TextView) findViewById(R.id.edit_email);
        phoneEditText = (TextView) findViewById(R.id.edit_Phno);


        setImg(age);
        nameEditText.setText(name);
        lastnameEditText.setText(lastname);
        ageEditText.setText(age + getResources().getString(R.string.years));
        emailEditText.setText(email);
        phoneEditText.setText(PhoneNumberUtils.formatNumber(phone));
    }

    public void setImg(String age) {
        int ageInt = Integer.parseInt(age);
        if (ageInt >= 0 && ageInt <= 15) {
            imageView.setImageResource(R.drawable.baby);
        } else if (ageInt >= 16 && ageInt <= 25) {
            imageView.setImageResource(R.drawable.pun);
        } else if (ageInt >= 26 && ageInt <= 60) {
            imageView.setImageResource(R.drawable.work);
        } else if (ageInt >= 61 && ageInt <= 150) {
            imageView.setImageResource(R.drawable.old);
        }
    }

}
