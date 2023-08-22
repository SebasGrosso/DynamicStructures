package presenter;

import view.View;

import java.util.LinkedList;

import model.Task;
import model.TaskManager;
import model.User;

public class Presenter {
	
	private View view;
	private TaskManager taskManager;
	private User user;
	
	
	public Presenter() {
		view = new View();
		taskManager = new TaskManager();
	}
	
	public void addNewTask() {
		String nameTask = view.readString("Digite el nombre de la tarea:");
		String descriptionTask = view.readString("Digite la descripcion de la tarea:");
		String dueDateTask = view.readString("Digite la fecha de vencimiento de la tarea");
		taskManager.addNewTask(nameTask, descriptionTask, dueDateTask);
		view.showMessage("La tarea fue agregada de forma exitosa.");
	}
	
	public void assinUserTask() {
		String nameTask = view.readString("Digite el nombre de la tarea que desea asignar: ");
		String nameUser = view.readString("Digite el nombre del usuario al que le quiere asignar la tarea: ");
		taskManager.assinTask(nameTask, nameUser);
		view.showMessage("La tarea "+nameTask+ " fue agregada a "+nameUser+" de forma exitosa.");
	}
	
	public void showAssinTaskUser() {
		String nameUser = view.readString("Digite el nombre del usuario: ");
		LinkedList<Task> userTasks = taskManager.showAssinTaskUser(nameUser);
		for (Task task : userTasks) {
			view.showMessage(task+"");
		}
	}

	public int seeMenu() {
		int option = view.readInt("Digite una opcion: \n1.Agregar tarea. \n2.Asignar tarea a un usuario. \n3.Ver tareas de un usuario. \n4.Salir.");
		return option;
	}
	
	public void run() {
		int option = 0;
		do {
			option = seeMenu();
			switch (option) {
			case 1:
				addNewTask();
				break;
			case 2:
				assinUserTask();
				break;
			case 3:
				showAssinTaskUser();
				break;
			case 4:
				System.exit(0);
				break;
			
			default:
				view.showMessage("La opcion digitada no es correcta. ");
				break;
			}

		} while (option != 4);
	}
	
}
