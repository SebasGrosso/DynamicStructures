package model;

import java.util.LinkedList;

public class Users {
	
	private LinkedList <User> Users;
	
	public Users () {
		Users = new LinkedList <User>();
		registedUsers();
	}
	
	public void addUser (User user) {
		Users.add(user);
	}
	
	public void registedUsers() {
		Users.add(new User("Carlos"));
		Users.add(new User("Fabian"));
		Users.add(new User("Juliana"));
		Users.add(new User("Alejandra"));
	}

	public LinkedList<User> getUsers() {
		return Users;
	}

	public void setUsers(LinkedList<User> users) {
		Users = users;
	}
	
	

}
