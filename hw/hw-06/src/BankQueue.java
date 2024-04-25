
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		float peoples = 0;
		
		for (DeQ counter: counters) {
			peoples += counter.size();
		}
		
		peoples += special.size();
		
		int length = Math.round(peoples / (counters.length + 1));
		
		for (DeQ counter : counters) {
			for (int i = 0; i < length; i++) {
				counter.insertLast(counter.removeFirst());
			}
			
			while (special.size() != length && counter.size() != length) {
				special.insertLast(counter.removeFirst());
			}
			
			if (counter.size() > length) {
				for (int i = 0; i < counter.size() - length; i++) {
					counter.insertLast(counter.removeFirst());
				}
			}
			
			if (special.size() == length) {
				break;
			}
		}
		
		if (special.size() == 0) {
			special.insertLast((counters[counters.length-1].removeLast()));
		}
	}

}
