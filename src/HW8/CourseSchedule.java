package HW8;

import java.util.Stack;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int count = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]] ++;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < degree.length; i++) {
            if(degree[i] == 0){
                stack.push(i);
            }
        }

        while (!stack.isEmpty()){
            int current = stack.pop();
            count++;
            for (int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == current){
                    degree[prerequisites[i][0]]--;
                    if(degree[prerequisites[i][0]] == 0){
                        stack.push(prerequisites[i][0]);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] preReq = {{1,0},{0,1}};
        System.out.println(canFinish(2, preReq));
    }
}
