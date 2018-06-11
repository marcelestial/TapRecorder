package com.spaceside.marcel.taprecorder;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class TimeRepository {

    private TimeDao mTimeDao;
    private LiveData<List<Time>> mAllTimes;

    TimeRepository(Application application){
        TimeRoomDatabase db = TimeRoomDatabase.getDatabase(application);
        mTimeDao = db.timeDao();
        mAllTimes = mTimeDao.getAllTimes();
    }

    LiveData<List<Time>> getAllTimes(){
        return mAllTimes;
    }

    public void insert (Time time){
        new insertAsyncTask(mTimeDao).execute(time);
    }

    private static class insertAsyncTask extends AsyncTask<Time, Void, Void>{

        private TimeDao mAsyncTaskDao;

        insertAsyncTask(TimeDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Time... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }

    }

}
