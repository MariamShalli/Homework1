import java.util.ArrayList;
import java.util.List;

public class RentalCompany {

    private int uid = 0;

    List<Scooter> scooters = new ArrayList<>();

    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter: scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooters.add(scooter);
    }

    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Rents out a scooter based on its identifier. This sets its availability to false.
     *
     * @param id The unique identifier of the scooter to rent.
     * @return true if the scooter was successfully rented out, false if the scooter was not available or not found.
     */
    public void rentScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id && scooter.isAvailable()) {
                scooter.setAvailable(false);
                break;
            }
        }
        
    }

    /**
     * Returns a rented scooter and updates its location.
     *
     * @param id The unique identifier of the scooter to be returned.
     * @param x  The x-coordinate of the scooter's new location.
     * @param y  The y-coordinate of the scooter's new location.
     * @return true if the scooter was successfully returned, false if the scooter was not found.
     */
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooter.setAvailable(true);
                scooter.setX(x);
                scooter.setY(y);
                break;
            }
        }
        
    }
    
    /**
     * Prints out all the scooters in the fleet with their details.
     */
    public void displayAllScooters() {
        for (Scooter scooter : scooters) {
            System.out.println(scooter);
        }
    }
}
