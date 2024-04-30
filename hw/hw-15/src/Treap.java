public class Treap {
	TreapNode root;
	int size;
	
	public Treap() {};

    public TreapNode insert(int v, int h) {
    	root = this.insertNode(v, h, root, null);
    	
    	return root;
    }
    
    TreapNode insertNode(int v, int h, TreapNode currentNode, TreapNode parentNode) {
    	if (currentNode == null) {
    		currentNode = new TreapNode(v, h, null, null, parentNode);
    		size++;
    	}
    	
    	if (v < currentNode.bstValue) {
    		currentNode.left = insertNode(v, h, currentNode.left, currentNode);
    	}
    	
    	if (v > currentNode.bstValue) {
    		currentNode.right = insertNode(v, h, currentNode.right, currentNode);
    	}
    	

    	if (currentNode.left != null && currentNode.heapValue > currentNode.left.heapValue) {
    		currentNode = rotateLeft(currentNode);
    	}
    	
    	if (currentNode.right != null && currentNode.heapValue > currentNode.right.heapValue) {
    		currentNode = rotateRight(currentNode);
    	}
    
    	
    	return currentNode;
    }
    
    TreapNode rotateLeft(TreapNode node) {
    	TreapNode leftNode = node.left;
		TreapNode rightOfLeftNode = node.left.right;
		node.left = rightOfLeftNode;
		
		if (rightOfLeftNode != null) {
			rightOfLeftNode.parent = node;
		}
		
		leftNode.right = node;
		leftNode.parent = node.parent;
		node.parent = leftNode;

		return leftNode;
    }
    
    TreapNode rotateRight(TreapNode n) {
		TreapNode rightNode = n.right;
		TreapNode leftOfRightNode = n.right.left;
		n.right = leftOfRightNode;
		
		if (leftOfRightNode != null) {
			leftOfRightNode.parent = n;
		}
		
		rightNode.left = n;
		rightNode.parent = n.parent;
		n.parent = rightNode;

		return rightNode;
	}
}