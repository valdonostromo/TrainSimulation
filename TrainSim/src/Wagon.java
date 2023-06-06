public  abstract class Wagon {
    public static int getWeight;
    private String sender;
    private int weight;
    private int ID;
    private static int counter = 100;
    public Wagon(String sender, int weight) {
        this.sender = sender;
        this.weight = weight;
        this.ID = counter++;
    }

    public int getID() {
        return ID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "sender='" + sender + '\'' +
                ", weight=" + weight +
                ", ID=" + ID;
    }
}
