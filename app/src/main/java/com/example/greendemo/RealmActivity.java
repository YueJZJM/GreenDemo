package com.example.greendemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.greendemo.litepal.LitePalPerson;
import com.example.greendemo.realm.RealmPerson;

import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mInsertButton;
    private Button mDeleteButton;
    private Button mQueryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        mDeleteButton = findViewById(R.id.reamle_delete_button);
        mInsertButton = findViewById(R.id.realm_insert_button);
        mQueryButton =findViewById(R.id.reamle_query_button);

        mDeleteButton.setOnClickListener(this);
        mInsertButton.setOnClickListener(this);
        mQueryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reamle_delete_button:
                delete();
                break;
            case R.id.realm_insert_button:
                insert();
                Toast.makeText(this,"aaa",Toast.LENGTH_SHORT).show();
                break;
            case R.id.reamle_query_button:
                query();
               // Toast.makeText(this,"aaa",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void query() {
        Realm  mRealm=Realm.getDefaultInstance();

        RealmResults<RealmPerson> people = mRealm.where(RealmPerson.class).findAll();

        List<RealmPerson> personList = mRealm.copyFromRealm(people);
        for(RealmPerson person:personList){
            Log.d("personid", person.getId() + person.getName());
        }
    }

    private void delete() {
    }

    private void insert() {
     //   Realm mRealm=Realm.getDefaultInstance();

         RealmPerson person = new RealmPerson();
        person.setAge(22);
        person.setName("c");
        Random random = new Random();
        String id = random.nextInt() + "";
        person.setId(id);

        Realm realm=Realm.getDefaultInstance();



        // Copy the object to Realm. Any further changes must happen on realmUser
        realm.beginTransaction();
        realm.copyToRealm(person);
        realm.commitTransaction();

    }

}
