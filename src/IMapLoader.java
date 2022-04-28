
import java.util.List;
import java.util.Set;

public interface IMapLoader{

    /**
     * Parses the .txt file containing edges and stores them in a set
     */
    public List<IEdge> edgeLoader();



    /**
     * Parses the .txt file containing city names and stores them in a set
     */
    public List<String> cityLoader();

}