import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class ToyCollection {

    protected PriorityQueue<Toy> collection = new PriorityQueue<>();
    protected Queue<Toy> prizeQueue = new LinkedList<>();

    public void putToy(Toy toy) {
        this.collection.add(toy);
        setAllChances();
    }

    public void setAllChances() {
        int sum = 0;
        for (Toy prizeToy : collection) {
            sum += prizeToy.quantity;
        }
        for (Toy prizeToy : collection) {
            prizeToy.setChance(prizeToy.quantity * 100 / sum);
        }
    }

    public void runLottery() {
        int possibility = new Random().nextInt(100);
        Iterator<Toy> col = collection.iterator();
        int start = 0;
        while (col.hasNext()) {
            if (start + col.next().chance < possibility) {
                prizeQueue.add(col.next());
                if (col.next().quantity > 1)
                    col.next().setQuantity(col.next().quantity - 1);
                else
                    col.remove();
                System.out.printf("Вы выиграли игрушку: %s", col.next());
            }
            start += col.next().chance;
        }
        setAllChances();
    }

    public void getToys() {
        System.out.println(prizeQueue);
    }

    public void printActiveToyCol() {
        for (Toy toy : collection) {
            System.out.println(toy);
        }
    }

    public void printReadyToGiveToyCol() {
        if (prizeQueue.isEmpty()) {
            System.out.println("Нет игрушек, готовых к выдаче");
        } else {
            for (Toy toy : prizeQueue) {
                System.out.println(toy);
            }
        }
    }
}
