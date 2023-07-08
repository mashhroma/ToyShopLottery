class Toy implements Comparable<Toy> {
    static public int counter;
    private int id;
    protected String name;
    protected int quantity;
    protected double chance;

    {
        counter++;
    }

    public Toy(String name) {
        this.id = counter;
        this.name = name;
        this.quantity = 1;
        this.chance = 0;
    }

    public Toy(String name, int quantity) {
        this.id = counter;
        this.name = name;
        this.quantity = quantity;
        this.chance = 0;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setChance (int chance) {
        this.chance = chance;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("id %d %s, количество %d, шанс выпадения %.0f%%", this.id, this.name, this.quantity, this.chance);
    }

    @Override
    public int compareTo (Toy o) {
        return Double.compare(chance, o.chance);
    }
}