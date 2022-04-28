import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for ShortestPathFD
 *
 * @author Trevor Johnson
 */
class FrontendDeveloperTests {

    /**
     * Tests the starting menu and [q]uit command.
     */
    @Test
    public void test1() throws FileNotFoundException {
        TextUITester tester = new TextUITester("q\n");
        CityDistanceBD backend = new CityDistanceBD();
        Edge edges = new Edge();
        ShortestPathFD frontend = new ShortestPathFD(backend, edges);

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
        TextUITester tester = new TextUITester("c\n");
        CityDistanceBD backend = new CityDistanceBD();
        Edge edges = new Edge();
        ShortestPathFD frontend = new ShortestPathFD(backend, edges);

        frontend.runCommandLoop();
        String output = tester.checkOutput();

        assertTrue(output.contains("Enter the number associated with the origin city:"));

    }
}

