package com.spaceside.marcel.taprecorder;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private TimeViewModel mTimeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeString = Calendar.getInstance().getTime().toString();
                Time time = new Time(timeString);
                mTimeViewModel.insert(time);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final TimeListAdapter adapter = new TimeListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTimeViewModel = ViewModelProviders.of(this).get(TimeViewModel.class);

        mTimeViewModel.getAllTimes().observe(this, new Observer<List<Time>>() {
            @Override
            public void onChanged(@Nullable List<Time> times) {
                adapter.setTimes(times);
            }
        });
    }
}
