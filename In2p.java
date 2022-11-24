import acm.program.ConsoleProgram;

/**
 * 
 * @author Rambod Azimi, 260911967
 * Assignment 3
 * ECSE 202
 * Winter 2021
 * McGill University
 *
 * This program converts infix mathematical expressions to PostFix expression. This is important because we are
 * going to build a calculator and thus, converting to PostFix makes it a lot easier to evaluate the expression
 *
 *
 */

/** In2p class is responsible for getting input from the user and pass the input to the desired methods of 
 * postFix class. It extends ConsoleProgram class, because we want to run the program into a console.
 */
public class In2p extends ConsoleProgram {
	
	public void run() {
		
		/** Printing the instructions */
		println("Rambod Azimi - 260911967 - ECSE 202 - Assignment 3 - Winter 2021");
		println("Infix to Postfix conversion, enter expression of blank line to exit.");
		
		/** The while loop gets strings from the user until it sees blank line to terminate the program */
		while(true) {
			
			/** Creating an instance from postFix class in order to use its methods (parse and In2Post) */
			postFix obj = new postFix();
			
			/** We put queue object inside a while loop in order to create new instances as the user types
			new strings
			*/
			Queue queue = new Queue();
			
			/** Getting a string from the user and save its reference in the "infix" variable */
			String infix = readLine("expr: ");
			
			/** Blank line to terminate the program */
			if(infix.equals("")) break;
			
			/** Calling parse method which is defined in the postFix class, so as to parse the string into
			 * a set of tokens
			 * We save the tokens into a queue, because parse method will return a Queue object
			*/
			queue = obj.parse(infix);
			
			
			/** Calling In2Post method which is defined in the postFix class, so as to convert the string into
			 * PostFix expression
			 * We save the PostFix expression into a queue, because In2Post method will return a Queue object
			*/
			queue = obj.In2Post(queue);
			
			/** Printing the result */
			println(infix + " ==> " + queue.toString(queue));
			queue.count = 0;
		}
		
		println("Program terminated.");	//if the user enter a blank line
		
	}	//end of run() method
	
}	//end of In2p class
