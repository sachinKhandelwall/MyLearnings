import java.util.Stack;

public class Parenthesis_Imp {
	
	public static boolean isBalancedParanthesis(String str)
	{
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i< str.length(); i++) {
			char s = str.charAt(i);
			
			if(s == '(' || s == '{' || s == '[' ) {
				stack.push(s);
			}
			
			if(s == ')' || s == '}' || s == ']' ) {
				if(stack.isEmpty()) {
					return false;
				}
				else if( s == ')' && stack.peek() == '(' || s == '}' && stack.peek() == '{' || s == ']' && stack.peek() == '[' ) {
					stack.pop();
				}
			} 
			
		}
		
		if(stack.isEmpty()) {
			return true;
		} 
		else {
			return false;
		}
				
	}
	
	public static void main(String[] args) {
		
		String s = "[(s)]{ sachin}{[()(l)]( )}";
		boolean paranthesis = isBalancedParanthesis(s);
		
		if(paranthesis)
			System.out.println("Paranthesis is balanced");
		else
			System.out.println("Unbalanced Paranthesis");
	}

}
