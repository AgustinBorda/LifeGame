package timedelayer;

import java.util.concurrent.TimeUnit;

public class MilliSecondDelayerBehavior implements DelayerBehavior {

    private int milliseconds;

    public MilliSecondDelayerBehavior(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    @Override
    public void delay() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(milliseconds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MilliSecondDelayerBehavior that = (MilliSecondDelayerBehavior) o;

        return milliseconds == that.milliseconds;
    }
}
