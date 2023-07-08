public class program {
    public static void main(String[] args) {

        ToyCollection toys = new ToyCollection();
        toys.putToy(new Toy ("конструктор", 2));
        toys.putToy(new Toy ("робот", 2));
        toys.putToy(new Toy ("кукла", 6));

        System.out.println("Всего подарков в автомате:");
        toys.printActiveToyCol();
        System.out.println("");

        for (int i = 0; i < 10; i++) {
            System.out.println("\nЗапуск розыгрыша №" + (i+1));
            toys.runLottery();
        }

        System.out.println("\nПодарки, готовые к выдаче:");
        toys.printReadyToGiveToyCol();

        System.out.println("\nОсталось подарков в автомате:");
        toys.printActiveToyCol();

    }
}
