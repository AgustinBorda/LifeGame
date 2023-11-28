package timedelayer;

public class NullDelayer extends TimeDelayer {
    public NullDelayer() {
        behavior = new NullDelayerBehavior();
    }
}
