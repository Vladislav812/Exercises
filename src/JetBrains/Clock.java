package JetBrains;

class Clock {
    int hours;
    int minutes;


    void next() {
        this.hours = this.minutes == 59 ? (this.hours == 12 ? 1 : ++this.hours) : this.hours;
        this.minutes = this.minutes == 59 ? 0 : ++this.minutes;
    }
}
