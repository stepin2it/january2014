package com.stepin2it.tasktracker;

public class Photo
{
	private int photoId;
	private String photoTitle;
	private String photoDescription;
	
	public Photo(int photoId, String photoTitle, String photoDescription)
	{
		this.photoId = photoId;
		this.photoTitle = photoTitle;
		this.photoDescription = photoDescription;
		
	}
	
	public int getPhotoId()
	{
		return photoId;
	}

	public String getPhotoTitle()
	{
		return photoTitle;
	}
	public String getPhotoDescription()
	{
		return photoDescription;
	}
	public void setPhotoId(int photoId)
	{
		this.photoId = photoId;
	}
	public void setPhotoTitle(String photoTitle)
	{
		this.photoTitle = photoTitle;
	}
	public void setPhotoDescription(String photoDescription)
	{
		this.photoDescription = photoDescription;
	}
	

}
