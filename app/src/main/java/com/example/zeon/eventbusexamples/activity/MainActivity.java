package com.example.zeon.eventbusexamples.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zeon.eventbusexamples.utils.BusProvider;
import com.example.zeon.eventbusexamples.fragment.MainFragment;
import com.example.zeon.eventbusexamples.event.MessageEvent;
import com.example.zeon.eventbusexamples.R;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, MainFragment.newInstance(), "main_fragment")
                    .commit();
        }
    }

    @Subscribe
    public void onMessageRecieve(MessageEvent event){
        Toast.makeText(this, "Send from MainFragment with the message >> " + event.getMessage(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        BusProvider.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(this);
    }
}
