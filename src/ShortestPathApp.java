import java.util.List;

public class ShortestPathApp {

    public static void main(String[] args) throws Exception {
        IMapLoader loader = new MapLoader(); // new shortestPathLoader();
        List<String> cities = loader.cityLoader();
        CityDistanceBD backend = new CityDistanceBD(); //new CityDistanceBD();
        Edge edges = new Edge();
        backend.addVertices(cities);
        IShortestPathFD frontend = new ShortestPathFD(backend, edges); //new ShortestPathFD
        frontend.runCommandLoop();
    }
}