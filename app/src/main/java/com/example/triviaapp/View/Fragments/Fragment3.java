package com.example.triviaapp.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.triviaapp.R;
import com.example.triviaapp.View.Activity.ResultActivity;

import java.util.Calendar;

public class Fragment3 extends Fragment {
    private EditText et_name;
    private String name;
    private TextView text_time;
    private Button button_start_quiz, button_history;
    private String currentTime;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment3, container, false);
        currentTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        /*ID's*/
        et_name = view.findViewById(R.id.et_name);
        text_time = view.findViewById(R.id.text_time);
        text_time.setText(String.valueOf(currentTime));
        button_start_quiz = view.findViewById(R.id.button_start_quiz);
        button_history = view.findViewById(R.id.button_history);

        /*ClickListener Event Call*/
        button_start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = et_name.getText().toString();
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(getActivity(), "Please fill your name", Toast.LENGTH_SHORT).show();
                }else{
                   Fragment1 fragment = new Fragment1();
                    Bundle args = new Bundle();
                    args.putString("name", name);
                    args.putString("date", String.valueOf(currentTime));
                    fragment.setArguments(args);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.contentContainer, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ResultActivity.class);
                startActivity(i);
                getActivity().finishAffinity();
            }
        });

        return view;
    }
}
