package com.example.mobilehomework_1;

import android.annotation.TargetApi;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SecondActivity extends FragmentActivity {

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