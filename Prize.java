class Prize{
    private int id;
    protected String name;
    protected int quantity;

    public Prize(int id, String name) {
        this.id = id;
        this.name = name;
        this.quantity = 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("id %d %s, количество %d", this.id, this.name, this.quantity);
    }
}