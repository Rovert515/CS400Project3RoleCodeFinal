import java.util.*;

public class ShortestPathFD implements IShortestPathFD {

    private final CityDistanceBD backend;
    private Edge edge;
    private MapLoader cityLoader;
    private final Scanner scnr;
    private String city1;
    private String city2;
    private int shortestPath;

    public ShortestPathFD(CityDistanceBD backend, Edge edge) {
        scnr = new Scanner(System.in);
        this.backend = backend;
        this.edge = edge;
        this.cityLoader = cityLoader;
        this.shortestPath = 850;
        this.city1 = "Chicago";
        this.city2 = "New York";
    }

    @Override
    public void runCommandLoop() {
        System.out.println("Welcome to the Shortest Path App!\n=================================");
        boolean running = true;
        do {
            displayCommandMenu();
            switch (scnr.next().toLowerCase()) {
                // [A]vailable cities
                case "a":
                case "1":
                    try {
                        System.out.println(listCities());
                    } catch (Exception e) {
                        System.out.println("Can't find the list of cities");
                    }
                    break;
                // [C]hoose an origin and destination city
                case "c":
                case "2":
                    try {
                        addCitiesHelper();
                        addCities(city1, city2);
                    } catch (Exception e) {
                        System.out.println("Can't find the cities");
                    }
                    break;
                // [P]rint the shortest distance between cities
                case "p":
                case "3":
                    try {
                        shortestPathHelper();
                    } catch (Exception e) {
                        System.out.println("Can't find the distance");
                    }
                    break;
                // [L]ist cities traveled through for this trip
                case "l":
                case "4":
                    try {
                        citiesBetween();
                    } catch (Exception e) {
                        System.out.println("Can't find the cities between");
                    }
                    break;
                // [S]how the highway names needed to be traveled for this trip
                case "s":
                case "5":
                    try {
                        highwayNames();
                    } catch (Exception e) {
                        System.out.println("Can't find the highways");
                    }
                    break;
                case "q":
                case "6":
                    System.out.println("Thanks for using our app!");
                    running = false;
                    break;
                default: displayCommandMenu();
            }
        } while (running);
    }


    @Override
    public void displayCommandMenu() {
        System.out.println("Command Menu:\n1) [A]vailable cities\n2) [C]hoose an origin and destination city\n" +
                "3) [P]rint the shortest distance between cities\n" +
                "4) [L]ist cities traveled through for this trip\n" +
                "5) [S]how the highway names needed to be traveled for this trip\n6) [Q]uit");
    }

    @Override
    public List<String> listCities() {
        List<String> cities = new ArrayList<>();

        cities.add("Chicago");
        cities.add("New York");

        return cities;
    }

    @Override
    public void addCities(String city1, String city2) {
        backend.setPath(city1, city2);  // set path of cities from backend method

        System.out.println("Cities chosen: " + city1 + " " + city2);

        return;
    }

    private List<String> addCitiesHelper() {
        List<String> citiesAdded = new ArrayList<>();

        System.out.println("Enter the number associated with the origin city:");

        city1 = scnr.next();
        citiesAdded.add(city1);

        System.out.println("Enter number for destination city:");

        city2 = scnr.next();
        citiesAdded.add(city2);

        return citiesAdded;
    }

    @Override
    public List<String> citiesBetween() {
        List<String> cities = new ArrayList<>();

        cities = backend.getPathCities();

        System.out.println(cities);

        return cities;
    }

    @Override
    public List<String> highwayNames() {
        List<String> highways = new ArrayList<>();

        edge.interstate();
        System.out.println(edge.interstate());

        highways.add(edge.interstate());

        return highways;
    }

    public int shortestPathHelper() {
        shortestPath = backend.getShortestDistance();

        System.out.println(shortestPath);

        return shortestPath;
    }
}