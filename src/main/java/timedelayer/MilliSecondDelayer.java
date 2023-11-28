package timedelayer;

public class MilliSecondDelayer extends TimeDelayer {
    public MilliSecondDelayer(int milliseconds) {
        behavior = new MilliSecondDelayerBehavior(milliseconds);
    }
}
