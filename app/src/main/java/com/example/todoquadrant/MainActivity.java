package com.example.todoquadrant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
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

        tasksAdapter = new TaskAdapter(this, tasks);
        lvTasks.setAdapter(tasksAdapter);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String description = extras.getString("description");
            int priority = extras.getInt("priority");
            tasks.add(new Task(description, priority));
        }
    }

    public void addActivity(View view){
        Intent intent = new Intent(this, com.example.todoquadrant.AddActivity.class);
        startActivity(intent);
    }


    public void deleteTask(View view){
        View parent = (View)view.getParent();
        TextView taskView = parent.findViewById(R.id.textView_id);
        String description = String.valueOf(taskView.getText());
        tasks.remove(searchTask(description));
        tasksAdapter.notifyDataSetChanged();
    }

    public Task searchTask(String string) {
        for (Task t : tasks){
            if (t.getDescription().equals(string)){
                return t;
            }
        }
        return null;
    }

    //private void readItems(){
        //File dir = getFilesDir();
        //File toDo = new File(dir, "toDo.txt");
        //try{

        //}
    //}
}
