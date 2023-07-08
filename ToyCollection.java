import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class ToyCollection {

    protected PriorityQueue<Toy> collection = new PriorityQueue<>();
    protected Queue<Prize> prizeQueue = new LinkedList<>();

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
        // System.out.println(possibility);
        double start = 0;
        for (Toy toy : collection) {
            if (possibility > start && possibility < (start + toy.chance)) {
                addPrize(toy);
                if (toy.quantity > 1)
                    toy.setQuantity(toy.quantity - 1);
                else
                    collection.remove(toy);
                System.out.printf("Вы выиграли игрушку: %s\n", toy.name);
            }
            start += toy.chance;
            setAllChances();
        }
    }

    public void addPrize(Toy prizeToy) {
        boolean available = false;
        for (Prize prize : prizeQueue) {
            if (prize.getId() == prizeToy.getId()) {
                prize.setQuantity(prize.quantity + 1);
                available = true;
            }
        }
        if (available == false) {
            prizeQueue.add(new Prize(prizeToy.getId(), prizeToy.name));
        }
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
            for (Prize prize : prizeQueue) {
                System.out.println(prize);
            }
        }
    }
}
