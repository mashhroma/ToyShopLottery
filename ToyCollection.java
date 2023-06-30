import java.util.ArrayList;
import java.util.PriorityQueue;

public class ToyCollection {
    
    protected ArrayList<PrizeToy> collection = new ArrayList<>();
    protected PriorityQueue<PrizeToy> prizуQueue = new PriorityQueue<>();

    public void putToy(PrizeToy toy) {
        this.collection.add(toy);
    }
}
