package view;

import javax.swing.JOptionPane;

public class View {

	public View() {

	}

	// Metodo para leer datos de tipo int
	public int readInt(String message) {
		int integer = Integer.parseInt(JOptionPane.showInputDialog(null, message));
		return integer;
	}

	// Metodo para mostrar messages
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

}
