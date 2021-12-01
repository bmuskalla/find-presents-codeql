package p;

public class GiftWrapper implements ChristmasPresent {

    private ChristmasPresent present;

    public GiftWrapper(ChristmasPresent present) {
        this.present = present;
    }

    public ChristmasPresent unwrap() {
        return present;
    }

    @Override
    public String toString() {
        return "📦";
    }
}
