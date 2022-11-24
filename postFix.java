import java.util.StringTokenizer;

public class postFix {

	
	/** Creating an object from Queue class */
	Queue queue = new Queue();
	
	
	/**
	 * This method will parse a String to tokens by using StringTokenizer class
	 * We need to define this method in order to break the mathematical expression to set of tokens
	 * @param str which is a String
	 *
	 * @return Queue
	 */
	public Queue parse(String str) {
		
		/** Break str (String variable) into set of tokens whenever it sees of of the symbols + - * \ ( ) % ^ */
		StringTokenizer st = new StringTokenizer(str,"+-*/()%^ ",true);
		
		/** Adding each token to the queue until the tokens are finished */
		while(st.hasMoreTokens()) {
			queue.enqueue(st.nextToken());
		}
		return queue;
	}
	
	
	/**
	 * This method will indicate whether the input String is number of operator
	 * We need to define this method in order to specify operators and numbers
	 * @param s which is a String
	 *
	 * @return int. Return -1 means that the input is a number. Return 1 means that the input is either + or -
	 * Return 2 means that the input is either * or /
	 */
	  public int precedence(String s){
		  
		  if(s.equals("+") || s.equals("-")) {
			  return 1; 
		  }else if (s.equals("*") || s.equals("/") || s.equals("%")) {
			  return 2;
		  }else if(s.equals("^")) {
			  return 3;
		  }else {
			  return -1;
		  }
	   }
	  
	  
	  
	public Queue In2Post(Queue Qin) {

        /** Creating to instances of Queue and Stack class
         * Stack is used in order to push operators on
         * Queue is used in order to Enqueue the numbers into
        */
	        Queue Qout = new Queue();
	        Stack stack = new Stack();
	        
	        for (int i = 0 ; i < Qin.count; i++) {
	        	
	            /** Saving the String value of the current node into a String variable, called c */
	            String c = Qin.front.arg;
	            
	            /** Going to the next node of the input queue */
	            Qin.front = Qin.front.next;
	            
	            /** Check whether c is an operator or not */
	            if(precedence(c) > 0){
	                while(!stack.isEmpty() && precedence(stack.top.arg) >= precedence(c)){
	                	Qout.enqueue(stack.pop());
	                }
	                stack.push(c);
	                
	                /** Check whether c is either left paren or right paren*/
	            }else if(c.equals("(")){
	                stack.push(c);
	                
	            }else if(c.equals(")")) {
	                String x = stack.pop();
	                
	                /** If c is (, while the operator at the top of the operator stack is not a left paren:      
	                 * pop the operator from the operator stack onto the output queue.*/
	                while(x.equals("(") == false) {
	                	Qout.enqueue(x);
	                    x = stack.pop();
	                }
	                
	            }else if(c.equals(" ")) {
	            	continue;	//neglecting the white space between numbers
	            	
	            }else{
	            	Qout.enqueue(c);
	            }

	        }	//end of for loop
	        
	        /** While there are still operator tokens on the stack,   
	         * pop the operator from the operator stack onto the output queue. 
	        */
	       while(!stack.isEmpty()) {
	    	   Qout.enqueue(stack.pop());
	        }
	        return Qout;
	    }
	
}
