package com.example.triviaapp.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.triviaapp.R;


public class Fragment1 extends Fragment {

    private TextView textViewQuestion;
    private  RadioButton Selectedquestion_answer;
    private RadioGroup rbGroup;
    private  RadioButton rb1,rb2,rb3,rb4;
    private Button buttonConfirmNext;
    private boolean answered;
    private View view;
    private String name,date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment1, container, false);
        name = getArguments().getString("name");
        date = getArguments().getString("date");
        textViewQuestion =view.findViewById(R.id.text_view_question);
        rbGroup = view.findViewById(R.id.radio_group);
        rb1 = view.findViewById(R.id.radio_button1);
        rb2 = view.findViewById(R.id.radio_button2);
        rb3 = view.findViewById(R.id.radio_button3);
        rb4 = view.findViewById(R.id.radio_button4);
        buttonConfirmNext = view.findViewById(R.id.button_confirm_next);

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()|| rb4.isChecked()) {
                        int selectedid  = rbGroup.getCheckedRadioButtonId();
                        Selectedquestion_answer = view.findViewById(selectedid);
                        Fragment fragment = new Fragment2();
                        Bundle args = new Bundle();
                        args.putString("question1", textViewQuestion.getText().toString());
                        args.putString("answer1", Selectedquestion_answer.getText().toString());
                        args.putString("name", name);
                        args.putString("date", date);
                        fragment.setArguments(args);
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.contentContainer, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                     //   checkAnswer();
                       // showNextQuestion();
                    } else {
                        Toast.makeText(getActivity(), "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {

                }
            }
        });
        return view;
    }
}
