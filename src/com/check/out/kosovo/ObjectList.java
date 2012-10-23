package com.check.out.kosovo;

public class ObjectList {
	String title;
	String description;
	String distance;
	
	public ObjectList(){}
	
	public ObjectList(String title, String description, String distance) {
		super();
		this.title = title;
		this.description = description;
		this.distance = distance;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}

}
