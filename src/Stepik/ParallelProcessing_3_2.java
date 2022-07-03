package Stepik;

import java.util.*;

public class ParallelProcessing_3_2 {
    public static void main(String[] args) {

        Comparator<Task> compareByEndTime = new Comparator<Task>() {
            public int compare(Task task1, Task task2) {
                if (task1.endTime < task2.endTime) {
                    return -1;
                }
                if (task1.endTime > task2.endTime) {
                    return 1;
                }
                if (task1.processorNum < task2.processorNum) {
                    return -1;
                }
                if (task1.processorNum > task2.processorNum) {
                    return 1;
                }
                return 0;
            }
        };
        Comparator<Task> compareByNumber = new Comparator<Task>() {
            public int compare(Task task1, Task task2) {
                if (task1.number < task2.number) {
                    return -1;
                }
                if (task1.number > task2.number) {
                    return 1;
                }
                return 0;
            }
        };

        PriorityQueue<Task> taskQueue = new PriorityQueue<>(compareByEndTime);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[] taskProcessingTimings = new int[m];
        for (int i = 0; i < taskProcessingTimings.length; i++) {
            taskProcessingTimings[i] = scanner.nextInt();
        }

        ArrayList<Task> results = new ArrayList<>();
        Queue<Integer> freeProcessors = new ArrayDeque();
        for (int k = 0; k < n; k++) {
            freeProcessors.add(k);
        }
        long currentTime = 0;
        int i = 0;

        outerloop:
        while (results.size() < m) {
            while (i < m && !freeProcessors.isEmpty()) {
                if (taskProcessingTimings[i] == 0) {
                    results.add(new Task(i, freeProcessors.peek(), currentTime, currentTime));
                    i++;
                    continue outerloop;
                } else {
                    taskQueue.add(new Task(i, freeProcessors.poll(), currentTime, currentTime + taskProcessingTimings[i]));
                    i++;
                }

            }
            if (!taskQueue.isEmpty()) {
                Task currentTask = taskQueue.poll();
                freeProcessors.add(currentTask.processorNum);
                currentTime = currentTask.endTime;
                results.add(currentTask);
            }
        }
        Collections.sort(results,compareByNumber);
        for (Task task : results) {
            System.out.println(task.processorNum + " " + task.startTime);
        }
    }
}
