package Stepik;

public class Task implements Comparable<Task> {
    int number;
    int processorNum;
    long startTime;
    long endTime;

    Task(int number, int processorNum, long startTime, long endTime) {
        this.number = number;
        this.processorNum = processorNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    Task() {
    }

    public int compareTo(Task task) {
        return 0;
    }
}

