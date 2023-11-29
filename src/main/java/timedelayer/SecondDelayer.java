package timedelayer;

import java.util.concurrent.TimeUnit;

public class SecondDelayer implements TimeDelayer {

    private int seconds;

    public SecondDelayer(int s) {
        seconds = s;
    }
    @Override
    public void delay() {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecondDelayer that = (SecondDelayer) o;

        return seconds == that.seconds;
    }

    @Override
    public int hashCode() {
        return seconds;
    }
}
