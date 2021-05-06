package com.example.triviaapp.ViewModel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.triviaapp.Model.Question;
import com.example.triviaapp.R;
import com.example.triviaapp.View.Activity.ResultActivity;

import java.util.List;

public class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Question> resultlist;
    private Context context;
    private ResultActivity activity;

    public CustomAdapter(Context context, List<Question> resultlist) {
        this.context = context;
        this.resultlist = resultlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_result, parent, false);
        activity = (ResultActivity) context;
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Question data = resultlist.get(position);
        if (data != null) {
            holder.text_view_question1.setText("Question 1:"+data.getQuestion1());
            holder.text_name.setText(data.getName());
            holder.text_game_no.setText(String.valueOf(data.getGame_id()));
            holder.tv_date.setText(data.getDate());
            holder.text_answer1.setText("Answers :"+data.getAnswer1());
            holder.text_answer2.setText("Answers :"+data.getAnswer2());
            holder.text_view_question2.setText("Question 2:"+data.getQuestion2());
        }
    }

    @Override
    public int getItemCount() {
        return resultlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_view_question1,text_answer1,text_name,tv_date,text_game_no,text_answer2,text_view_question2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_game_no = itemView.findViewById(R.id.text_game_no);
            tv_date = itemView.findViewById(R.id.tv_date);
            text_answer1 = itemView.findViewById(R.id.text_answer1);
            text_name = itemView.findViewById(R.id.text_name);
            text_view_question1 = itemView.findViewById(R.id.text_view_question1);
            text_view_question2 = itemView.findViewById(R.id.text_view_question2);
            text_answer2 = itemView.findViewById(R.id.text_answer2);
        }
    }
}

