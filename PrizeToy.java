class PrizeToy {
    static public int counter;
    protected int id;
    protected String name;
    protected int quantity;
    protected int chance;

    {
        counter++;
    }

    public PrizeToy(String name, int chance) {
        this.id = counter;
        this.name = name;
        this.chance = chance;
        quantity = 1;
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

    



}