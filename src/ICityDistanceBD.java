
import java.util.Collection;
import java.util.List;

public interface ICityDistanceBD {
    /**
     * Adds a Collection of cities as vertices of the graph
     *
     * @param cities cities to be added as vertices
     */
    public void addVertices(Collection<String> cities);

    /**
     * Adds a Collection of IEdges as edges of the graph
     *
     * @param interstateRoutes routes to be added as edges
     */
    public void addEdges(Collection<IEdge> interstateRoutes);


    /**
     * Returns a List of cities stored in the graph
     *
     */
    public void getCities();

    /**
     * Set the origin and destination cities
     */
    public void setPath(String origin, String destination);

    /**
     * Return the shortest distance between the origin and destination cities in miles.
     *
     * @return the shortest distance between the origin and destination cities in miles
     */
    public int getShortestDistance();

    /**
     * Return a List of cities traversed by the shortest path between origin and destination cities
     *
     * @return a List of cities traversed by the shortest path between origin and destination cities
     */
    public List<String> getPathCities();

}