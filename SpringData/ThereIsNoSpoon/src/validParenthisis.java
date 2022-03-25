import java.util.ArrayDeque;

public class validParenthisis {
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            char top = st.isEmpty() ? '#' : st.peek();
            if (top == '(' && c == ')') st.pop();
            else if (top == '{' && c == '}') st.pop();
            else if (top == '[' && c == ']') st.pop();
            else st.push(c);
        }
        return st.isEmpty();
    }
}
