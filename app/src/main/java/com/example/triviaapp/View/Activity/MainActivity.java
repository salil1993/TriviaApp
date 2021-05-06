package com.example.triviaapp.View.Activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.triviaapp.R;
import com.example.triviaapp.View.Fragments.Fragment3;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    FrameLayout contentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentContainer = findViewById(R.id.contentContainer);
        Fragment3 newFragment = new Fragment3();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentContainer, newFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
