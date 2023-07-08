public class program {
    public static void main(String[] args) {

        ToyCollection toys = new ToyCollection();
        toys.putToy(new Toy ("конструктор", 2));
        toys.putToy(new Toy ("робот", 2));
        toys.putToy(new Toy ("кукла", 6));

        toys.printActiveToyCol();

        toys.printReadyToGiveToyCol();

    //     Toy toy1 = new Toy ("конструктор", 2);
    //     Toy toy2 = new Toy ("робот", 2);
    //     Toy toy3 = new Toy ("кукла", 6);

    //     System.out.println(toy1);
    //     System.out.println(toy2);
    //     System.out.println(toy3);
    }
}
