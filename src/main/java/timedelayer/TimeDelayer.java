package timedelayer;

public class TimeDelayer {
    protected DelayerBehavior behavior;

    public void delay() {
        try {
            behavior.delay();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TimeDelayer)
            return behavior.equals(((TimeDelayer) obj).behavior);
        return false;
    }
}
