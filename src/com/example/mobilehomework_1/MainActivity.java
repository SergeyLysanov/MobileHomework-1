package com.example.mobilehomework_1;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.mobilehomework_1.EditDialogFragment;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends FragmentActivity 
				implements EditDialogFragment.EditDialogListener
{
	static final String STATE_TEXT = "edit_text";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    // Check whether we're recreating a previously destroyed instance
	    if (savedInstanceState != null) {
	        // Restore value of members from saved state
	        String sText = savedInstanceState.getString(STATE_TEXT);
	        EditText mainEdit  = (EditText)findViewById(R.id.mainEditText);
	        mainEdit.setText(sText);
	    } else {
	        // Probably initialize members with default values for a new instance
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) 
	{
		EditText mainEdit  = (EditText)findViewById(R.id.mainEditText);
		String sText = mainEdit.getText().toString();
	    savedInstanceState.putString(STATE_TEXT, sText);
	    
	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}
	
	//Button listener
	public void showDialog(View view)
	{
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new EditDialogFragment();
        dialog.show(getFragmentManager(), "EditDialogFragment");
	}

	//Button listener
	public void showScreen2(View view)
	{
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        EditText mainEdit  = (EditText)findViewById(R.id.mainEditText);
		String sText = mainEdit.getText().toString();
        intent.putExtra("text", sText);
        startActivity(intent);
	}
	
	//Button listener
	public void showScreen3(View view)
	{
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
	}
	
	//Button listener
	public void showScreen4(View view)
	{
        Intent intent = new Intent(MainActivity.this, FourthActivity.class);
        startActivity(intent);
	}
	
	@Override
	public void onDialogPositiveClick(String sText) {
		EditText mainEdit  = (EditText)findViewById(R.id.mainEditText);
		mainEdit.setText(sText);
	}

	@Override
	public void onDialogNegativeClick() {
		System.out.println("onDialogNegativeClick");
		
	}
}
