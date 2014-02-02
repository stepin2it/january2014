package com.stepin2it.tasktracker;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TaskViewActivity extends Activity
{
	private TextView taskId;
	private TextView taskTitle;
	private TextView taskDueDate;
	private TextView taskDescription;
	private TextView taskNotes;
	private Button markAsDoneButton;
	private static final String TAG = "TaskViewActivity";
	

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d(TAG, "TaskViewActivity onCreate");
		setContentView(R.layout.activity_taskview);
		taskTitle = (TextView) this.findViewById(R.id.textView1);
		taskDueDate = (TextView) this.findViewById(R.id.textView2);
		taskDescription = (TextView)this.findViewById(R.id.textView3);
		taskNotes = (TextView)this.findViewById(R.id.textView3);
		markAsDoneButton = (Button) this.findViewById(R.id.markAsDoneButton);
		final long taskId = this.getIntent().getIntExtra("TASK_ID", 0);
		Log.d(TAG, "TaskId is " + taskId);
		final DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
		db.open();
		Cursor c = db.getRecord(taskId);
		Log.d(TAG, "Number of records : " + c.getCount());
		if (c.moveToFirst())
		{
			taskTitle.setText(c.getString(1));
			taskDueDate.setText(c.getString(2));
			taskDescription.setText(c.getString(3));
			taskNotes.setText(c.getString(4));
		}
		
		markAsDoneButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				db.updateRecord(taskId, true); 
				finish();
			}
		});
	}

}
