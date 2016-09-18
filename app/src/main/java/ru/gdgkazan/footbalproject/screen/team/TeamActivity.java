package ru.gdgkazan.footbalproject.screen.team;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.gdgkazan.footbalproject.R;

/**
 * Created by Sergei Riabov
 */
public class TeamActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);


    }
}
