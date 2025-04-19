import java.util.*;
// 현재 꺼낼 수 있는 작업인지(현재 시간 기준 request 이전인지) 검사

class Solution {
    public int solution(int[][] jobs) {
        // 소요 시간, 요청 시각, 작업 번호 순으로 처리하는 PriorityQueue
        PriorityQueue<Job> queue = new PriorityQueue<>(
            Comparator.comparingInt((Job j) -> j.getTime())
                .thenComparingInt((Job j) -> j.getRequest())
                .thenComparingInt((Job j) -> j.getNum())
        );
        
        // PriorityQueue에 Job 삽입
        for (int i = 0; i < jobs.length; i++) {
            queue.add(new Job(i, jobs[i][1], jobs[i][0]));
        }
        
        // PriorityQueue에서 Job 처리
        int sum = 0;
        int currentTime = 0;
        while (!queue.isEmpty()) {
            Job job = queue.poll();
            currentTime = currentTime < job.getRequest() ?
                job.getRequest() : currentTime;
            currentTime += job.getTime();
            sum += (currentTime - job.getRequest());
        }
        
        return sum / jobs.length;
    }
}

class Job {
    private int num;
    private int time;
    private int request;
    
    public Job(int num, int time, int request) {
        this.num = num;
        this.time = time;
        this.request = request;
    }
    
    public int getNum() {
        return num;
    }
    
    public int getTime() {
        return time;
    }
    
    public int getRequest() {
        return request;
    }
}