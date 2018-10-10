package com.example.greendemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.greendemo.database.DataBaseManager;
import com.example.greendemo.database.Person;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mInsertButton;
    private Button mQueryButton;
    private Button mDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDeleteButton = findViewById(R.id.delete_button);
        mInsertButton = findViewById(R.id.insert_button);
        mQueryButton = findViewById(R.id.query_button);

        mDeleteButton.setOnClickListener(this);
        mInsertButton.setOnClickListener(this);
        mQueryButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.query_button:
                query();
                break;
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

    private void insert() {
        Person person = new Person();
        person.setAge(18);
        person.setName("b");
      //  Log.d("person", person.toString());
        DataBaseManager.getInstance().getDao().insert(person);
    }

    private void delete() {
        DataBaseManager.getInstance().getDao().detachAll();
    }

    private void query() {
        //方法一       
        List<Person> personList = DataBaseManager.getInstance().getDao().loadAll();
        //方法二       
        // List<Person> personList =  DataBaseManager.getInstance().getDao().queryBuilder().list();
        // 方法三 惰性加载       
       //  List<Person> personList =  DataBaseManager.getInstance().getDao().queryBuilder().listLazy();
         for (int i = 0; i < personList.size(); i++) {
             Long id = personList.get(i).getId();
             Log.d("id",id + "");
         }
    }
}