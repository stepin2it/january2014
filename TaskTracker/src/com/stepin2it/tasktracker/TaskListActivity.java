package com.stepin2it.tasktracker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TaskListActivity extends Activity
{
	private List<Photo> mListOfPhotos = new ArrayList<Photo>();
	private List<Task> mListOfTasks = new ArrayList<Task>();
	
	private static final String TAG = "TaskListActivity";
	private static final boolean DEBUG = true;
	private ListView myListView;
	public static final String KEY_ROWID = "id";
	public static final String KEY_TITLE = "title";
	public static final String KEY_DUEDATE = "duedate";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_NOTES = "notes";

	public class MyCustomAdapter extends ArrayAdapter<Task>
	{
		public MyCustomAdapter(Context context, int textViewResourceId,
				List<Task> mListOfTasks)
		{
			super(context, textViewResourceId, mListOfTasks);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{

			final int rownumber = position;
			View row = convertView;

			if (row == null)
			{
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.row_item, parent, false);
			}

			row.setOnClickListener(new View.OnClickListener()
			{

				@Override
				public void onClick(View v)
				{
					if (DEBUG)
					{
						Log.d(TAG, "-------------------" + rownumber);
						Log.d(TAG, "---id of task :----------------"
								+ mListOfTasks.get(rownumber).getTaskId());
					}
					Intent intent = new Intent(TaskListActivity.this,
							TaskViewActivity.class);
					intent.putExtra("FLAG", 1);
					intent.putExtra("TASK_ID", mListOfTasks.get(rownumber)
							.getTaskId());
					// intent.putExtra("PHOTO_BITMAP",
					// mPhotoBitmap.get(rownumber));
					// intent.putExtra("HASH_MAP", mMap);
					int requestCode = 1;
					startActivityForResult(intent, requestCode);
					// startActivity(intent);
				}

			});

			TextView taskTitle = (TextView) row.findViewById(R.id.itemTitle);

			TextView taskDescription = (TextView) row
					.findViewById(R.id.itemDescription);

			taskTitle.setText(mListOfTasks.get(position).getTitle());

			taskDescription.setText(mListOfTasks.get(position).getDescription());
			
			if (mListOfTasks.get(position).getDone()==1)
			{
				row.setBackgroundColor(this.getContext().getResources().getColor(R.color.task_done));
				
			}
			else
			{
				row.setBackgroundColor(this.getContext().getResources().getColor(R.color.task_not_done));
			}

			int i = 0;
			// for(Photo p : mMap.keySet()){
			// Log.d(TAG,
			// "--------------- HashMap Photo reference is = "+p.toString());
			// Log.d(TAG,
			// "--------------- Actual Photo reference is = "+mListOfPhotos.get(i++).toString());
			// }

			ImageView itemImageView = (ImageView) row
					.findViewById(R.id.itemImageView);
			itemImageView.setImageResource(R.drawable.ic_launcher);
			/*
			 * if(mPhotoBitmap.get(position) != null){
			 * if(mPhotoBitmap.get(position) != null){
			 * photoImageView.setImageBitmap(mPhotoBitmap.get(position)); }
			 * else{ Log.d(TAG, "Bitmap returned NULL"); } }
			 */

			return row;

		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tasklist_activity);
		if (DEBUG)
			Log.d(TAG, "Started TaskListActivity : onCreate");
		myListView = (ListView) findViewById(R.id.myList);



		// get records from database
		// ---get all Records---
		DatabaseAdapter db = new DatabaseAdapter(this);
		db.open();
		Cursor c = db.getAllRecords();
		Log.d(TAG, "Number of records : " + c.getCount());
		if (c.moveToFirst())
		{
			do
			{
				Task task = new Task(c.getInt(0),
						c.getString(1),
						c.getString(2),
						c.getString(3),
						c.getString(4),
						c.getInt(5)
						);
				
				mListOfTasks.add(task);
				displayRecord(c);
			} while (c.moveToNext());
		}
		db.close();

		MyCustomAdapter adapter = new MyCustomAdapter(this,
				R.layout.row_photos, mListOfTasks);

		myListView.setAdapter(adapter);

	}

	@Override
	public void onResume()
	{
		super.onResume();
		// TODO Add persistence using files or db

	}

	public void displayRecord(Cursor c)
	{
		Log.d(TAG, "id: " + c.getString(0) + "\n" + "Title: " + c.getString(1)
				+ "\n" + "Due Date:  " + c.getString(2));
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==1)
		{
		Log.d(TAG, "The user had gone from TaskListActivity to TaskViewActivity");
		
		}
	}

}
