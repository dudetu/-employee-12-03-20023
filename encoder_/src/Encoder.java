import java.util.Stack;

public class Encoder {

        public void encode(String line) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (stack.size() < 5) {
                    stack.push(symbol);
                }
                if (stack.size() == 5 || i == line.length() - 1) {
                    while (!stack.isEmpty()) {
                        System.out.println(stack.pop());
                    }
                }

            }
        }


}
