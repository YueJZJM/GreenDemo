package com.example.greendemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendemo.database.DataBaseManager;
import com.facebook.stetho.Stetho;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
        initLitePalDao();
        initStetho();
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
