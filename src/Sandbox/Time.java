package Sandbox;

class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        String s = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
        String m = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        String h = hours < 10 ? "0" + hours : String.valueOf(hours);
        return "\"" + h + ":" + m + ":" + s + "\"";
    }

    public static void main(String[] args) {
        Time t = new Time(23, 59, 59);
        System.out.println(t.toString());
    }
}
