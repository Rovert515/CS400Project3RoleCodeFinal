import java.util.List;

public interface IShortestPathFD {

    /**
     * This method drives the entire read, eval, print loop for the app. This loop will continue to
     * run until the user explicitly enters the quit command.
     */
    void runCommandLoop();

    /**
     * Prints command options.
     */
    public void displayCommandMenu();

    /**
     * Prints all cities that are available in the dataset with the number associated with each.
     *
     * @return list of city names
     */
    public List<String> listCities();

    /**
     * Adds both cities that are then used to find the minimum distance.
     *
     * @param city1 the first city added
     * @param city2 the second city added
     *
     */
    public void addCities(String city1, String city2);

    /**
     * Prints all cities that are between the origin and destination.
     *
     * @return list of city names
     */
    public List<String> citiesBetween();

    /**
     * Prints all highways that are traveled between the origin and destination.
     *
     * @return list of highway names
     */
    public List<String> highwayNames();

}
