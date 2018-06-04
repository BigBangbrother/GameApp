package com.example.wzw.gameapp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.wzw.gameapp.R;

/**
 * Created by wzw on 2018/6/4.
 */

public class GameActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activty);
    }
}
