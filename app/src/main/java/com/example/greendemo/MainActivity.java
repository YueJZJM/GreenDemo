package com.example.greendemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.greendemo.database.DataBaseManager;
import com.example.greendemo.database.Person;

import org.litepal.tablemanager.Connector;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mLitePalButton;
    private Button mRealmButton;
    private Button mGreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLitePalButton = findViewById(R.id.litepal_button);
        mRealmButton = findViewById(R.id.realm_button);
        mGreenButton = findViewById(R.id.greendao_button);

        mLitePalButton.setOnClickListener(this);
        mRealmButton.setOnClickListener(this);
        mGreenButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.litepal_button:
                Intent intent = new Intent(MainActivity.this, LitePalActivity.class);
                startActivity(intent);
                break;
            case R.id.realm_button:
                Intent intent1 = new Intent(MainActivity.this, RealmActivity.class);
                startActivity(intent1);
                break;
            case R.id.greendao_button:
                Intent intent2 = new Intent(MainActivity.this, GreenDaoActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

}
