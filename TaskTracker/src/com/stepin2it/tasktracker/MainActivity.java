package com.stepin2it.tasktracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.stepin2it.tasktracker.DatabaseAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Button mAddButton;
	private EditText mTitleText;
	private EditText mDateText;
	private EditText mDescriptionText;
	private EditText mNotesText;
	private static final boolean DEBUG = true;
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (DEBUG)
			Log.d(TAG, "MainActivity: onCreate");
		mAddButton = (Button) this.findViewById(R.id.addButton);
		mTitleText = (EditText) this.findViewById(R.id.titleText);
		mDateText = (EditText) this.findViewById(R.id.dateText);
		mDescriptionText = (EditText) this.findViewById(R.id.descriptionText);
		mNotesText = (EditText) this.findViewById(R.id.notesText);
		final String title = mTitleText.getText().toString();
		final String date = mDateText.getText().toString();
		final String description = mDescriptionText.getText().toString();
		final String notes = mNotesText.getText().toString();

		// Button b1 = new Button(this);

		mAddButton.setText("Add New Task");
	
		final DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());

		mAddButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this,
						TaskListActivity.class);
				startActivity(intent);
				db.open();
				
//				if ((!TextUtils.isEmpty(title)) && (!TextUtils.isEmpty(date))
//						&& (!TextUtils.isEmpty(description))
//						&& (!TextUtils.isEmpty(notes)))
				if (true)
				{
					if (DEBUG) Log.d(TAG, "Preparing to insert record");
					long id = db.insertRecord(mTitleText.getText().toString(),
							mDateText.getText().toString(), mDescriptionText
									.getText().toString(), mNotesText.getText()
									.toString(), false);

				}
				else
				{
					Toast.makeText(MainActivity.this, "Please fill in text", Toast.LENGTH_LONG).show();
					
				}

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

	public void copyDB(InputStream inputStream, OutputStream outputStream)
			throws IOException
	{
		// ---copy 1K bytes at a time---
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0)
		{
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}

}
