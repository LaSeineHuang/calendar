package com.example.calendar.activity.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.dao.DaoMaster;
import com.example.dao.DaoSession;

public class DbManager {
    //数据库名称
    private static final String DB_NAME = "test.db";
    private Context mContext;//上下文
    private static DbManager mDbManager;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    private DbManager(Context context){
        this.mContext = context;
        // 初始化数据库信息
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context,DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }

    public static DbManager getInstance(Context context){
        if (null == mDbManager){
            synchronized (DbManager.class){
                if (null == mDbManager){
                    mDbManager = new DbManager(context);
                }
            }
        }
        return mDbManager;
    }

    /**
     * 获取可读数据库
     * @param context
     * @return
     */
    public static SQLiteDatabase getReadableDatabase(Context context){
        if (null == mDevOpenHelper){
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }
    /**
     * 获取可写数据库
     * @param context
     * @return
     */
    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }

        return mDevOpenHelper.getWritableDatabase();
    }

    /**
     * 获取DaoMaster
     * @param context
     * @return
     */
    public static DaoMaster getDaoMaster(Context context){
        if (null == mDaoMaster){
            synchronized (DbManager.class){
                if (null == mDaoMaster){
                    mDaoMaster = new DaoMaster(getWritableDatabase(context));
                }
            }
        }
        return mDaoMaster;
    }

    /**
     * 获取DaoSession
     * @param context
     * @return
     */
    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DbManager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }

}