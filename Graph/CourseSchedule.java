//https://leetcode.com/problems/course-schedule
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] inDegree = new int[numCourses];
        for(int []prerequisite : prerequisites)
            inDegree[prerequisite[0]]++;
        
        Stack<Integer>stack = new Stack<Integer>();
        
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0)
              stack.push(i);
        
        int count=0;
        while(!stack.isEmpty()){
            int currCourse = stack.pop();
            System.out.println(currCourse);
            count++;
            for(int []prerequisite : prerequisites){
                if(prerequisite[1] == currCourse){
                    inDegree[prerequisite[0]]--;
                    if(inDegree[prerequisite[0]] == 0)
                        stack.push(prerequisite[0]);
                }
            }
        }
        return count == numCourses;
    }
}