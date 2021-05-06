package com.example.triviaapp.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.triviaapp.Model.Question;
import com.example.triviaapp.R;
import com.example.triviaapp.View.Activity.MainActivity;
import com.example.triviaapp.ViewModel.Db.GameDbHelper;


public class Fragment2 extends Fragment implements View.OnClickListener {
    String question1, answer1,name,date;
    private static final String TAG = "Fragment2";
    private TextView textViewQuestion;
    private RadioGroup rbGroup;
    private boolean answered;
    private CheckBox ch1,ch2,ch3,ch4;
    private Button buttonConfirmNext;
    private StringBuilder msg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment2, container, false);
        msg= new StringBuilder();
        question1 = getArguments().getString("question1");
        answer1 = getArguments().getString("answer1");
        name = getArguments().getString("name");
        date = getArguments().getString("date");

        textViewQuestion =view.findViewById(R.id.text_view_question);
        ch1 = view.findViewById(R.id.checkbox1);
        ch2 = view.findViewById(R.id.checkbox2);
        ch3 = view.findViewById(R.id.checkbox3);
        ch4 = view.findViewById(R.id.checkbox4);
        ch1.setOnClickListener(this::onClick);
        ch2.setOnClickListener(this::onClick);
        ch3.setOnClickListener(this::onClick);
        ch4.setOnClickListener(this::onClick);
        buttonConfirmNext = view.findViewById(R.id.button_confirm_next);
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                        Log.e(TAG, "onClick:chch "+msg.toString());
                        GameDbHelper dbHelper = new GameDbHelper(getActivity());
                        Log.e(TAG, "onClick: "+question1+textViewQuestion.getText().toString()+answer1+msg.toString()+name+date );
                        Question q1 = new Question(question1,textViewQuestion.getText().toString(), answer1, msg.toString(), name,date);
                        dbHelper.addQuestion(q1);
                        Intent i = new Intent(getContext(), MainActivity.class);
                        startActivity(i);
                        getActivity().finishAffinity();
                    } else {
                        Toast.makeText(getActivity(), "Please select an answer", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkbox1:
                if (ch1.isChecked()){
                    msg.append("White");
                    Log.e(TAG, "onClick:ch1 "+msg.toString());
                }
                break;
            case R.id.checkbox2:
                if (ch2.isChecked()){
                    msg.append(", Yellow ");
                    Log.e(TAG, "onClick:ch2 "+msg.toString());
                }else{

                }
                break;
            case R.id.checkbox3:
                if (ch3.isChecked()){
                    msg.append(", Orange");
                    Log.e(TAG, "onClick:ch3 "+msg.toString());
                }
                break;
            case R.id.checkbox4:
                if (ch4.isChecked()){
                    msg.append(", Green");
                    Log.e(TAG, "onClick:ch4 "+msg.toString());
                }else{

                }
                break;
        }
    }
}
