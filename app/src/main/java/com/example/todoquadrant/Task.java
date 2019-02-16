package com.example.todoquadrant;

public class Task {

    String tDescription;
    int tPriority;

    public Task(String message, int priority){

        tDescription = message;
        tPriority = priority;

    }

    public String getDescription(){
        return tDescription;
    }
    public int getPriority() { return tPriority; }

}
