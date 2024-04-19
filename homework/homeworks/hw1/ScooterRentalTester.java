package homeworks.hw1;

import homeworks.hw1.scooter.Scooter;
import homeworks.hw1.scooter.RentalCompany;

/**
 * The homeworks.hw1.ScooterRentalTester class is used to simulate the process of renting and returning scooters.
 */
public class ScooterRentalTester {

    // Constants representing the coordinates for home and university.
    private static final double HOME_X = 41.787891;
    private static final double HOME_Y = 44.754815;
    private static final double UNIVERSITY_X = 41.712106;
    private static final double UNIVERSITY_Y = 44.7489232;

    // Instance of homeworks.hw1.scooter.RentalCompany to manage the scooters.
    private RentalCompany rentalCompany;

    /**
     * Main method to start the scooter rental simulation.
     *
     * @param args Command line arguments (not used in this simulation).
     */
    public static void main(String[] args) {
        ScooterRentalTester tester = new ScooterRentalTester();
        tester.simulateScooterRentalProcess();
    }

    /**
     * Constructor for homeworks.hw1.ScooterRentalTester which initializes the rental company instance.
     */
    public ScooterRentalTester() {
        rentalCompany = new RentalCompany();
    }

    /**
     * This method simulates the entire process of renting a scooter, using it, and returning it.
     */
    public void simulateScooterRentalProcess() {
        // Adding a scooter to the company for rental.
        Scooter scooter = new Scooter();
        rentalCompany.addScooter(scooter);

        // Rent the scooter and travel from home to the university.
        rentalCompany.rentScooter(scooter.getId());
        System.out.println("homeworks.hw1.scooter.Scooter rented and traveling to university.");
        rentalCompany.returnScooter(scooter.getId(), UNIVERSITY_X, UNIVERSITY_Y);
        System.out.println("homeworks.hw1.scooter.Scooter returned at university location.");

        // Simulate waiting for 1 hour before renting the scooter again.
        System.out.println("Waiting for one hour before renting the scooter again...");
        try {
            Thread.sleep(3600000); // Sleep for 1 hour (3600 seconds * 1000 milliseconds/second)
        } catch (InterruptedException e) {
            System.out.println("Simulation interrupted while waiting.");
        }

        // Rent the scooter again and return it near home.
        rentalCompany.rentScooter(scooter.getId());
        System.out.println("homeworks.hw1.scooter.Scooter rented again and traveling near home.");
        rentalCompany.returnScooter(scooter.getId(), HOME_X, HOME_Y);
        System.out.println("homeworks.hw1.scooter.Scooter returned near home location.");
    }
}
