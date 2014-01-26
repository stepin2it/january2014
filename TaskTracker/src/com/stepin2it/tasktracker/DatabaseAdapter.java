package com.stepin2it.tasktracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseAdapter {
    public static final String KEY_ROWID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DUEDATE = "duedate";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_NOTES = "notes";
    public static final String KEY_DONE = "done";
    private static final String TAG = "DBAdapter";
    
    private static final String DATABASE_NAME = "TasksDB";
    private static final String DATABASE_TABLE = "tasks";
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE =
        "create table if not exists tasks (id integer primary key autoincrement, "
        + "title VARCHAR not null, duedate date, description VARCHAR, notes VARCHAR, " +
        " done BOOL);";
        
    private final Context context;    

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DatabaseAdapter(Context context) 
    {
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
        	try {
        		db.execSQL(DATABASE_CREATE);	
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS tasks");
            onCreate(db);
        }
    }    

    //---opens the database---
    public DatabaseAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
    
    //---insert a record into the database---
    public long insertRecord(String title, 
    		String duedate, 
    		String description, 
    		String notes, 
    		boolean done) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TITLE, title);
        initialValues.put(KEY_DUEDATE, duedate);
        initialValues.put(KEY_DESCRIPTION, description);
        initialValues.put(KEY_NOTES, notes);
        initialValues.put(KEY_DONE, done);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular record---
    public boolean deleteRecord(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---retrieves all the records---
    public Cursor getAllRecords() 
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_TITLE,
                KEY_DUEDATE, KEY_DESCRIPTION, KEY_NOTES, KEY_DONE}, null, null, null, null, null);
    }

    //---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_TITLE, KEY_DUEDATE, KEY_DESCRIPTION, KEY_NOTES, KEY_DONE}, 
                KEY_ROWID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        
   
        return mCursor;
    }

    //---updates a record---
    public boolean updateRecord(long rowId, 
    		String title, 
    		String duedate, 
    		String description, 
    		String notes, 
    		boolean done) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_TITLE, title);
        args.put(KEY_DUEDATE, duedate);
        args.put(KEY_DESCRIPTION, description);
        args.put(KEY_NOTES, notes);
        args.put(KEY_DONE, done);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }

}
