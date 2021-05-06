package com.example.triviaapp.ViewModel.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.triviaapp.Model.Question;
import com.example.triviaapp.ViewModel.Db.GameContract.QuestionsTable;


import java.util.ArrayList;

public class GameDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GameDbHelper.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    private static final String TAG = "GameDbHelper";

    public GameDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION_1 + " TEXT, " +
                QuestionsTable.COLUMN_QUESTION_2 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_1 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_2+ " TEXT, " +
                QuestionsTable.COLUMN_DATETIME+ " TEXT, " +
                QuestionsTable.COLUMN_NAME + " TEXT " +
              ")";

         db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
      //  fillQuestionsTable();
    }


  

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    public void addQuestion(Question question) {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION_1, question.getQuestion1());
        cv.put(QuestionsTable.COLUMN_QUESTION_2, question.getQuestion2());
        cv.put(QuestionsTable.COLUMN_ANSWER_1, question.getAnswer1());
        cv.put(QuestionsTable.COLUMN_ANSWER_2, question.getAnswer2());
        cv.put(QuestionsTable.COLUMN_DATETIME, question.getDate());
        cv.put(QuestionsTable.COLUMN_NAME, question.getName());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setGame_id(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION_1)));
                question.setQuestion2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION_2)));
                question.setAnswer1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_1)));
                question.setAnswer2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_2)));
                question.setDate(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DATETIME)));
                question.setName(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_NAME)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }





}
