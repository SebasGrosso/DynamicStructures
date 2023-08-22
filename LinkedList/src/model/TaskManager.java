package model;

import java.sql.Date;
import java.util.LinkedList;

public class TaskManager {

	private LinkedList<Task> taskManager;
	private Users users;
	private LinkedList<User> usersList;

	public TaskManager() {
		taskManager = new LinkedList<Task>();
		users = new Users();
		usersList = users.getUsers();
	}

	public void addNewTask(String name, String description, String dueDate) {
		taskManager.add(new Task(name, description, dueDate));
	}

	public void assinTask(String nameTask, String nameUser) {
		int i = searchTask(nameTask);
		int k = searchUser(nameUser);
		if (i != -1 && k != -1) {
			usersList.get(k).addUserTask(taskManager.get(i));
		}
	}

	public LinkedList showAssinTaskUser(String name) {
		int i = searchUser(name);
		LinkedList<Task> userTasks = usersList.get(i).getTasks();
		return userTasks;
	}

	public int searchTask(String name) {
		for (int i = 0; i < taskManager.size(); i++) {
			if (taskManager.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public int searchUser(String name) {
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).getNameUser().equals(name)) {
				return i;
			}
		}
		return -1;
	}

}
