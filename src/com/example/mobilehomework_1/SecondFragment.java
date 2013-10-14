package com.example.mobilehomework_1;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SecondFragment extends Fragment 
{
	 public static SecondFragment newInstance(String text) {
		 	SecondFragment f = new SecondFragment();

	        Bundle args = new Bundle();
	        args.putString("text", text);
	        f.setArguments(args);

	        return f;
	    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View view = inflater.inflate(R.layout.second_screen, null);
		
		String sText = getText();
        TextView leftTextView  = (TextView)view.findViewById(R.id.leftTextBlock);
        TextView rightTextView  = (TextView)view.findViewById(R.id.rightTextBlock);
        
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
        
	    return view;
	}
	
	public String getText()
	{
		return  getArguments().getString("text");
	}
	
	/*@Override
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
    }*/
}