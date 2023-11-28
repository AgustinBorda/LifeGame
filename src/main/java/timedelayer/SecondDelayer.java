package timedelayer;

public class SecondDelayer extends TimeDelayer {
    public SecondDelayer(int seconds) {
        behavior = new MinuteDelayerBehavior(seconds);
    }
}
