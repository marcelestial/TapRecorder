package com.spaceside.marcel.taprecorder;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
