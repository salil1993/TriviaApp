package com.example.triviaapp.Model;

import android.os.Parcel;

public class Question {
    private int game_id;
    private String question1;
    private String question2;
    private String answer1;
    private String answer2;
    private String name;
    private String date;
    public Question(Parcel in) {
    }



    public Question() {

    }


    public Question(String question1, String question2, String answer1, String answer2, String name, String date) {

        this.question1 = question1;
        this.question2 = question2;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.name = name;
        this.date = date;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




}
