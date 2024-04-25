
public class Deck {
	DeQ d = new DeQArray();
	
	public int draw() {
		try {
			return d.removeFirst();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int removeNth(int n) {
		try {
			int removed = -1;
			
			for (int i = 0; i < d.size(); i++) {
			    if (n == d.size() - 1) {
			        d.insertLast(d.removeFirst());
			        if (i == n) {
			            removed = d.removeLast();
			        }
			    } else {
			        if (i == n) {
			            removed = d.removeFirst();
			        }
			        d.insertLast(d.removeFirst());
			    }
			}
			
			return removed;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
    }
	
	public void putBottom(int n) {
		try {
			d.insertLast(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reverseTopN(int n) {
		try {	
			if (n > d.size()) {
				n = d.size();
			}
			
			int[] forReverse = new int[n];
			
			for (int i = 0; i < n; i++) {
				forReverse[i] = d.removeFirst();
			}
			
			for (int number : forReverse) {
				d.insertFirst(number);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
