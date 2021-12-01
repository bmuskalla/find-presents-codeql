package p;

public class SantasWrapperFactory {

    public GiftWrapper wrap(ChristmasPresent present) {
        return new GiftWrapper(present);
    }

}
