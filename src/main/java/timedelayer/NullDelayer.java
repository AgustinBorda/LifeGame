package timedelayer;

public class NullDelayer implements TimeDelayer {
    public NullDelayer() {

    }

    @Override
    public void delay() {

    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NullDelayer;
    }
}
