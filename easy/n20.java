// Valid Parentheses t: O(n) s: O(n)
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        
        Stack<Character> stack = new Stack<Character>();
        
        int i = 0;
        while (i < s.length()) {
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '{' || tmp == '[') {
                stack.push(tmp);
                i++;
            }
            else {
                if (!stack.isEmpty() && isPaired(stack.peek(), tmp)) {
                    stack.pop();
                    i++;
                    continue;
                }
                else return false;
            }
        }
 
        return stack.isEmpty();
    }
    
    
    public boolean isPaired(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }
}
