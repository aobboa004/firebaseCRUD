package com.learning.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button createEvent;
    Button viewEvents;
    EditText eventStartingDate;
    EditText eventEndingDate;
    EditText eventName;
    EditText eventVenue;
    EditText eventOrganisedBy;
    EditText eventTime;
    EditText contactInfo;
    FirebaseDatabase database;
    DatabaseReference ref;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createEvent=findViewById(R.id.createEvent);
        viewEvents=findViewById(R.id.viewEvents);
        eventStartingDate=findViewById((R.id.eventDateFrom));
        eventEndingDate=findViewById(R.id.eventDateTo);
        eventName=findViewById(R.id.eventName);
        eventVenue=findViewById(R.id.eventVenue);
        eventOrganisedBy=findViewById(R.id.eventOrganisedBy);
        eventTime=findViewById(R.id.eventStartingTime);
        contactInfo=findViewById(R.id.eventContactInfo);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Events");

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });


    }

    private void addEvent() {
        String name=eventName.getText().toString();
        String venue=eventVenue.getText().toString();
        String organisedby=eventOrganisedBy.getText().toString();
        String startdate=eventStartingDate.getText().toString();
        String enddate=eventEndingDate.getText().toString();
        String starttime=eventTime.getText().toString();
        String contactinfo=contactInfo.getText().toString();

        String id=ref.push().getKey();

        Events event=new Events(name,id,organisedby,startdate,enddate,starttime,contactinfo,venue);
        ref.child(id).setValue(event);
    }





    public void btnDisplay(View view) {
        Intent intent=new Intent(MainActivity.this,Display.class);
        startActivity(intent);
    }
}
