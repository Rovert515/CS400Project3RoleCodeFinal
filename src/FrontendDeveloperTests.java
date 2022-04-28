import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * JUnit tests for ShortestPathFD
 *
 * @author Trevor Johnson
 */
class FrontendDeveloperTests {
    private String city1;
    private String city2;
    private final int shortestPath;

    public FrontendDeveloperTests() {
        this.shortestPath = 850;
        this.city1 = "Chicago";
        this.city2 = "New York";
    }


    /**
     * Tests the starting menu and [q]uit command.
     */
    @Test
    public void test1() {
        TextUITester tester = new TextUITester("q\n");
        IMapLoader loader = new MapLoader(); // new shortestPathLoader();
        List<String> cities = loader.cityLoader();
        CityDistanceBD backend = new CityDistanceBD(); //new CityDistanceBD();
        Edge edges = new Edge();
        backend.addVertices(cities);
        IShortestPathFD frontend = new ShortestPathFD(backend, edges); //new ShortestPathFD

        frontend.runCommandLoop();
        String output = tester.checkOutput();

        assertTrue(output.startsWith(
                "Welcome to the Shortest Path App!\n================================="));
        assertTrue(output.contains("Thanks for using our app!"));
        assertTrue(output.contains("1) [A]vailable cities\n2) [C]hoose an origin and destination city\n"));
    }

    /**
     * Tests the command 2, choosing origin and destination
     */
    @Test
    public void test2() {
        TextUITester tester = new TextUITester("c\n1\n2\n");
        IMapLoader loader = new MapLoader(); // new shortestPathLoader();
        List<String> cities = loader.cityLoader();
        CityDistanceBD backend = new CityDistanceBD(); //new CityDistanceBD();
        Edge edges = new Edge();
        backend.addVertices(cities);
        IShortestPathFD frontend = new ShortestPathFD(backend, edges); //new ShortestPathFD

        frontend.runCommandLoop();
        String output = tester.checkOutput();
        System.out.println(tester.toString());

        assertTrue(output.contains("Enter the number associated with the origin city:"));

    }
    /**
     * Tests the command 2, choosing origin and destination
     */
    @Test
    public void test3() {
        TextUITester tester = new TextUITester("p\n");
        IMapLoader loader = new MapLoader(); // new shortestPathLoader();
        List<String> cities = loader.cityLoader();
        CityDistanceBD backend = new CityDistanceBD(); //new CityDistanceBD();
        Edge edges = new Edge();
        backend.addVertices(cities);
        IShortestPathFD frontend = new ShortestPathFD(backend, edges); //new ShortestPathFD
        this.city1 = "Chicago";
        this.city2 = "New York";

        frontend.runCommandLoop();
        String output = tester.checkOutput();

        assertTrue(output.contains("850"));

    }
}

