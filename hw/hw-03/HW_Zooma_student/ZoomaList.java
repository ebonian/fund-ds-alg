
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	public void insert(int value, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator)) {
			return;
		}

		super.insert(value, p);

		DListIterator currentIterator = (DListIterator) p;
		currentIterator.next();
		DListIterator rightIterator = new DListIterator(currentIterator.currentNode);

		while (currentIterator.currentNode.data == rightIterator.currentNode.data) {
			int count = -1;

			if (currentIterator.currentNode.data == header.data) {
				currentIterator.currentNode = rightIterator.currentNode;
			} else {
				rightIterator.currentNode = currentIterator.currentNode;
			}

			while (currentIterator.currentNode.data == value) {
				currentIterator.currentNode = currentIterator.currentNode.previousNode;
				count++;
			}

			while (rightIterator.currentNode.data == value) {
				rightIterator.currentNode = rightIterator.currentNode.nextNode;
				count++;
			}

			if (count >= 3) {
				value = currentIterator.currentNode.data;
				score += count;
				this.removeBetween(currentIterator, rightIterator, count);
			} else {
				break;
			}
		}
	}

	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		// fill code
		DListNode leftNode = left.currentNode;
		DListNode rightNode = right.currentNode;

		if (leftNode == rightNode) {
			return;
		}

		leftNode.nextNode = rightNode;
		rightNode.previousNode = leftNode;

		size -= inc;

	}

}
