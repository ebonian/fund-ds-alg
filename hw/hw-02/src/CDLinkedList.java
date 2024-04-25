public class CDLinkedList {
	DListNode header;
	int size;
	static final int HEADERVALUE = -9999999;

	public CDLinkedList() {
		header = new DListNode(HEADERVALUE);
		makeEmpty();// necessary, otherwise next/previous node will be null
	}

	public boolean isEmpty() {
		return header.nextNode == header;
	}

	public boolean isFull() {
		return false;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = header;
		header.previousNode = header;
		size = 0;
	}

	// put in new data after the position of p.
	public void insert(int value, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(int value) throws Exception {
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				return -1;
			if (v == value)
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public int findKth(int kthPosition) throws Exception {
		if (kthPosition < 0 || kthPosition > size - 1)
			throw new Exception();// exit the method if the position is
		// beyond the first/last possible
		// position, throwing exception in the process.
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				throw new Exception();
			if (index == kthPosition)
				return v;
		}
		throw new Exception();
	}

	// Return iterator at position before the first position that stores value.
	// If the value is not found, return null.
	public Iterator findPrevious(int value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new DListIterator(header);
		Iterator itr2 = new DListIterator(header);
		int currentData = itr2.next();
		while (currentData != value) {
			currentData = itr2.next();
			itr1.next();
			if (((DListIterator) itr2).currentNode == header)
				return null;
		}
		return itr1;
	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof DListIterator))
			return;
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(int value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
				|| ((DListIterator) p).currentNode == header)
			return;

		DListIterator p2 = (DListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		Iterator itr = new DListIterator(header);
		while (itr.hasNext()) {
			Object data = itr.next();

			System.out.println(data);

		}
	}

	public int size() throws Exception {
		return size;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof DListIterator))
			return null;
		if (((DListIterator) position).currentNode == null)
			return null;

		DListIterator p = ((DListIterator) position);
		DListIterator p2 = new DListIterator(p.currentNode.previousNode);
		return p2;

	}

	public void swapRange(Iterator s1, Iterator f1, Iterator s2, Iterator f2) throws Exception {
		if (s1 == null || f1 == null || s2 == null || f2 == null) {
			return;
		}

		if (!s1.hasNext() || !f1.hasNext() || !s2.hasNext() || !f2.hasNext()) {
			return;
		}

		DListIterator itr1 = (DListIterator) s1,
				itr2 = (DListIterator) f1,
				itr3 = (DListIterator) s2,
				itr4 = (DListIterator) f2;

		DListNode start1 = itr1.currentNode,
				end1 = itr2.currentNode,
				start2 = itr3.currentNode,
				end2 = itr4.currentNode,
				prev1 = start1.previousNode,
				next1 = end1.nextNode,
				prev2 = start2.previousNode,
				next2 = end2.nextNode;

		if (end1.equals(prev2)) {
			next1 = start1;

			end2.nextNode = start1;
			start1.previousNode = end2;
		} else {
			end2.nextNode = next1;
			next1.previousNode = end2;
		}

		prev1.nextNode = start2;
		start2.previousNode = prev1;

		prev2.nextNode = start1;
		end1.nextNode = next2;
		start1.previousNode = prev2;
		next2.previousNode = end1;
	}
}