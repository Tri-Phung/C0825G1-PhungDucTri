package ss4_class_and_object.bai_tap.stop_watch;

import java.time.temporal.ChronoField;

public class StopWatch {
    private long startTime;
    private long endTime;
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }
    public long getStartTime() {
        return startTime;
    }
    public long getEndTime() {
        return endTime;
    }
    public void start() {
        startTime = System.currentTimeMillis();
    }
    public void stop() {
        endTime = System.currentTimeMillis();
    }
    public double getElapsedTime() {
        return endTime - startTime;
    }
}
