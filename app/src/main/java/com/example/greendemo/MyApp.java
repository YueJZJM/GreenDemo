package com.example.greendemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendemo.database.DataBaseManager;
import com.facebook.stetho.Stetho;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
        initLitePalDao();
        initRealm();
        initStetho();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration config = new  RealmConfiguration.Builder()
                .name("myRealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private void initLitePalDao() {
        LitePal.initialize(this);
        SQLiteDatabase db = Connector.getDatabase();
    }

    private void initGreenDao() {
        DataBaseManager.getInstance().init(this);

    }

    private void initStetho(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        );
    }

}
