import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaggageAndMailWagon extends Wagon{

    private int capacity;
    private ArrayList<String> bags = new ArrayList<>();
    public BaggageAndMailWagon(String sender) {
        super(sender, 25000);
        this.capacity = 90;
    }
    public void loadBaggageAndMail(){
        super.setWeight(getWeight() + capacity * capacity * 20);
    }

    public void alarm() throws Exception{
        throw new stealingException();
    }
    public void stopCrime(){
        System.exit(0);
    }
    public void sort(){
        bags.add("Suitcase");
        bags.add("Backpack");
        bags.add("Briefcase");
        bags.add("Laptop bag");
        bags.add("List");
        bags.add("Package");

        System.out.println("It seems, that baggage's are not sorted, let's change that");
        Collections.sort(bags);

        Thread thread = new Thread(()->{
            try {
                System.out.println("Sorting bags...");
                for(String bag : bags){
                    Thread.sleep(700);
                    System.out.println(bag);
                }
                System.out.println("Now it looks better :)");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();

    }

}
