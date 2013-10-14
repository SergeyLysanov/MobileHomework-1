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
import android.widget.EditText;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class EditDialogFragment extends DialogFragment
{
    public interface EditDialogListener {
        public void onDialogPositiveClick(String sText);
        public void onDialogNegativeClick();
    }
    
    EditText			mEditText;
    EditDialogListener 	mListener;
    
    // Override the Fragment.onAttach() method to instantiate the EditDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the EditDialogListener so we can send events to the host
            mListener = (EditDialogListener) activity;
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
        
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View textEntryView = inflater.inflate(R.layout.dialog_layout, null);
        builder.setView(textEntryView);
        mEditText   = (EditText)textEntryView.findViewById(R.id.dialogEditText);
        
        builder.setMessage("Dialog")
               .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   mListener.onDialogPositiveClick(mEditText.getText().toString());
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) 
                   {
                	   mListener.onDialogNegativeClick();
                   }
               });
        
        return builder.create();
    }

}
