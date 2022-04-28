import java.util.ArrayList;
import java.util.List;

public class MapLoader implements IMapLoader {

    @Override
    public List<IEdge> edgeLoader() {
        return null;
    }

    @Override
    public List<String> cityLoader() {
        List<String> cities = new ArrayList<>();

        cities.add("Chicago");
        cities.add("New York");

        return cities;
    }
}
