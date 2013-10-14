package com.example.mobilehomework_1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CheckDialogFragment extends DialogFragment
{
    public interface CheckDialogListener {
        public void onDialogPositiveClick(boolean isChecked);
    }
    
    CheckBox				mCheckbox;
    CheckDialogListener 	mListener;
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the EditDialogListener so we can send events to the host
            mListener = (CheckDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement EditDialogListener");
        }
    }
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        
        final View textEntryView = inflater.inflate(R.layout.check_dialog_layout, null);
        builder.setView(textEntryView);
        mCheckbox   = (CheckBox)textEntryView.findViewById(R.id.checkBox);
        
        builder.setMessage("Dialog")
               .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   mListener.onDialogPositiveClick(mCheckbox.isChecked());
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) 
                   {
                	   //mListener.onDialogNegativeClick();
                   }
               });
        
        return builder.create();
    }

}
