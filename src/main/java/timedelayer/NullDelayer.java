package timedelayer;

import java.util.concurrent.TimeUnit;

public class NullDelayer extends TimeDelayer {
    public NullDelayer() {
        super(TimeUnit.DAYS, 0);
    }
}
