package com.check.out.kosovo;

public class ObjectList {
	String title;
	String description;
	String category;

	public ObjectList(){}

	public ObjectList(String title, String description, String category) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
