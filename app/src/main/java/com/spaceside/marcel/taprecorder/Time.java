package com.spaceside.marcel.taprecorder;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "time_table")
public class Time {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "time")
    private String mTime;

    public Time(@NonNull String time){
        this.mTime = time;
    }

    public String getTime(){
        return this.mTime;
    }

}
