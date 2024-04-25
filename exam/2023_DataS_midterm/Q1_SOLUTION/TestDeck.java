import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDeck {

	Deck d,d2,d3; 

	@BeforeEach
	void setUp() throws Exception {
		d = new Deck();
		d.putBottom(3);
		d.putBottom(1);
		d.putBottom(6);
		d.putBottom(9);
		d.putBottom(4);
		
		d2 = new Deck();
		d2.putBottom(3);
		d2.putBottom(1);
		d2.putBottom(6);
		d2.putBottom(9);
		d2.putBottom(5);
		d2.putBottom(7);
		d2.putBottom(10);
		d2.putBottom(8);
		d2.putBottom(2);
		
		d3 = new Deck();
		d3.putBottom(1);
		d3.putBottom(2);
		d3.putBottom(3);
		d3.putBottom(4);
		d3.putBottom(5);
		d3.putBottom(6);
		d3.putBottom(7);
		d3.putBottom(8);
		d3.putBottom(9);
		d3.putBottom(10);
		
	}

	@Test
	void testDraw() {
		assertEquals(3, d.draw()); 
		assertEquals(1, d.draw()); 
		assertEquals(6, d.draw()); 
		assertEquals(9, d.draw()); 
		assertEquals(4, d.draw()); 
		assertEquals(-1, d.draw()); 
		assertEquals(-1, d.draw()); 
		
	}
	
	@Test
	void testPutBottom() {
		d.putBottom(5);
		d.putBottom(6);
		
		assertEquals(3, d.draw()); 
		assertEquals(1, d.draw()); 
		assertEquals(6, d.draw()); 
		assertEquals(9, d.draw()); 
		assertEquals(4, d.draw()); 
		assertEquals(5, d.draw()); 
		assertEquals(6, d.draw());
		assertEquals(-1, d.draw()); 
		assertEquals(-1, d.draw()); 
	}
	
	@Test
	void testRemoveNthFirst() {
		assertEquals(3,d.removeNth(0));
		assertEquals(1, d.draw()); 
	}
	
	@Test
	void testRemoveNthOut() {
		assertEquals(-1,d.removeNth(5));
		assertEquals(3, d.draw()); 
		assertEquals(1, d.draw()); 
		assertEquals(6, d.draw()); 
		assertEquals(9, d.draw()); 
		assertEquals(4, d.draw());
	}
	
	@Test
	void testRemoveNthLast() {
		assertEquals(4,d.removeNth(4));
		assertEquals(3, d.draw()); 
		assertEquals(1, d.draw()); 
		assertEquals(6, d.draw()); 
		assertEquals(9, d.draw()); 
		assertEquals(-1, d.draw());
	}
	
	@Test
	void testRemoveNthGeneric() {
		assertEquals(5,d2.removeNth(4));
		assertEquals(10,d2.removeNth(5));
		
		assertEquals(3, d2.draw()); 
		assertEquals(1, d2.draw()); 
		assertEquals(6, d2.draw()); 
		assertEquals(9, d2.draw()); 
		assertEquals(7, d2.draw());
		assertEquals(8, d2.draw());
		assertEquals(2, d2.draw());
	}
	
	@Test 
	void testReverseEmptyDeck() {
		Deck d0 = new Deck();
		d0.reverseTopN(0);
		assertEquals(-1, d0.draw());
	
	}
	
	@Test 
	void testReverseEntireDeck() {
		d.reverseTopN(8);
		d2.reverseTopN(20);
		d3.reverseTopN(13);
		
		assertEquals(4, d.draw()); 
		assertEquals(9, d.draw()); 
		assertEquals(6, d.draw()); 
		assertEquals(1, d.draw()); 
		assertEquals(3, d.draw());
		assertEquals(-1, d.draw());
		
		assertEquals(2, d2.draw()); 
		assertEquals(8, d2.draw()); 
		assertEquals(10, d2.draw()); 
		assertEquals(7, d2.draw()); 
		assertEquals(5, d2.draw());
		assertEquals(9, d2.draw());
		assertEquals(6, d2.draw());
		assertEquals(1, d2.draw());
		assertEquals(3, d2.draw());
		assertEquals(-1, d2.draw());
		
		assertEquals(10, d3.draw()); 
		assertEquals(9, d3.draw()); 
		assertEquals(8, d3.draw()); 
		assertEquals(7, d3.draw()); 
		assertEquals(6, d3.draw());
		assertEquals(5, d3.draw());
		assertEquals(4, d3.draw());
		assertEquals(3, d3.draw());
		assertEquals(2, d3.draw());
		assertEquals(1, d3.draw());
		assertEquals(-1, d3.draw());
		
	}
	
	@Test 
	void testReverseGeneric() {
		d.reverseTopN(4);
		assertEquals(9, d.draw()); 
		assertEquals(6, d.draw()); 
		assertEquals(1, d.draw()); 
		assertEquals(3, d.draw());
		assertEquals(4, d.draw()); 
		assertEquals(-1, d.draw());
		
		d2.reverseTopN(3);
		assertEquals(6, d2.draw());
		assertEquals(1, d2.draw());
		assertEquals(3, d2.draw());
		assertEquals(9, d2.draw());
		assertEquals(5, d2.draw());
		assertEquals(7, d2.draw());
		assertEquals(10, d2.draw());
		assertEquals(8, d2.draw());
		assertEquals(2, d2.draw());
		assertEquals(-1, d2.draw());
		
		d3.reverseTopN(6);
		assertEquals(6, d3.draw());
		assertEquals(5, d3.draw());
		assertEquals(4, d3.draw());
		assertEquals(3, d3.draw());
		assertEquals(2, d3.draw());
		assertEquals(1, d3.draw());
		assertEquals(7, d3.draw());
		assertEquals(8, d3.draw());
		assertEquals(9, d3.draw());
		assertEquals(10, d3.draw());
		assertEquals(-1, d3.draw());
		
	}
	
	
	
	

}
