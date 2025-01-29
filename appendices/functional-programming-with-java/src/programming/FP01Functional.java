package programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

//		Streams:
		printAllNumbersInListFuncional(numbers);
//		Filters:
		printEvenNumbersInListFuncional(numbers);
		
//		Ex1:
		printOddNumbersInListFuncional(numbers); 

//		Ex2:
		printCoursesInListFuncitonal(courses);
//		Ex3:
		printCoursesInListFuncitonalContainingString(courses, "Spring");
//		Ex4:
		printCoursesInListFunctionalAtLeast4Letters(courses);

//		Mapping:
		printSquaresOfEvenNumbersInListFuncional(numbers);
		
//		Ex5:
		printCubesOfOddNumbersInListFuncional(numbers);
//		Ex6:
		printCoursesInListFunctionalCharacterLength(courses);
	}

	private static void printCoursesInListFunctionalCharacterLength(List<String> courses) {
		System.out.println("=== courses string lenght: ===");
		
		courses.stream()
			.map(c -> c.length())
			.forEach(c -> System.out.println(c));
	}

	private static void printCubesOfOddNumbersInListFuncional(List<Integer> numbers) {
		System.out.println("=== print cubes of odd number: ===");
		
		numbers.stream()
			.filter(n -> n % 2 != 0)
			.map(n -> n * n * n)
			.forEach(FP01Functional::print);
	}

	private static void printSquaresOfEvenNumbersInListFuncional(List<Integer> numbers) {
		numbers.stream()
			.filter(number -> number % 2 == 0)
			.map(number -> number * number)
			.forEach(FP01Functional::print);
	}

	private static void printCoursesInListFunctionalAtLeast4Letters(List<String> courses) {
		System.out.println("=== courses at least 4 characters long: ===");
		courses.stream()
			.filter(course -> course.length() >= 4)
			.forEach(FP01Functional::print);
	}

	private static void printCoursesInListFuncitonalContainingString(List<String> courses, String containing) {
		System.out.println("=== courses containing \"" + containing + "\": ===");
		
		courses.stream()
		.filter(course -> course.contains(containing))
		.forEach(FP01Functional::print);
	}

	private static void printCoursesInListFuncitonal(List<String> courses) {
		System.out.println("=== all courses: ===");
		
		courses.stream()
			.forEach(FP01Functional::print);
	}

	private static void printAllNumbersInListFuncional(List<Integer> numbers) {
//		What to do?
		System.out.println("=== all numbers: ===");
		numbers.stream()
			.forEach(FP01Functional::print);
	}

	private static void printEvenNumbersInListFuncional(List<Integer> numbers) {
		System.out.println("=== even numbers: ===");

		numbers.stream()
//		.filter(FP01Functional::isEven) // method reference
			.filter(number -> number % 2 == 0) // lambda expression
			.forEach(FP01Functional::print);
	}

	private static void printOddNumbersInListFuncional(List<Integer> numbers) {
		System.out.println("=== odd numbers: ===");

		numbers.stream()
			.filter(number -> !isEven(number))
			.forEach(num -> print(num));
	}

	private static void print(Object value) {
		System.out.println(value.toString());
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}
}
