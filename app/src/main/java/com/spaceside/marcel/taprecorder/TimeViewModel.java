package com.spaceside.marcel.taprecorder;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class TimeViewModel extends AndroidViewModel {

    private TimeRepository mRepository;

    private LiveData<List<Time>> mAllTimes;

    public TimeViewModel (Application application){
        super(application);
        mRepository = new TimeRepository(application);
        mAllTimes = mRepository.getAllTimes();
    }

    LiveData<List<Time>> getAllTimes(){
        return mAllTimes;
    }

    public void insert(Time time){
        mRepository.insert(time);
    }

}
