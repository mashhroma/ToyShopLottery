class Prize{

    static public int counter;
    private int id;
    protected String name;

    {
        counter++;
    }

    public Prize(String name) {
        this.id = counter;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId () {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}