package model;

import java.util.LinkedList;

public class User {
	
	private String nameUser;
	private LinkedList <Task> tasks;
	
	public User (String nameUser) {
		this.nameUser = nameUser;
		tasks = new LinkedList <Task>();
	}
	
	public void addUserTask(Task task) {
		tasks.add(task);
	}

	public LinkedList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(LinkedList<Task> tasks) {
		this.tasks = tasks;
	}

	public String getNameUser() {
		return nameUser;
	}

	@Override
	public String toString() {
		return "User [nameUser=" + nameUser + ", tasks=" + tasks + "]";
	}
	
	
	
}
