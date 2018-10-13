package com.example.greendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.greendemo.litepal.LitePalPerson;

import org.litepal.crud.callback.SaveCallback;

public class LitePalActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mInsertButton;
    private Button mDeleteButton;
    private Button mInsertSyncButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);

        mDeleteButton = findViewById(R.id.delete_button);
        mInsertButton = findViewById(R.id.insert_button);
        mInsertSyncButton = findViewById(R.id.insert_sync_button);

        mDeleteButton.setOnClickListener(this);
        mInsertButton.setOnClickListener(this);
        mInsertSyncButton.setOnClickListener(this);
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
            case R.id.insert_sync_button:
                insertSync();
                break;
            default:
                break;
        }
    }


    private void insertSync() {

        LitePalPerson palPerson = new LitePalPerson();
        palPerson.setAge(20);
        palPerson.setName("insertSync");
        //异步执行，并返回结果
        palPerson.saveAsync().listen(new SaveCallback() {
            @Override
            public void onFinish(boolean success) {
                Log.d("success", String.valueOf(success));
            }
        });
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
