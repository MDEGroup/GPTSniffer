public class Population {
    public static void main(String[] args) {
        final int SECONDS_PER_YEAR = 365 * 24 * 60 * 60; // seconds per year
        final int BIRTHS_PER_YEAR = SECONDS_PER_YEAR / 7; // number of births per year
        final int DEATHS_PER_YEAR = SECONDS_PER_YEAR / 13; // number of deaths per year
        final int IMMIGRANTS_PER_YEAR = SECONDS_PER_YEAR / 45; // number of immigrants per year
        int currentPopulation = 312032486; // current population
        int year = 1; // starting year

        // Calculate the population for each of the next five years
        for (int i = 0; i < 5; i++) {
            currentPopulation += BIRTHS_PER_YEAR + IMMIGRANTS_PER_YEAR - DEATHS_PER_YEAR;
            System.out.println("Year " + year + ": " + currentPopulation);
            year++;
        }
    }
}