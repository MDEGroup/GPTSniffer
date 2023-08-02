


public class 0_Exercise00_11.java{
    public static void main(String[] args) {


        double birthInseconds = 7.0;
        double deathInseconds = 13.0;
        double immigrationInseconds = 45.0;

        double birthsPeryear = changeToyears(birthInseconds);
        double deathsPeryear = changeToyears(deathInseconds);
        double immigratePeryear = changeToyears(immigrationInseconds);

        double currentPopulation = 312_032_486;

        for (int i = 1; i <= 5; i++) {
            currentPopulation += birthsPeryear - deathsPeryear + immigratePeryear;

            System.out.print("The population in year " + i + " will be ");
            System.out.printf("%1.0f", currentPopulation);   
            System.out.println();
        }

    }

    public static double changeToyears(double valueInseconds) {

        double secondsInyear = 60 * 60 * 24 * 365;

        double amountPeryear = secondsInyear / valueInseconds;

        return amountPeryear;
    }

}
