package com.example.mobilehomework_1;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.mobilehomework_1.EditDialogFragment;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends FragmentActivity implements
		EditDialogFragment.EditDialogListener,
		CheckDialogFragment.CheckDialogListener {
	static final String STATE_CHECK = "check_box";
	private boolean isChecked = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_container);

		// Check whether we're recreating a previously destroyed instance
		if (savedInstanceState != null) {
			// Restore value of members from saved state
			this.isChecked = savedInstanceState.getBoolean(STATE_CHECK);
			return;
		}

		// Create a new Fragment to be placed in the activity layout
		MainFragment mainFragment = new MainFragment();
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.add(R.id.fragment_container, mainFragment);
		transaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putBoolean(STATE_CHECK, isChecked);
		super.onSaveInstanceState(savedInstanceState);
	}

	// Button listener
	public void showDialog(View view) {
		// Create an instance of the dialog fragment and show it
		EditDialogFragment dialog = new EditDialogFragment();
		dialog.show(getSupportFragmentManager(), "EditDialogFragment");
	}

	// Button listener
	public void showCheckDialog(View view) {
		if (!isChecked) {
			CheckDialogFragment dialog = new CheckDialogFragment();
			dialog.show(getSupportFragmentManager(), "CheckDialogFragment");
		}
	}

	// Button listener
	public void showScreen2(View view) {
		EditText mainEdit = (EditText) findViewById(R.id.mainEditText);
		String sText = mainEdit.getText().toString();
		SecondFragment fragment = SecondFragment.newInstance(sText);

		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_container, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	// Button listener
	public void showScreen3(View view) {
		ThirdFragment fragment = new ThirdFragment();
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_container, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	// Button listener
	public void showScreen4(View view) {
		FourthFragment fragment = new FourthFragment();
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_container, fragment, "fourth_screen");
		transaction.addToBackStack(null);
		transaction.commit();
	}

	@Override
	public void onDialogPositiveClick(String sText) {
		EditText mainEdit = (EditText) findViewById(R.id.mainEditText);
		mainEdit.setText(sText);
	}

	@Override
	public void onDialogNegativeClick() {
		System.out.println("onDialogNegativeClick");

	}

	// Check dialog
	@Override
	public void onDialogPositiveClick(boolean isChecked) {
		this.isChecked = isChecked;
	}
}
