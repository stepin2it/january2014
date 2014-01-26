package com.stepin2it.tasktracker;

import android.R;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TaskViewActivity extends Activity
{
	private TextView taskId;
	private TextView taskDueDate;
	private TextView taskTitle;
	private TextView taskDescription;
	private TextView taskNotes;
	
	private static final String TAG = "TaskViewActivity";
	

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d(TAG, "TaskViewActivity onCreate");
		// Creating programmatically instead of xml
		// Please debug the following code so that 
		// the fields for the task display correctly
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		layout.setLayoutParams(params);
		
		TextView idTextView = new TextView(this);
		TextView titleTextView = new TextView(this);
		
		layout.addView(idTextView);
		layout.addView(titleTextView);
		
		long taskId = this.getIntent().getLongExtra("TASK_ID", 0);
		
		idTextView.setText(String.valueOf(taskId));

		final DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
		db.open();

		Cursor c = db.getRecord(taskId);
		
		if (c.moveToFirst())
		{
			titleTextView.setText(c.getString(1));
		}
	
	}

}
