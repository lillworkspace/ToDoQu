package com.example.todoquadrant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AddActivity extends AppCompatActivity {

    private EditText text;
    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        text = findViewById(R.id.editText);

        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.importance, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.urgency, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
    }

    public void addTask(View view){
        Intent intent = new Intent(this, MainActivity.class);

        String description = text.getText().toString();
        intent.putExtra("description", description);

        String importance = spinner1.getSelectedItem().toString();
        String urgency = spinner2.getSelectedItem().toString();

        int priority;

        switch (importance + " " + urgency){
            case "Important Urgent": priority = 1;
                break;
            case "Important Not Urgent": priority = 2;
                break;
            case "Not Important Urgent": priority = 3;
                break;
            case "Not Important Not Urgent": priority = 4;
                break;
            default: priority = 5;
        }
        intent.putExtra("priority", priority);

        startActivity(intent);
    }

    public void returnMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
