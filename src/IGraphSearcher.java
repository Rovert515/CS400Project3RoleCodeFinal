import java.util.List;

public interface IGraphSearcher extends GraphADT{

    /**
     * accesses the graphADT path traversal method
     * @return a list of strings containing the interstate names passed through by the shortest path
     */
    public List<String> getInterstateNames();

}