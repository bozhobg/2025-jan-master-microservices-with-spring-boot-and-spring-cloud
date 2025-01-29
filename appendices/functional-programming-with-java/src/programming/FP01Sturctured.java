package programming;

import java.util.List;

public class FP01Sturctured {

	public static void main(String[] args) {

		List<Integer> listOfNumbers = List.of(12, 9, 13, 4, 6, 2, 4, 12);
		
		System.out.println("=== all numbers: ===");
		printAllNumbersInListStructuredApproach(listOfNumbers);
		
		System.out.println("=== even numbers: ===");
		printEvenNumbersInListStructuredApproach(listOfNumbers);
	}

	private static void printAllNumbersInListStructuredApproach(List<Integer> numbers) {
//		Hot to do?

		for (int number : numbers) {
			System.out.println(number);
		}
	}

	private static void printEvenNumbersInListStructuredApproach(List<Integer> numbers) {
//		Hot to do?

		for (int number : numbers) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		}
	}

}
