import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ToxicMaterialWagon extends HeavyFreightWagon{

    public int weight = 25000;
    public int capacity = 10000;
    public int myExNumber = 791101702;
    private static List<String> toxicList = new ArrayList();
    public ToxicMaterialWagon(String sender) {
        super(sender);
    }

    public List<String> toxic(){
        if(toxicList.isEmpty()){
            toxicList.add("Azbest");
            toxicList.add("My ex");
            toxicList.add("Lead");
            toxicList.add("Mercury");
        }
        return toxicList;
    }
    public void loadWagon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to put in gas tank?");
        for(String l : toxic())
            System.out.println(l);
        String option = scanner.nextLine();
        for(String l : toxic()){
            if(option.equals(l)) {
                toxicList = Collections.singletonList(l);
                System.out.println(l + " putted");
                break;
            }
            else {
                System.out.println("You can't fill gas tank with it");
                break;
            }
        }
        this.weight = weight + capacity;
    }
    public void callMyEx(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who do you want to call?");
        int number = scanner.nextInt();
        if(number == myExNumber) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Calling...");
                    Thread.sleep(2000);
                    System.out.println("Beep...");
                    Thread.sleep(2000);
                    System.out.println("Beep...");
                    Thread.sleep(2000);
                    System.out.println("Her: Hello?");
                    Thread.sleep(3000);
                    System.out.println("Employee: Yeah, hi, it's me, i just wanted to thank you");
                    Thread.sleep(1000);
                    System.out.println("Her: Thank you for what?");
                    Thread.sleep(1000);
                    System.out.println("Employee: Thank you for Deez");
                    Thread.sleep(1000);
                    System.out.println("Her: Deez what?");
                    Thread.sleep(1000);
                    System.out.println("Employee: Deez Nuts, HA GOT IM");
                    System.out.println("*Hang up*");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
        else
            System.out.println("Wrong number;");
    }

}
