
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		int pairOfWord = s1.size()/2;
		
		String word = "";
		
		for (int pair = 0; pair < pairOfWord; pair++) {
			int pair1 = s1.top();
			s1.pop();
			
			int pair2 = s1.top();
			s1.pop();
			
			int symbol = s2.top();
			s2.pop();
			
			if (symbol < 0) {
				word = alphabets.charAt(pair1 - pair2) + word;
			}
			
			if (symbol >= 0) {
				word= alphabets.charAt(pair1 + pair2) + word;
			}
		}
		
		return word;
	}
}
