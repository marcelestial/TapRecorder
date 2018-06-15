package com.spaceside.marcel.taprecorder;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Time.class}, version = 1)
public abstract class TimeRoomDatabase extends RoomDatabase {

    public abstract TimeDao timeDao();

    private static TimeRoomDatabase INSTANCE;

    public static TimeRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (TimeRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TimeRoomDatabase.class, "time_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{

        private final TimeDao mDao;

        PopulateDbAsync(TimeRoomDatabase db){
            mDao = db.timeDao();
        }

        @Override
        protected Void doInBackground(final Void... params){
            return null;
        }
    }

}
