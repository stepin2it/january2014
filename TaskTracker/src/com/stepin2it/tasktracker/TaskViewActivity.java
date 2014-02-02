package com.stepin2it.tasktracker;

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
		setContentView(R.layout.activity_taskview);
		
			
	}

}
