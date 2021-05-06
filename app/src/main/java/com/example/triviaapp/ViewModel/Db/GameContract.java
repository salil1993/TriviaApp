package com.example.triviaapp.ViewModel.Db;

import android.provider.BaseColumns;

public class GameContract {
    public GameContract() {
    }

    // Contains question in Database
    public static class QuestionsTable implements BaseColumns {

        // accessible, no instance, unchangeable
        public static final String TABLE_NAME = "questions";
        public static final String COLUMN_GAME_ID = "game_id";
        public static final String COLUMN_QUESTION_1 = "question_1";
        public static final String COLUMN_QUESTION_2 = "question_2";
        public static final String COLUMN_DATETIME = "date_time";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ANSWER_2 = "answer_2";
        public static final String COLUMN_ANSWER_1 = "answer_1";
    }
}
