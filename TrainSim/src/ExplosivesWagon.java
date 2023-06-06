import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExplosivesWagon extends HeavyFreightWagon{

    private int weight = 35000;
    private int numberOfDrunkEmplees = 1;
    private List<String> explosivesList = new ArrayList<>();
    private String explosive;

    public ExplosivesWagon(String sender) {
        super(sender);
        Thread thread = new Thread(() -> {
            while (true) {
                double random = Math.random()*10;
                if(random > 2) {
                    numberOfDrunkEmplees += 1;
                }
                else if (numberOfDrunkEmplees < 0)
                    numberOfDrunkEmplees = 0;
                else
                    numberOfDrunkEmplees -=1;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public List<String> explsives(){
        if(explosivesList.isEmpty()){
            explosivesList.add("TNT");
            explosivesList.add("Nuclear Bomb");
            explosivesList.add("C4");
            explosivesList.add("Granades");
        }
        return explosivesList;
    }
    public void loadWagon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to put in gas tank?");
        for(String l : explsives())
            System.out.println(l);
        String option = scanner.nextLine();
        for(String l : explsives()){
            if(option.equals(l)) {
                explosivesList = Collections.singletonList(l);
                System.out.println(l + " putted");
                break;
            }
            else {
                System.out.println("You can't fill gas tank with it");
                break;
            }
        }
    }
    public void detonateWagon(){
        if(numberOfDrunkEmplees >= 3){
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Oh no, drunk employee starts to smoke");
                    Thread.sleep(5000);
                    System.out.println("Explosive wagon is no more");
                    System.out.println("      _ ._  _ , _ ._\n" +
                            "        (_ ' ( `  )_  .__)\n" +
                            "      ( (  (    )   `)  ) _)\n" +
                            "     (__ (_   (_ . _) _) ,__)\n" +
                            "         `~~`\\ ' . /`~~`\n" +
                            "              ;   ;\n" +
                            "              /   \\\n" +
                            "_____________/_ __ \\_____________");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
            thread.start();
        }
        else{
            System.out.println("Everything seems to be fine... for now");
        }
    }

    @Override
    public String toString() {
        return "ExplosivesWagon{" +
                super.toString() +
                "weight=" + weight +
                ", numberOfDrunkEmplees=" + numberOfDrunkEmplees +
                ", explosivesList=" + explosivesList +
                ", explosive='" + explosive + '\'' +
                '}';
    }
}
