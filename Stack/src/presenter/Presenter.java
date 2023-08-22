package presenter;

import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Expression;
import view.View;

public class Presenter {

	private View view;
	private Expression expression;

	public Presenter() {
		view = new View();
		expression = new Expression();
	}

	public void evalueExpresion() {
		String stringExpression = view.readString("Ingrese la expresión matemática: ");
		double result = expression.evaluateExpression(stringExpression);
		JOptionPane.showMessageDialog(null, "Resultado: " + result);
	}

}
