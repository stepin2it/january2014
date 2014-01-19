package com.stepin2it.tasktracker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TaskListActivity extends Activity
{
	private List<Photo> mListOfPhotos = new ArrayList<Photo>();
	private static final String TAG = "TaskListActivity";
	private static final boolean PROD = false;
	private ListView myListView;
	
	public class MyCustomAdapter extends ArrayAdapter<Photo>
	{
		public MyCustomAdapter(Context context, int textViewResourceId,	List<Photo> mListOfPhotos)
		{
			super(context, textViewResourceId, mListOfPhotos);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			
			final int rownumber = position;
			View row = convertView;

			if (row == null)
			{
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.row_photos, parent, false);
			}
			
			row.setOnClickListener(new View.OnClickListener()
			{
				
				@Override
				public void onClick(View v)
				{
					if (!PROD)
					{
					Log.d(TAG, "-------------------" + rownumber);
					Log.d(TAG, "---id of photo :----------------" + mListOfPhotos.get(rownumber).getPhotoId());					
					}
					 Intent intent = new Intent(TaskListActivity.this, TaskViewActivity.class);
					 intent.putExtra("FLAG", 1);
					 intent.putExtra("PHOTO_ID", mListOfPhotos.get(rownumber).getPhotoId());
					 // intent.putExtra("PHOTO_BITMAP", mPhotoBitmap.get(rownumber));
					 //intent.putExtra("HASH_MAP", mMap);
					 int requestCode = 0;
					 //startActivityForResult(intent, requestCode);
					 startActivity(intent);
				}
				
			});

			TextView photoTitle = (TextView) row.findViewById(R.id.photoTitle);

			TextView photoDescription = (TextView) row
					.findViewById(R.id.photoDescription);

			photoTitle.setText(mListOfPhotos.get(position).getPhotoTitle());

			photoDescription.setText(mListOfPhotos.get(position).getPhotoDescription());
			
			int i = 0;
//			for(Photo p : mMap.keySet()){
//				Log.d(TAG, "--------------- HashMap Photo reference is = "+p.toString());
//				Log.d(TAG, "--------------- Actual Photo reference is = "+mListOfPhotos.get(i++).toString());
//			}		

			ImageView photoImageView = (ImageView) row.findViewById(R.id.photoImageView);
			photoImageView.setImageResource(R.drawable.ic_launcher);
			/*
			if(mPhotoBitmap.get(position) != null){
				if(mPhotoBitmap.get(position) != null){
					photoImageView.setImageBitmap(mPhotoBitmap.get(position));
				}
				else{
					Log.d(TAG, "Bitmap returned NULL");
				}
			}
			*/
			
			return row;
			

		}
	}
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tasklist_activity);
		myListView = (ListView) findViewById(R.id.myList);
		
		// dummy datasource
		for (int i=0; i<20; i++)
		{
			Photo photo = new Photo(i, "Test Title", "Test Desc");
			
			mListOfPhotos.add(photo);
			
			
		}
		
		MyCustomAdapter adapter = new MyCustomAdapter(this, R.layout.row_photos, mListOfPhotos);
		
		myListView.setAdapter(adapter);
		
		
	}

}
