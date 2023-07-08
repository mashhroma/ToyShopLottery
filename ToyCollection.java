import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
        if (collection.isEmpty()) {
            System.out.println("Невозможно провести розыгрыш. В автомате нет игрушек.");
        } else {
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
                    System.out.printf("Участник выиграл игрушку: %s\n", toy.name);
                }
                start += toy.chance;
            }
            setAllChances();
            collection.sort(null);
        }
    }

    public void getToys() {
        if (prizeQueue.isEmpty()) {
            System.out.println("Нет игрушек, готовых к выдаче участникам. Нужно вначале провести розыгрыш призов.");
        } else {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss");
            String fileName = "prizesReport.txt";
            Prize prize = prizeQueue.element();
            try (FileWriter writer = new FileWriter(fileName, Charset.forName("utf-8"), true)) {
                writer.write(dateFormat.format(date) + " ВЫДАН ПРИЗ: номер лота " + prize.getId() + ", игрушка - "
                        + prize.name + "\n");
                writer.flush();
                System.out.println(dateFormat.format(date) + " ВЫДАН ПРИЗ: номер лота " + prize.getId() + ", игрушка - "
                        + prize.name + ". Запись о выдаче внесена в файл.\n");
                prizeQueue.remove();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
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
            Map<String, Integer> prizes = new HashMap<>();
            ;
            for (Prize prize : prizeQueue) {
                int count = 1;
                if (prizes.containsKey(prize.name))
                    count = prizes.get(prize.name) + 1;
                prizes.put(prize.name, count);
            }
            for (var prize : prizes.entrySet()) {
                System.out.printf("- %s, количество %d\n", prize.getKey(), prize.getValue());
            }
        }
    }
}
