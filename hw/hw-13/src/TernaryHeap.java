public class TernaryHeap extends Heap {
	public TernaryHeap() {
		final int DEFAULT_CAPACITY = 31;
		mData = new int[DEFAULT_CAPACITY];
	}
	
	@Override
	public void percolateUp() {
		int parent;
		int child = size - 1;
		int temp;
		
		while (child > 0) {
			parent = (child - 1) / 3;
			
			if (mData[parent] <= mData[child]) {
				break;
			}
			
			temp = mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}
	
	@Override
	public void percolateDown(int start) {
		int parent = start;
		int child = 3 * parent + 1;
		int temp;
		
		while (child < size) {
			int minIndex = findMinIndex(child);
			
			if (mData[parent] <= mData[minIndex]) {
				break;
			}
			
			temp = mData[minIndex];
			mData[minIndex] = mData[parent];
			mData[parent] = temp;
			
			parent = minIndex;
			child = 3 * parent + 1;
		}
	}
	
	public int findMinIndex(int child) {
		int minIndex = child;
		
		for (int i = child + 1; i < Math.min(size, child+3); i++) {
			if (mData[i]<mData[minIndex]) {
				minIndex = i;
			}
		}
		
		return minIndex;
	}
}