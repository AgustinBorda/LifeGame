package timedelayer;

public class MinuteDelayer extends TimeDelayer {
    public MinuteDelayer(int minutes) {
        behavior = new MinuteDelayerBehavior(minutes);
    }

}
