package timedelayer;

public class TimeDelayerFactory {
    public static TimeDelayer makeTimeDelayer(String mode, int time) {
        if(mode.equals("s"))
            return new SecondDelayer(time);
        if(mode.equals("m"))
            return new MinuteDelayer(time);
        throw new IllegalArgumentException("Non-existent time delayer");
    }

    public static TimeDelayer makeNullTimeDelayer() {
        return new NullDelayer();
    }
}
