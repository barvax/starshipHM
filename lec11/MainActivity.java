package com.example.lec11;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.lec11.ui.main.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FirstFragment.newInstance())
                    .commitNow();
        }

    }





}