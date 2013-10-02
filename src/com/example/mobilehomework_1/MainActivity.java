package com.example.mobilehomework_1;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

import com.example.mobilehomework_1.EditDialogFragment;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends FragmentActivity 
				implements EditDialogFragment.EditDialogListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void showDialog(View view)
	{
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new EditDialogFragment();
        dialog.show(getFragmentManager(), "EditDialogFragment");
	}

	@Override
	public void onDialogPositiveClick(String sText) {
		System.out.println(sText);
		
	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		System.out.println("onDialogNegativeClick");
		
	}
}
