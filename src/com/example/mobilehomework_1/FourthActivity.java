package com.example.mobilehomework_1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class FourthActivity extends FragmentActivity 
			implements CheckDialogFragment.CheckDialogListener 
{	
	static final String STATE_TEXT = "check_box";
	private boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_screen);

	    if (savedInstanceState != null) {
	    	isChecked = savedInstanceState.getBoolean(STATE_TEXT);
	    }
    }
    
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) 
	{
	    savedInstanceState.putBoolean(STATE_TEXT, isChecked);
	    super.onSaveInstanceState(savedInstanceState);
	}
    
    public void showDialog(View view)
    {
        if(!isChecked)
        {
        	CheckDialogFragment dialog = new CheckDialogFragment();
        	dialog.show(getFragmentManager(), "CheckDialogFragment");
        }
    }

	@Override
	public void onDialogPositiveClick(boolean isChecked) {
		this.isChecked = isChecked; 
	}
}
