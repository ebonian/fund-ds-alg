
public class SimulateQueue {

	CustomerInfo[][] allEvents; //events in each and every queue
 
	MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		//TODO: implement this method.
		for (int i = 0; i < allEvents.length; i++) {
			CustomerInfo[] events = allEvents[i];
			MyQueue queue = allQueues[i];
			
			for (CustomerInfo event: events) {
				if (event.time >= t) {
					continue;
				}
				
				if (event.event == 1) {
					queue.insertLast(1);
				}
				
				if (event.event == -1) {
					queue.removeFirst();
				}
			}
		}
	}

}
