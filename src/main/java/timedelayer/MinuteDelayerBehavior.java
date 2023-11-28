package timedelayer;

import java.util.concurrent.TimeUnit;

public class MinuteDelayerBehavior implements DelayerBehavior {
    private int minutes;

    public MinuteDelayerBehavior(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public void delay() throws InterruptedException {
        TimeUnit.MINUTES.sleep(minutes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MinuteDelayerBehavior that = (MinuteDelayerBehavior) o;

        return minutes == that.minutes;
    }
}
