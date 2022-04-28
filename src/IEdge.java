public interface IEdge{

    //Constructor will take Strings for the ends,
    //an int for the weight of the edge,
    //and a String for name of the interstate


    /**
     * Returns a String of the first end of the edge
     * This is the starting point for the edge
     */
    public String getEnd1();


    /**
     * Returns of String of the second end of the edge
     * This is the ending point of the edge
     */
    public String getEnd2();


    /**
     * Returns the weight/distance between the two edges
     */
    public int getDistance();


    /**
     * Returns the name of the interstate that this edge
     * represents a part of
     */
    public String interstate();


}