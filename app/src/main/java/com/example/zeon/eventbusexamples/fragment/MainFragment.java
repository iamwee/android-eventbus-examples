package com.example.zeon.eventbusexamples.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.zeon.eventbusexamples.utils.BusProvider;
import com.example.zeon.eventbusexamples.event.MessageEvent;
import com.example.zeon.eventbusexamples.R;
import com.squareup.otto.Bus;

/**
 * Created by Zeon on 8/8/2559.
 */

public class MainFragment extends Fragment {


    EditText edtMsg;
    Button btnSend;
    Bus bus;

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onRestoreInstanceState(Bundle bundle){

    }

    private void initInstances(View rootView){
        edtMsg = (EditText) rootView.findViewById(R.id.edtMsg);
        btnSend = (Button) rootView.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btnSend){
                sendMessage(edtMsg.getText().toString());
            }
        }
    };

    private void sendMessage(String s) {
        BusProvider.getInstance().post(new MessageEvent(s));
    }
}
