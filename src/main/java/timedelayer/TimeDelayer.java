package timedelayer;

import java.util.concurrent.TimeUnit;

public class TimeDelayer {
    private int time;

    private TimeUnit unit;
    public TimeDelayer(TimeUnit u, int time) {
        this.time = time;
        unit = u;
    }

    public TimeDelayer(TimeDelayerData data) {
        this.time = data.time;
        unit = data.u;
    }

    public void delay() {
        try {
            unit.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeDelayer that = (TimeDelayer) o;

        return time == that.time && unit == that.unit;
    }

    public int hashCode() {
        return time;
    }
}
