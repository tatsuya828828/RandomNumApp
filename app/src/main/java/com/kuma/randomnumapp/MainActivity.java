package com.kuma.randomnumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 最大値
    private int maxNumber = 75;
    // 数字の履歴
    private ArrayList<String> history = new ArrayList<>();
    // 最大値の入力欄
    private EditText maxNumberText;
    // 最大値の設定ボタン
    private Button MaxNumberButton;
    // 数字を新しく呼び出すボタン
    private Button callNumberButton;
    // 現在の数字を表示するTextView
    private TextView currentNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ビューの変数を初期化
        maxNumberText = findViewById(R.id.max_number);
        MaxNumberButton = findViewById(R.id.register_max_number);
        callNumberButton = findViewById(R.id.call_number);
        currentNumberTextView = findViewById(R.id.current_number);

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

        // 表示中の数字を更新
        callNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCallNumber(maxNumber);
            }
        });

    }

    // callNumberButtonがタップされた時の処理
    private void onClickCallNumber(int maxNumber) {
        // maxNumberを考慮したランダムな数値
        int callNumber = createRandomNumber();
        while(history.contains(""+ callNumber)) {
            Log.d("MainActivity", "重複したので再生成します");
            callNumber = createRandomNumber();
        }
        // callNumberを文字列に変換する
        String callNumberStr = ""+ callNumber;
        // callNumberを画面に表示
        currentNumberTextView.setText(""+ callNumberStr);
        // 履歴を残す
        history.add(callNumberStr);
        Log.d("MainActivity", history.toString());
    }

    // maxNumberを考慮したランダムな数値を生成する処理
    private int createRandomNumber() {
        // ランダムな数値を生成(0.0~maxNumberの値-1までの範囲)
        double randomNumber = Math.random()*(maxNumber-1);
        // (1~maxNumberまでの範囲に変換)
        return (int) randomNumber++;
    }
}