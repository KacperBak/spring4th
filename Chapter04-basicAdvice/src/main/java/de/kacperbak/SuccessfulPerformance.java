package de.kacperbak;

/**
 * Created by bakka on 11.01.16.
 */
public class SuccessfulPerformance implements Performance {

    public static final String CONTROLLED_PERFORMANCE = "Performing awesome controlled performance!";
    public static final String RANDOM_PERFORMANCE = "Performing awesome random performance!";

    @Override
    public void randomPerformance() {
        System.out.println(RANDOM_PERFORMANCE);
    }

    @Override
    public void controlledPerformance() {
        System.out.println(CONTROLLED_PERFORMANCE);
    }
}
