package Main1.entities.Enum;

import java.util.Random;

public enum Periodicità {

    Settimanale, Mensile;

    private static final Random RANDOM = new Random();


    public static Periodicità getRandomPeriodicità() {
        return values()[RANDOM.nextInt(values().length)];
    }


}
