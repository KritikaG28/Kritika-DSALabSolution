package com.gl.dsa.lab.question1;

import java.util.Stack;

/*
 * Write a program of Balancing Brackets, use a suitable data structure to print
 * whether the string entered is a Balanced Brackets or Unbalanced String
 */

public class BalancedBrackets {

	// function to check if brackets are balanced
	boolean areBracketsBalanced(String expr) {

		Stack<Character> stack = new Stack<Character>();

		// Traversing the Expression
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}

			// If current character is not opening
			// bracket, then it must be closing. So stack
			// cannot be empty at this point.
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());
	}

	// Driver method
	public static void main(String[] args) {
		BalancedBrackets brackets = new BalancedBrackets();
		String expression = "( [ [ { } ] ] )";
		 // expression = "( [ [ { } ] ] ) )";

		// Function call
		if (brackets.areBracketsBalanced(expression))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

}
