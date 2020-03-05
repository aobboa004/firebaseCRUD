package com.learning.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    Events event;



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
        event = new Events();


    }

    private void getValues( String idn)
    {

        event.setName(eventName.getText().toString());
        event.setOrganiser(eventOrganisedBy.getText().toString());
        event.setStartdate(eventStartingDate.getText().toString());
        event.setEnddate(eventEndingDate.getText().toString());
        event.setStarttime(eventTime.getText().toString());
        event.setContactinfo(contactInfo.getText().toString());
        event.setVenue(eventVenue.getText().toString());
        event.setId(idn);
    }

    public void btninsert(View view) {
        ref.addValueEventListener(new ValueEventListener() {

             String id=ref.push().getKey();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues(id);
                ref.child(id).setValue(event);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
