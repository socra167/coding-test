import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            jobList.add(new Job(i, jobs[i][1], jobs[i][0]));
        }
        
        jobList = jobList.stream()
            .sorted(Comparator.comparingInt((Job j) -> j.request).reversed())
            .collect(Collectors.toList());
        
        // Stack에 Job 삽입
        Stack<Job> remaining = new Stack<>();
        for (Job job : jobList) {
            remaining.add(job);
        }
        
        // 소요 시간, 요청 시각, 작업 번호 순으로 처리하는 PriorityQueue
        PriorityQueue<Job> queue = new PriorityQueue<>(
            Comparator.comparingInt((Job j) -> j.time)
                .thenComparingInt((Job j) -> j.request)
                .thenComparingInt((Job j) -> j.num)
        );
        
        // PriorityQueue에서 Job 처리
        int sum = 0;
        int currentTime = 0;
        
        while (!queue.isEmpty() || !remaining.isEmpty()) {
            if (queue.isEmpty()) {
                Job job = remaining.pop();
                queue.offer(job);
                currentTime = currentTime < job.request ?
                    job.request : currentTime;
            }
            while (!remaining.isEmpty() && remaining.peek().request <= currentTime) {
                Job job = remaining.pop();
                queue.offer(job);
            }
            
            Job job = queue.poll();
            currentTime = currentTime < job.request ?
                job.request : currentTime;
            
            currentTime += job.time;
            sum += (currentTime - job.request);
        }
        
        return sum / jobs.length;
    }
}

class Job {
    public int num;
    public int time;
    public int request;
    
    public Job(int num, int time, int request) {
        this.num = num;
        this.time = time;
        this.request = request;
    }
}