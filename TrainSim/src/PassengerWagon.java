public class PassengerWagon
        extends Wagon
        implements ConnectionToGrid {
    private int seatingCapacity;
    public PassengerWagon(String sender) {
        super(sender, 20000);
        this.seatingCapacity = 90;
    }
    public int getWeight(){
        return super.getWeight();
    }

    public void loadPassangers(){
        super.setWeight(getWeight()+seatingCapacity*80); //based on average adult weight;
    }

    public void turnOnClimatizotion(){
        Thread thread = new Thread(()->{
            for(int i = 5; i > 0; i--){
                try {
                    System.out.println(i + "...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Passenger wagon is now cooler :)");
        });
        thread.start();
    }
    public void kickOutPassengers(){
        super.setWeight(getWeight()-seatingCapacity*80); //based on average adult weight;
        System.out.println("Passenger wagon is now empty");
    }

    @Override
    public String toString() {
        return "PassengerWagon{" +
                super.toString() +
                " seatingCapacity=" + seatingCapacity +
                '}';
    }
}
