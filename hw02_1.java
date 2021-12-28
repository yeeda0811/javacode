package Data_Structure;

import java.util.*;

public class hw02_1 {

	static void reverse(String s) {

		Stack<String> reversearr = new Stack<>();

		// Create an empty temporary String
		String temp = "";

		// Traversing the entire String
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {

				// Push the temporary
				// variable into the stack
				reversearr.add(temp);

				// Assigning temporary
				// variable as empty
				temp = "";
			} else {
				temp = temp + s.charAt(i);
			}

		}

		// For the last word
		// of the String
		reversearr.add(temp);

		while (!reversearr.isEmpty()) {
			// Get the words in
			// reverse order
			temp = reversearr.peek();
			System.out.print(temp + " ");
			reversearr.pop();
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		reverse(s);
	}

}
