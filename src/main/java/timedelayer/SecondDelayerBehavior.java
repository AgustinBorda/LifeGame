package timedelayer;

import java.util.concurrent.TimeUnit;

public class SecondDelayerBehavior implements DelayerBehavior {
    private int seconds;

    public SecondDelayerBehavior(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public void delay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecondDelayerBehavior that = (SecondDelayerBehavior) o;

        return seconds == that.seconds;
    }
}
