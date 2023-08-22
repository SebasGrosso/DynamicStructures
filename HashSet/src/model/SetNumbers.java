package model;

import java.util.*;

public class SetNumbers {

	private Set<Integer> inputSet = new HashSet<>();

	public SetNumbers(Set<Integer> inputSet) {
		this.inputSet = inputSet;
	}

	public Set<Set<Integer>> generateSets() {
		return generatePowerSet(inputSet);
	}

	public static Set<Set<Integer>> generatePowerSet(Set<Integer> inputSet) {
		Set<Set<Integer>> powerSet = new HashSet<>();
		powerSet.add(new HashSet<>());

		for (Integer element : inputSet) {
			Set<Set<Integer>> newSubsets = new HashSet<>();
			for (Set<Integer> subset : powerSet) {
				Set<Integer> newSubset = new HashSet<>(subset);
				newSubset.add(element);
				newSubsets.add(newSubset);
			}
			powerSet.addAll(newSubsets);
		}

		return powerSet;
	}
}
