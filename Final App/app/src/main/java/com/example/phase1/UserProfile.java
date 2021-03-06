

/*
This class is used to define the logic of the page that shows user's profile .
This sets the text of the TextView and EditView elements present in the related page whenever the page is opened.
It also implements onClickListener's for the buttons present in that page.
*/

package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserProfile extends AppCompatActivity {


    private TextView name;
    private TextView mail;
    private TextView text1 , text2 , text3 , text4 , text5;
    private Button editBtn;
    private Button logoutBtn;
    private Button withdrawdonate;
    private Button withdrawreceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        logoutBtn = findViewById(R.id.logout);
        withdrawdonate = findViewById(R.id.withdrawdonate);
        withdrawreceive = findViewById(R.id.withdrawreceive);

        String PREF_NAME = "PreName";
        int PRIVATE_MODE = 0;
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        User user = UserClass.getUser(pref.getString("username", null));

        text1.setText(user.getName());
        text2.setText(user.getPhno());
        text3.setText(user.getEmail());
        text4.setText(user.getDoorNO()+", "+user.getArea());
        text5.setText(user.getUserName());
        name.setText(user.getName());
        mail.setText(user.getEmail());

        editBtn = findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editable_page();
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username", null);
                editor.commit();
                Toast.makeText(UserProfile.this, "Successfully Loggedout", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        withdrawdonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentDonorsClass.deleteCurrentDonor(user.getName());
                Toast.makeText(UserProfile.this, "Donate Request Withdrawn", Toast.LENGTH_SHORT).show();
            }
        });

        withdrawreceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentReceiverClass.deleteCurrentReceiver(user.getName());
                Toast.makeText(UserProfile.this, "Receive Request Withdrawn", Toast.LENGTH_SHORT).show();
            }
        });


        ArrayList<FeedBack> array = FeedBackClass.getAllComments();
        System.out.println(array.size());

    }

    public void editable_page()
    {
        Intent intent = new Intent( this , Editablepage.class);
        startActivity(intent);
    }
}
