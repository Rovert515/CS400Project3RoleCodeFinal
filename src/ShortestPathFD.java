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
                        System.out.println("can't list the cities, sorry m8");
                    }
                    break;
                case "q":
                case "3":
                    System.out.println("Thanks for using our app!");
                    running = false;
                    break;
                // [C]hoose an origin and destination city
                case "c":
                case "2":
                    try {
                        addCities(city1, city2);
                    } catch (Exception e) {
                        System.out.println("That city isn't here silly");
                    }
                    displayCommandMenu2();
                    // Nested switch statement
                    switch (scnr.next().toLowerCase()) {
                        // [P]rint the shortest distance between cities
                        case "p":
                        case "1":
                            try {
                                shortestPathHelper();
                            } catch (Exception e) {
                                System.out.println("Don't know the distance lol figure it out");
                            }
                            break;
                            // [L]ist cities traveled through for this trip
                        case "l":
                        case "2":
                            try {
                                System.out.println(citiesBetween());
                            } catch (Exception e) {
                                System.out.println("Idk where the cities are");
                            }
                            break;
                            // [S]how the highway names needed to be traveled for this trip
                        case "s":
                        case "3":
                            try {
                                highwayNames();
                            } catch (Exception e) {
                                System.out.println("highway names not found");
                            }
                            //
                        case "r":
                        case "4":
                            try {
                                displayCommandMenu();
                            } catch (Exception e) {
                                System.out.println("idek rn");
                            }
                    }
                    break;
                default:
                    displayCommandMenu2();
                    break;
            }
        } while (running);
    }
/**
    private void addCitiesHelper() {
        List<String> cities = new ArrayList<>();

        System.out.println("\nEnter the numbers corresponding to the available cities list");

        cities.add(city1);
        cities.add(city2);

        addCities(city1, city2);

        backend.setPath(city1, city2);

        return;
    }
**/
    @Override
    public void displayCommandMenu() {
        System.out.println("Command Menu:\n1) [A]vailable cities\n2) [C]hoose an origin and destination city\n" +
                "3) [P]rint the shortest distance between cities\n4) [Q]uit");
    }

    public void displayCommandMenu2() {
        System.out.println("Command Menu 2:\n1) [P]rint the shortest distance between cities\n" +
                "2) [L]ist cities traveled through for this trip\n" +
                "3) [S]how the highway names needed to be traveled for this trip\n" +
                "4) [R]eturn to the command menu");
    }

    // call method to read txt file || print all cities manually
    @Override
    public List<String> listCities() {
        List<String> cities = new ArrayList<>();

        /**
        for (int i = 0; i > 0; i++) {
            cities.add("Chicago");
            cities.add("New York");
        }
         **/
        cityLoader = new MapLoader();

        cities.add("Chicago");
        cities.add("New York");

        return cities;
    }

    // need to work on placeholder class for backend to see how cities are being added
    @Override
    public void addCities(String city1, String city2) {
        List<String> cities = new ArrayList<>();

        //System.out.println("Enter the number associated with the origin city:");

        if (scnr.hasNextInt()) {
            city1 = scnr.next();
            cities.add(city1);
        } else {
            System.out.println("Not a number");
        }

        System.out.println("Enter number for destination city:");

        if (scnr.hasNextInt()) {
            city2 = scnr.next();
            cities.add(city2);
        } else {
            System.out.println("Not a valic number");
        }

        // set path of cities from backend method
        backend.setPath(city1, city2);

        return;
    }

    @Override
    public List<String> citiesBetween() {
        List<String> cities = new ArrayList<>();

        cities.addAll(backend.getPathCities());

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

        System.out.println(backend.getShortestDistance());

        return shortestPath;
    }

}