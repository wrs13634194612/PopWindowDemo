package com.example.poptwodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private View contentView;
    private CustomPopWindow.PopupWindowBuilder mPopupWindowBuilder;
    private Button btn_main;
    private CustomPopWindow mCustomPopWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main = findViewById(R.id.btn_main);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_menu, null);
                handleLogic(contentView);
                mPopupWindowBuilder = new CustomPopWindow.PopupWindowBuilder(MainActivity.this);
                mPopupWindowBuilder.setView(contentView);
                mPopupWindowBuilder.create();
                mCustomPopWindow = mPopupWindowBuilder.getmCustomPopWindow();
                mCustomPopWindow.showAsDropDown(btn_main, 0, 20);
            }
        };
        handler.postDelayed(runnable, 500);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_menu, null);
                handleLogic(contentView);
                mPopupWindowBuilder = new CustomPopWindow.PopupWindowBuilder(MainActivity.this);
                mPopupWindowBuilder.setView(contentView);
                mPopupWindowBuilder.create();
                mCustomPopWindow = mPopupWindowBuilder.getmCustomPopWindow();
                mCustomPopWindow.showAsDropDown(btn_main, 0, 20);
            }
        });
    }

    private void handleLogic(View contentView) {
        contentView.findViewById(R.id.menu1).setOnClickListener(listener);
        contentView.findViewById(R.id.menu2).setOnClickListener(listener);
        contentView.findViewById(R.id.menu3).setOnClickListener(listener);
        contentView.findViewById(R.id.menu4).setOnClickListener(listener);
        contentView.findViewById(R.id.menu5).setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("TAG","wrs:"+v.getId());
            if (mCustomPopWindow != null) {
                mCustomPopWindow.dissmiss();
            }
        }
    };
}