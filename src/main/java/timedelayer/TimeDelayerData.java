package timedelayer;

import java.util.concurrent.TimeUnit;

public class TimeDelayerData {
    TimeUnit u;

    int time;

    public TimeDelayerData(TimeUnit unit, int t) {
        u = unit;
        time = t;
    }
}
