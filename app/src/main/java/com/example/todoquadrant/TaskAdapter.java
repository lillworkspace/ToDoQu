package com.example.todoquadrant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    private Context mycontext;
    private List<Task> mytaskList;

    public TaskAdapter(Context context, ArrayList<Task> taskList){

        super(context, 0, taskList);
        mycontext = context;
        mytaskList = taskList;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        View taskItem = convertView;
        if (taskItem == null){
            taskItem = LayoutInflater.from(mycontext).inflate(R.layout.task_item, parent, false);
        }

        Task currentTask = mytaskList.get(position);

        TextView description = taskItem.findViewById(R.id.textView_id);
        description.setText(currentTask.getDescription());

        return taskItem;
    }

}
