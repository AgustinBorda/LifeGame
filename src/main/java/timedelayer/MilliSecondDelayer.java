package timedelayer;

import java.util.concurrent.TimeUnit;

public class MilliSecondDelayer implements TimeDelayer {
    private int miliseconds;
    public MilliSecondDelayer(int milliseconds) {
        this.miliseconds = milliseconds;
    }

    @Override
    public void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MilliSecondDelayer that = (MilliSecondDelayer) o;

        return miliseconds == that.miliseconds;
    }

    @Override
    public int hashCode() {
        return miliseconds;
    }
}
