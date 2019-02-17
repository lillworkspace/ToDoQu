package com.example.todoquadrant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "todo.txt";
    private ArrayList<Task> tasks;
    private ArrayAdapter<Task> tasksAdapter;
    private ListView lvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<Task>();
        lvTasks = findViewById(R.id.lvTasks);
        readTasks();

        tasksAdapter = new TaskAdapter(this, tasks);
        lvTasks.setAdapter(tasksAdapter);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String description = extras.getString("description");
            int priority = extras.getInt("priority");
            tasks.add(new Task(description, priority));
            writeTasks();
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
        writeTasks();
    }

    public Task searchTask(String string) {
        for (Task t : tasks){
            if (t.getDescription().equals(string)){
                return t;
            }
        }
        return null;
    }

    private void readTasks(){
        File dir = this.getFilesDir();
        File toDo = new File(dir, "todo.txt");
        try {
            FileInputStream fis = new FileInputStream(toDo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tasks = new ArrayList<Task>();
            try{
                while(true) {
                    Task t = (Task) ois.readObject();
                    tasks.add(t);
                }
            } catch (EOFException e) { }
        } catch (IOException e) {
            e.printStackTrace();
            tasks = new ArrayList<Task>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeTasks(){
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Task t: tasks){
                oos.writeObject(t);
            }
            oos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
