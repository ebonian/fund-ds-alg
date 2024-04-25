
public class TypingDeadList extends CDLinkedList {
	int score = 0;  //not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void findWord(String w) throws Exception {
		// update start and end to mark position of the first occurrence of w
		// The word cannot cross header node
		// If w is not in the list, do nothing.
		// w is assumed never to be an empty string.


		//fill code
		DListIterator itr = new DListIterator(header);
		
		while (true) { 
			
			//set iterator for start --> start = w[0]
			if (itr.currentNode.data == w.charAt(0)) {
				start = new DListIterator(itr.currentNode);
			}
			
			//if have start and currentNode is the last letter in string w
			if (start != null && itr.currentNode.data == w.charAt(w.length() - 1)) {
				end = new DListIterator(itr.currentNode);
			}
			
			itr.next();
			
			//if have start and currentNode circulates back to the first one
			//set everything to null and break <-- from test case
			if (start != null && itr.currentNode == header) {
				start = null;
				end = null;
				break;
			}
			
			//if we have start and end
			if (end != null) {
				break;
			}
			
			//if it circulates back to the first one
			if (itr.currentNode == header) {
				break;
			}
			
		}
	}

	public void remove(int dec) throws Exception { // this must be the last method in your code!
		// remove data from start to end, inclusive,
		// if start or end is at header, do nothing.
		// size to remove is one of the known parameter -> reduce the size parameter of
		// the list

		//fill code
		if (start == null || end == null || start.currentNode == header || end.currentNode == header) {
		    return;
		}

		start.currentNode.previousNode.nextNode = end.currentNode.nextNode;
		end.currentNode.nextNode.previousNode = start.currentNode.previousNode;

		size -= dec;

		start = null;
		end = null;
	}

}
