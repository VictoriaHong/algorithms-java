// Longest Absolute File Path O(n)
// file name may contain space
public class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        Stack<String> s = new Stack<String>();
        int res = 0;
        for (int i = 0; i < lines.length; i++) {
            char[] line = lines[i].toCharArray();
            int count = 0;
            while (line[count] == '\t') {
                count++;
            }
            if (count >= s.size()) {
                String name = lines[i].substring(count, lines[i].length());
                if(name.contains(".")) {
                    int pathlen = getLength(name, s);
                    res = res < pathlen ? pathlen : res;
                }
                else {
                    s.push(name);
                }
            }
            else {
                int size = s.size();
                while (count < size) {
                    s.pop();
                    size--;
                }
                String name = lines[i].substring(count, lines[i].length());
                if(name.contains(".")) {
                    int pathlen = getLength(name, s);
                    res = res < pathlen ? pathlen : res;
                }
                else {
                    s.push(name);
                }   
            }
        }
        return res;
    }
    
    public int getLength(String name, Stack<String> s) {
        String res = "";
        Object[] ss = s.toArray();
        for (int i = 0; i < ss.length; i++) {
            res += ss[i] + "/";
        }
        res += name;
        return res.length();
    }
}
