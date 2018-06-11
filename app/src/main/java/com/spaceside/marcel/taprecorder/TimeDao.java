package com.spaceside.marcel.taprecorder;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TimeDao {

    @Insert
    void insert(Time time);

    @Query("DELETE FROM time_table")
    void deleteAll();

    @Query("SELECT * from time_table ORDER BY time ASC")
    LiveData<List<Time>> getAllTimes();

}
