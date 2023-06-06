import java.util.Scanner;

public class HeavyFreightWagon extends Wagon{
    private int capacity = 20000;
    private String loadType;

    public HeavyFreightWagon(String sender) {
        super(sender, 30000);
    }
    public void loadWagon(){
        System.out.println("What do you want to load?");
        Scanner scanner = new Scanner(System.in);
        loadType = scanner.nextLine();
        System.out.println("And how much of it?");
        capacity = scanner.nextInt();
        if(capacity <= 20000) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Loading " + loadType);
                    Thread.sleep(5000);
                    System.out.println(loadType + " Loaded");
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            });
            thread.start();
        }
        else
            System.out.println("That's to much");

    }

    @Override
    public String toString() {
        return "HeavyFreightWagon{" +
                super.toString() +
                " capacity=" + capacity +
                ", loadType='" + loadType + '\'' +
                '}';
    }
}
