public class program {
    public static void main(String[] args) {

        ToyCollection toys = new ToyCollection();
        toys.putToy(new Toy ("конструктор", 2));
        toys.putToy(new Toy ("робот", 2));
        toys.putToy(new Toy ("кукла", 6));

        System.out.println("Всего подарков в автомате:");
        toys.printActiveToyCol();

        toys.runLottery();

        System.out.println("Подарки, готовые к выдаче:");
        toys.printReadyToGiveToyCol();

        System.out.println("Осталось подарков в автомате:");
        toys.printActiveToyCol();

    }
}
