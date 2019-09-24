package com.nvk.baitaphomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_CHECK_VISIBLE = "visible";
    private static final String KEY_COUNTER = "counter";
    private TextView tvCounter;


    private static  final String KEY_RESTORE = "Save";

    int counter = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Radiation();

        if (savedInstanceState != null){
            Boolean isVisible = savedInstanceState.getBoolean(KEY_CHECK_VISIBLE);
            if (isVisible){
                tvCounter.setVisibility(View.VISIBLE);
                this.counter = savedInstanceState.getInt(KEY_COUNTER);//Cập nhập Lại Biến toàn cục để khi counter thì không bị reset về 0
                tvCounter.setText(savedInstanceState.getString(KEY_RESTORE));
            }

        }
    }


    private void Radiation() {
        tvCounter = findViewById(R.id.tvCounter);

    }

    public void Counter(View view) {
        counter ++;
        tvCounter.setText(String.valueOf(counter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (tvCounter.getVisibility() == View.VISIBLE){
            outState.putInt(KEY_COUNTER,counter);
            outState.putBoolean(KEY_CHECK_VISIBLE,true);
            outState.putString(KEY_RESTORE,tvCounter.getText().toString());
        }

    }
}
