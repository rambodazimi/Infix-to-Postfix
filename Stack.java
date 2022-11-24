public class Stack {
	
	/** Defining an instance of listNode class to specify the top of the stack */
	listNode top = null;
	
	/** Initializing an integer count, indicating the number of nodes on the stack */
	int count = 0;
	
	
	/**
	 * This method will add a String to the stack
	 * @param str which is a String
	 * @return void
	 */
	public void push(String str) {
		count++;
		listNode node = new listNode();
		node.arg = str;
		node.next = top;
		top = node;
	}
	
	
	/**
	 * This method will remove a String from the stack and return the result
	 * @param void
	 * @return str which is a String
	 */
	public String pop() {
		count--;
		if(top == null) {
			return null;
		} else {
			String str = top.arg;
			top = top.next;
			return str;
		}
	}
	
	
	/**
	 * This method will return true if the stack is empty, and returns false if the stack is not empty
	 * @param void
	 * @return boolean
	 */
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
