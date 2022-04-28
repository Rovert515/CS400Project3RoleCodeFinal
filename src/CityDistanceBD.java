import java.util.*;

public class CityDistanceBD implements ICityDistanceBD {

    @Override
    public void addVertices(Collection<String> cities) {

    }

    @Override
    public void addEdges(Collection<IEdge> interstateRoutes) {
        String highways = "I-85, I-90";
    }

    @Override
    public void getCities() {

    }

    @Override
    public void setPath(String origin, String destination) {

    }

    @Override
    public int getShortestDistance() {
        int shortestDistance = 850;

        return shortestDistance;
    }

    @Override
    public List<String> getPathCities() {
        List<String> listCityPath = new ArrayList<>();

        listCityPath.add("Chicago");
        listCityPath.add("Toledo");
        listCityPath.add("Philadelphia");
        listCityPath.add("New York");

        return listCityPath;
    }
}