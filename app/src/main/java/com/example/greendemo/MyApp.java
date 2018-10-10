package com.example.greendemo;

import android.app.Application;

import com.example.greendemo.database.DataBaseManager;
import com.facebook.stetho.Stetho;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initDao();
        initStetho();
    }

    private void initDao() {
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
