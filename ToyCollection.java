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
        for (Toy toy : collection) {
            sum += toy.quantity;
        }
        for (Toy toy : collection) {
            toy.setChance(toy.quantity * 100 / sum);
        }
    }

    public void runLottery() {
        double possibility = new Random().nextInt(100);
        System.out.println(possibility);
        double start = 0;
        for (Toy toy : collection) {
            if (possibility > start && possibility < (start + toy.chance)) {
                prizeQueue.add(toy);
                if (toy.quantity > 1)
                    toy.setQuantity(toy.quantity - 1);
                else
                    collection.remove(toy);
                System.out.printf("Вы выиграли игрушку: %s\n", toy);
            }
            start += toy.chance;
        }
        // Iterator<Toy> col = collection.iterator();
        // while (col.hasNext()) {
        //     if (start + col.next().chance < possibility) {
        //         prizeQueue.add(col.next());
        //         if (col.next().quantity > 1)
        //             col.next().setQuantity(col.next().quantity - 1);
        //         else
        //             col.remove();
        //         System.out.printf("Вы выиграли игрушку: %s", col.next());
        //     }
        //     start += col.next().chance;
        // }
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
