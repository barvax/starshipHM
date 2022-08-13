package com.example.lec11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lec11.ui.main.AboutFragment;
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



    SharedPreferences sharedPreferences =  getSharedPreferences("test" , Context.MODE_PRIVATE);
//    sharedPreferences.edit().putString("authToken" , "my Token").apply();

       String token = sharedPreferences.getString("authToken","default");
//        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
    }

    public  void goToNextFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, AboutFragment.newInstance())
                .commitNow();
    }

}