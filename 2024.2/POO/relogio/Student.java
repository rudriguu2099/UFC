
public class Student {
    private Time time;
    public Student(int hour, int minute, int second){
        time = new Time(hour, minute, second);
    }

    public void setHour(int hour) {
        time.setHour(hour);
    }

    public void setMinute(int minute) {
        time.setMinute(minute);
    }

    public void setSecond(int second) {
        time.setSecond(second);
    }

    public void nextSecond() {
        time.nextSecond();
    }

    public void show() {
        System.out.println(time);
    }
}