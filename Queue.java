
public class Queue {
	
	/** Setting 2 listNode objects in order to specify front node and rear node of the queue */
	listNode front = null;
	listNode rear = null;
	
	/** Initializing an integer variable "count" in order to determine the size of the queue
	 * size of the queue = number of nodes in the queue
	*/
	int count = 0;
	
	
	/**
	 * This method will add Strings to the queue respectively.
	 * @param str which is a String
	 *
	 * @return void
	 */
	public void enqueue(String str) {
		count++;
		listNode node = new listNode();
		node.arg = str;
		node.next = null;
		if(rear != null) {
			rear.next = node;
		} else {
			front = node;
		}
		rear = node;
	}
	
	/**
	 * This method will remove Strings from the queue respectively.
	 * @param nothing
	 *
	 * @return String
	 */
	public String dequeue() {
		count--;
		if(front != null) {
			if(front == rear) {
				rear = null;
			}
			String j = front.arg;
			front = front.next;
			return j;
		} else {
			return null;
		}
	}
	
	
	/**
	 * This method will combine all the tokens into a String
	 * We need to define this method, because the In2Post method will return a queue, and we can't just print the
	 * queue. We must combine all the nodes together and then print the single String
	 * @param q which is a Queue
	 *
	 * @return String
	 */
	public String toString(Queue q) {
		int c = count;
		String output = "";	//an empty output string to store each nodes into
		
		while (c != 0) {	// while there are still nodes in the queue
			output += q.front.arg;
			output += " ";
			q.front = q.front.next;	//going to the next node
			c--;
		}
		return output;
	}
	
}
