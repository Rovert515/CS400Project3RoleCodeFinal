import java.util.ArrayList;
import java.util.List;

public class Edge implements IEdge {
    @Override
    public String getEnd1() {
        return null;
    }

    @Override
    public String getEnd2() {
        return null;
    }

    @Override
    public int getDistance() {
        return 0;
    }

    @Override
    public String interstate() {
        String highways = "I-85, I-90";

        return highways;
    }
}
