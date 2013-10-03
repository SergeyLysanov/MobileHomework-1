package com.example.mobilehomework_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.second_screen);
        
        Intent intent = getIntent();
        String sText = intent.getStringExtra("text");
        
        TextView leftTextView  = (TextView)findViewById(R.id.leftTextBlock);
        TextView rightTextView  = (TextView)findViewById(R.id.rightTextBlock);
        
        if(sText.isEmpty())
        {
	        leftTextView.setText("Нет текста");
			rightTextView.setText("Нет текста");
        }
        else
        {
	        int mid = sText.length() / 2;
	        
	        
	        leftTextView.setText(sText.substring(0, mid));
			rightTextView.setText(sText.substring(mid));
        }
    }
}