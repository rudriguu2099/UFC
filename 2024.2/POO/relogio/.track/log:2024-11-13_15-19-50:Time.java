class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public Time(int hour, int minute, int second) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            System.err.println("fail: hora invalida");
        } else {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            System.err.println("fail: minuto invalido");
        } else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            System.err.println("fail: segundo invalido");
        } else {
            this.second = second;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    // avança o tempo em um segundo
    public void nextSecond() {
        setSecond(getSecond() + 1);
        if (getSecond() == 60) {
            setSecond(0);

            setMinute(getMinute() + 1);
            if (getMinute() == 60) {
                setMinute(0);

                setHour(getHour() + 1);
                if (getHour() == 24) {
                    setHour(0);
                }
            }
        }
    }

    public String toString() {
        return String.format("%02d", hour) + ":" + 
               String.format("%02d", minute) + ":" + 
               String.format("%02d", second);
    }
}
