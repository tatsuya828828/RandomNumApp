package com.kuma.randomnumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // 最大値
    private int maxNumber = 75;
    // 最大値の入力欄
    private EditText maxNumberText;
    // 最大値の設定ボタン
    private Button MaxNumberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ビューの変数を初期化
        maxNumberText = findViewById(R.id.max_number);
        MaxNumberButton = findViewById(R.id.register_max_number);

        // 最大値の初期値をEditTextにセットする
        maxNumberText.setText(""+maxNumber);

        // 最大値の更新
        MaxNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 入力値を文字列で取り出す
                String maxNumberString = maxNumberText.getText().toString();
                // int型に変換してから代入
                maxNumber = Integer.valueOf(maxNumberString);

                Log.d("MainActivity", "maxNumber:"+ maxNumber);
            }
        });
    }
}