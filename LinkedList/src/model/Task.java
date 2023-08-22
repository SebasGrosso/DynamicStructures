package model;

import java.sql.Date;

public class Task {
	
	private String name, description, dueDate;
	
	public Task(String name, String description, String dueDate) {
		super();
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", description=" + description + ", dueDate=" + dueDate + "]";
	}
	
	

}
