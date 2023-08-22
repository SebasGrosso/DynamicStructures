package presenter;

import java.util.PriorityQueue;

import model.Patient;
import model.Turn;
import view.View;

public class Presenter {
	
	private Turn turn;
	private View view;
	
	public Presenter () {
		turn = new Turn();
		view = new View();
	}
	
	public void addNewTurn() {
		String namePatient = view.readString("Digite el nombre del paciente:");
		int numberGravity = view.readInt("Ingrese el numero de gravedad del paciente siendo \n1. Bajo\n2. Medio\n3. Alto");
		turn.addTurn(namePatient, numberGravity);
	}
	
	public void showTurns() {
		String assistant = "";
		PriorityQueue<Patient> priorityPatient = turn.getPriorityPatient();
		while(!priorityPatient.isEmpty()) {
			assistant = assistant + priorityPatient.poll()+"\n";
		}
		view.showMessage(assistant);
	}
	
	public int showMenu() {
		int option = view.readInt("Digite una opcion: \n1.Agregar nuevo turno. \n2.Mostrar turnos. \n3.Salir.");
		return option;
	}
	
	public void run() {
		int option = 0;
		do {
			option = showMenu();
			switch (option) {
			case 1:
				addNewTurn();
				break;
			case 2:
				showTurns();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				view.showMessage("La opcion digitada no es correcta. ");
				break;
			}

		} while (option != 3);
	}

}
