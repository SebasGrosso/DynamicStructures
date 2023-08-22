package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Turn {

	private PriorityQueue<Patient> priorityPatient;

	public Turn() {
		priorityPatient = new PriorityQueue<Patient>();
		patients();
	}

	public void patients() {
		addTurn("Javier Pita", 3);
		addTurn("Mariana Ibañez", 3);
		addTurn("Sebastian Cardenas", 1);
		addTurn("Cristian Fuentes", 2);
		addTurn("Paula Castro", 2);
	}

	public void addTurn(String namePatient, int numberGravity) {
		priorityPatient.add(new Patient(namePatient, numberGravity));
	}

	public PriorityQueue<Patient> getPriorityPatient() {
		return priorityPatient;
	}

}
