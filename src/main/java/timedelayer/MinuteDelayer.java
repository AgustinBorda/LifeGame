package timedelayer;

import java.util.concurrent.TimeUnit;

public class MinuteDelayer implements TimeDelayer {
    private int minutes;
    public MinuteDelayer(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public void delay() {
        try {
            TimeUnit.MINUTES.sleep(minutes);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MinuteDelayer that = (MinuteDelayer) o;

        return minutes == that.minutes;
    }

    @Override
    public int hashCode() {
        return minutes;
    }
}
