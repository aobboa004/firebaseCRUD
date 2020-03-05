package com.learning.firebasecrud;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EventsAdapter extends ArrayAdapter<Events> {

    private Activity context;
    private List<Events> list;
    public EventsAdapter(Activity context,List<Events> list)
    {   super(context,R.layout.single_event_info_layout,list);
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View listviewitem=layoutInflater.inflate(R.layout.single_event_info_layout,null,true);
        TextView NameD=(TextView)listviewitem.findViewById(R.id.NameD);
        TextView OrganiserD=(TextView)listviewitem.findViewById(R.id.OrganiserD);
        TextView VenueD=(TextView)listviewitem.findViewById(R.id.VenueD);
        TextView StartdateD=(TextView)listviewitem.findViewById(R.id.StartdateD);
        TextView StarttimeD=(TextView)listviewitem.findViewById(R.id.StarttimeD);
        TextView EnddateD=(TextView)listviewitem.findViewById(R.id.EnddateD);
        TextView PhoneD=(TextView)listviewitem.findViewById(R.id.phoneD);

        Events event=list.get(position);

        NameD.setText(event.getName());
        OrganiserD.setText(event.getOrganiser());
        VenueD.setText(event.getVenue());
        StartdateD.setText(event.getStartdate());
        StarttimeD.setText(event.getStarttime());
        EnddateD.setText(event.getEnddate());
        PhoneD.setText(event.getContactinfo());

        return listviewitem;
    }
}
