package com.example.todoquadrant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    private ArrayAdapter<Task> tasksAdapter;
    private ListView lvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<Task>();
        lvTasks = findViewById(R.id.lvTasks);
        tasksAdapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, tasks);
        lvTasks.setAdapter(tasksAdapter);

        tasks.add(new Task("Sketch out GUI"));
        tasks.add(new Task("Write code"));
        tasks.add(new Task("Call Mom after dinner"));

    }
}
