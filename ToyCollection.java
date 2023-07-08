import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ToyCollection {

    protected LinkedList<Toy> collection = new LinkedList<>();
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
        double start = 0;
        collection.sort(null);
        for (Toy toy : collection) {
            if (possibility >= start && possibility < (start + toy.chance)) {
                prizeQueue.add(new Prize(toy.name));
                if (toy.quantity > 1)
                    toy.setQuantity(toy.quantity - 1);
                else
                    collection.remove(toy);
                System.out.printf("Вы выиграли игрушку: %s\n", toy.name);
            }
            start += toy.chance;
        }
        setAllChances();
        collection.sort(null);
        ;
    }

    // public void addPrize(Toy prizeToy) {
    // boolean available = false;
    // for (Prize prize : prizeQueue) {
    // if (prize.getId() == prizeToy.getId()) {
    // prize.setQuantity(prize.quantity + 1);
    // available = true;
    // }
    // }
    // if (available == false) {
    // prizeQueue.add(new Prize(prizeToy.getId(), prizeToy.name));
    // }
    // }

    public void getToys() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss");
        String fileName = "givenPrizes.json";
        Prize prize = prizeQueue.element();
        try (FileWriter writer = new FileWriter(fileName, Charset.forName("utf-8"), true)) {
            writer.write(dateFormat.format(date) + " выдан приз: номер лота:" + prize.getId() + " " + prize.name + "\n");
            // writer.write("\"clientName\":\"" + prize.getId() + "\",\n");
            // writer.write("\"clientName\":\"" + prize.name + "\",\n");
            // writer.write("}\n");
            writer.flush();
            System.out.println(dateFormat.format(date) + " выдан приз: номер лота:" + prize.getId() + " " + prize.name + "\n");
            prizeQueue.remove();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printActiveToyCol() {
        if (collection.isEmpty()) {
            System.out.println("Нет игрушек в автомате.");
        } else {
            for (Toy toy : collection) {
                System.out.println(toy);
            }
        }
    }

    public void printReadyToGiveToyCol() {
        if (prizeQueue.isEmpty()) {
            System.out.println("Нет игрушек, готовых к выдаче.");
        } else {
            for (Prize prize : prizeQueue) {
                System.out.println(prize);
            }
        }
    }
}
