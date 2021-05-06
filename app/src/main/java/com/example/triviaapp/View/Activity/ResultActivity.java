package com.example.triviaapp.View.Activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaapp.Model.Question;
import com.example.triviaapp.R;
import com.example.triviaapp.View.util.SimpleDividerItemDecoration;
import com.example.triviaapp.ViewModel.Adapter.CustomAdapter;
import com.example.triviaapp.ViewModel.Db.GameDbHelper;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private RecyclerView list_view;
    private ArrayList<Question> resultArrayList = new ArrayList<>();
    private static CustomAdapter adapter;
    private Button button_start_quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        list_view = findViewById(R.id.list_view);
        button_start_quiz = findViewById(R.id.button_start_quiz);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        list_view.setLayoutManager(linearLayoutManager);
        GameDbHelper dbHelper = new GameDbHelper(this);
        resultArrayList = dbHelper.getAllQuestions();
        adapter = new CustomAdapter(this, resultArrayList);
        list_view.addItemDecoration(new SimpleDividerItemDecoration(this));
        list_view.setAdapter(adapter);

        button_start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
