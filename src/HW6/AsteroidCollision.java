package HW6;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int a : asteroids) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (!canCollide(stack.peek(), a)) {
                    stack.push(a);
                } else {
                    while (!stack.isEmpty() && canCollide(stack.peek(), a) && stack.peek() < Math.abs(a)) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek() >= Math.abs(a)) {
                        if (stack.peek() == Math.abs(a)) {
                            stack.pop(); // same size [8, -8]
                        }
                        continue;
                    }
                    stack.push(a);
                }
            }
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) res[i--] = stack.pop();
        return res;
    }

    public boolean canCollide(int a, int b) {
        return a > 0 && b < 0;
    }
}
