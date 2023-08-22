package presenter;

import java.util.HashSet;
import java.util.Set;

import model.SetNumbers;
import view.View;

public class Presenter {

	private SetNumbers setNumbers;
	private View view;

	public Presenter() {
		view = new View();
	}

	public Set<Integer> createSet() {
		int n = view.readInt("Ingrese la cantidad de elementos en el conjunto: ");

		Set<Integer> inputSet = new HashSet<>();
		view.showMessage("Ingrese los elementos uno por uno:");
		for (int i = 0; i < n; i++) {
			inputSet.add(view.readInt("Ingrese el elemento #" + (i + 1)));
		}
		return inputSet;
	}

	public void sendAndShowSet() {
		setNumbers = new SetNumbers(createSet());
		Set<Set<Integer>> subSets = setNumbers.generateSets();
		view.showMessage(subSets + "");
	}

}
