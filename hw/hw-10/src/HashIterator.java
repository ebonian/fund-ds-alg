
public class HashIterator implements Iterator {

	OpenAddressing h; // the associated hash table
	int currentPos;   // position in the table's array that is currently marked.

	
	//Create an iterator that marks the leftmost actual data in the hash table.
	//Assume actual data are not 0 and DELETED.
	//If there are no actual data in the table, set currentPos to -1.
	public HashIterator(OpenAddressing o) {
		h = o;
		int i = 0;
		for (; i < o.array.length; i++) {
			if (o.array[i] != 0 && o.array[i] != OpenAddressing.DELETED) {
				currentPos = i;
				break;
			}
		}
		if (i >= o.array.length) {
			currentPos = -1;
		}
	}

	@Override
	public boolean hasNext() {
		for (int temp = this.currentPos + 1; temp < h.array.length; temp++) {
			if (h.array[temp] != 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasPrevious() {
		for (int temp = this.currentPos - 1; temp >= 0; temp--) {
			if (h.array[temp] != 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int next() throws Exception {
		if (this.hasNext()) {
			this.currentPos++;
			
			while (h.array[this.currentPos] == 0) {
				this.currentPos++;
			}
			
			return h.array[this.currentPos];
		} else {
			throw new Exception();
		}
	}

	@Override
	public int previous() throws Exception {
		if (this.hasPrevious()) {
			int temp = this.currentPos;
			
			this.currentPos--;
			
			while (h.array[this.currentPos] == 0) {
				this.currentPos--;
			}
			
			
			return h.array[temp];
		} else {
			throw new Exception();
		}
	}

	@Override
	public void set(int value) {
		// does not do anything,
		//because it will break hash table definition

	}

}
