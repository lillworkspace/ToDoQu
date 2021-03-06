package com.example.todoquadrant;

import java.io.Serializable;

public class Task implements Serializable, Comparable<Task>{

    String myDescription;
    int myPriority;
    private static int counter;
    int IDnumber; //for better search function in future

    public Task(String description, int priority){

        myDescription = description;
        myPriority = priority;
        counter++;
        IDnumber = counter;

    }

    public String getDescription(){
        return myDescription;
    }
    public int getPriority() { return myPriority; }

    @Override
    public int compareTo(Task t) {
        return this.myPriority - t.getPriority();
    }
}
