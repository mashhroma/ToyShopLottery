import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        ToyCollection toys = new ToyCollection();
        toys.putToy(new Toy("конструктор", 2));
        toys.putToy(new Toy("робот", 2));
        toys.putToy(new Toy("кукла", 6));

        System.out.println("Добро пожаловать на розыгрыш призов в магазине игрушек!");

        String menu = "Выберите действие:\n" +
                "[1] - Разыграть игрушку,\n" +
                "[2] - Посмотреть наличие игрушек в автомате,\n" +
                "[3] - Посмотреть игрушки, готовые к выдаче (выигранные),\n" +
                "[4] - Выдать одну игрушку,\n" +
                "[5] - Посмотреть меню,\n" +
                "[0] - Закончить работу в программе.\n";

        System.out.println(menu);
        Scanner input = new Scanner(System.in);
        String action = "";

        while (!action.equals("0")) {
            System.out.print("\nВведите команду (5 - для вызова меню): ");
            action = input.nextLine();
            switch (action) {
                case "1": // Разыграть игрушку
                System.out.print("Сколько раз разыграть призы? Напишите цифру: ");
                    int steps = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < steps; i++) {
                        System.out.println("\nЗапуск розыгрыша №" + (i + 1));
                        toys.runLottery();
                    }
                    break;
                case "2": // Посмотреть наличие игрушек в автомате
                    System.out.println("\nВсего подарков в автомате:");
                    toys.printActiveToyCol();
                    break;
                case "3": // Посмотреть игрушки, готовые к выдаче (выигранные)
                    System.out.println("\nПодарки, готовые к выдаче:");
                    toys.printReadyToGiveToyCol();
                    break;
                case "4": // Выдать игрушку
                    System.out.println("\nВыдача призов");
                    toys.getToys();
                    break;
                case "5": // Посмотреть меню
                    System.out.println(menu);
                    break;
                case "0": // Закончить работу в программе
                    System.out.println("\nДо свидания!");
                    break;
                default:
                    System.out.println("\nТакой команды нет, введите цифру из меню.");
                    break;
            }
        }

        input.close();
    }
}
