package com.stepin2it.tasktracker;

public class Task
{
	private int taskId;
	private String title;
	private String duedate;
	private String description;
	private String notes;
	private int done;
	

	public Task(int taskId, String title, String duedate, String description,
			String notes, int done)
	{
		super();
		this.taskId = taskId;
		this.title = title;
		this.duedate = duedate;
		this.description = description;
		this.notes = notes;
		this.done = done;
	}
	public int getTaskId()
	{
		return taskId;
	}
	public void setTaskid(int taskId)
	{
		this.taskId = taskId;
	}
	public String getTitle()
	{
		return title;
	}
	public String getDuedate()
	{
		return duedate;
	}
	public String getDescription()
	{
		return description;
	}
	public String getNotes()
	{
		return notes;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public void setDuedate(String duedate)
	{
		this.duedate = duedate;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public void setNotes(String notes)
	{
		this.notes = notes;
	}
	public int getDone()
	{
		return done;
	}
	public void setDone(int done)
	{
		this.done = done;
	}
	
	
	
	
	
	
	
	
	
	
}
