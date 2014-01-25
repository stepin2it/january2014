package com.stepin2it.tasktracker;

import com.stepin2it.tasktracker.DatabaseAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{
	private Button mAddButton;
	private EditText mTitleText;
	private EditText mDateText;
	private EditText mDescriptionText;
	private EditText mNotesText;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mAddButton = (Button) this.findViewById(R.id.addButton);
		mTitleText = (EditText) this.findViewById(R.id.titleText);
		mDateText = (EditText) this.findViewById(R.id.dateText);
		
		// Button b1 = new Button(this);

		mAddButton.setText("Add New Task");

		final DatabaseAdapter db = new DatabaseAdapter(this); 
		
		mAddButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this,
						TaskListActivity.class);
				startActivity(intent);	
				db.open();
				 long id = db.insertRecord(mTitleText.getText().toString(), 
						 mDateText.getText().toString(), 
						 mDescriptionText.getText().toString(), 
						 mNotesText.getText().toString());
				  db.close();
				 
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
