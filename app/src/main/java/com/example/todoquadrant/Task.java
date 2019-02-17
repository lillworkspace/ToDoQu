package com.example.todoquadrant;

public class Task {

    String myDescription;
    int myPriority;
    private static int counter;
    int IDnumber;

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
    public int getIDnumber() { return IDnumber; }


}
