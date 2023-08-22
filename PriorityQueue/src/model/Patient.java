package model;

public class Patient implements Comparable<Patient> {
	
	private String namePatient;
//	3 = alto, 2 = medio, 1 = bajo
	private int numberGravity;
	
	public Patient(String namePatient, int numberGravity) {
		this.namePatient = namePatient;
		this.numberGravity = numberGravity;
	}
	
	@Override
    public int compareTo(Patient patient) {
        return Integer.compare(patient.getNumberGravity(), this.numberGravity);
    }

	public String getNamePatient() {
		return namePatient;
	}

	public int getNumberGravity() {
		return numberGravity;
	}

	@Override
	public String toString() {
		return "Paciente: "+ namePatient + " Gravedad: " + numberGravity;
	}
	
	
	
	
	

}
