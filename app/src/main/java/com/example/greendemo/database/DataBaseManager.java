package com.example.greendemo.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

public class DataBaseManager {
    private DaoSession mDaoSession = null;
    private PersonDao mPersonDao = null;

    private DataBaseManager(){

    }

    public DataBaseManager init(Context context){
        initDao(context);
        return this;
    }

    public static DataBaseManager getInstance(){
        return Holder.INSTRANCE;
    }

    private static final class Holder{
        private static final DataBaseManager INSTRANCE = new DataBaseManager();
    }

    private void initDao(Context context) {
        try {
            final ReleaseOpenHelper helper = new ReleaseOpenHelper(context,"fast_ec.ab");
            final Database db = helper.getWritableDb();
            mDaoSession = new DaoMaster(db).newSession();
            mPersonDao = mDaoSession.getPersonDao();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public final PersonDao getDao(){
        return mPersonDao;
    }
}
