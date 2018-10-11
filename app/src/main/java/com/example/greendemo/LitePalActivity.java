package com.example.greendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.greendemo.litepal.LitePalPerson;

public class LitePalActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mInsertButton;
    private Button mDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);

        mDeleteButton = findViewById(R.id.delete_button);
        mInsertButton = findViewById(R.id.insert_button);

        mDeleteButton.setOnClickListener(this);
        mInsertButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.delete_button:
                delete();
                break;
            case R.id.insert_button:
                insert();
                break;
            default:
                break;
        }
    }

    private void delete() {
    }

    private void insert() {

        LitePalPerson palPerson = new LitePalPerson();
        palPerson.setAge(20);
        palPerson.setName("b");
        palPerson.save();

    }
}
