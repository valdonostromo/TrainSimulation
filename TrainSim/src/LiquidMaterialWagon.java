import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LiquidMaterialWagon extends BasicFreightWagon implements LiquidInterface{
    private int weight = 30000;
    private int capacity = 10000;
    private String liquidType;
    private static List<String> liquidList = new ArrayList();
    public LiquidMaterialWagon(String sender) {
        super(sender);
    }
    private static List<String> liquids(){
        if(liquidList.isEmpty()) {
            liquidList.add("Benzine");
            liquidList.add("Water");
            liquidList.add("Alcohol");

        }
        return liquidList;
    }
    @Override
    public int getWeight() {
        return weight;
    }

    public void loadWagon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to pour in?");
        for(String l : liquids())
            System.out.println(l);
        liquidType = scanner.nextLine();
        for(String l : liquids()){
            if(liquidType.equals(l)) {
                liquidList = Collections.singletonList(l);
                System.out.println(l + " poured");
                break;
            }
            else {
                System.out.println("You can't pour that in");
                break;
            }
        }
        this.weight = weight + capacity;
    }




    public void throwSugarToLiquid(){
        if(liquidType.equals("Benzine")){
            Thread thread = new Thread(() -> {
                try{
                    System.out.println("Sabotaging wagon...");
                    Thread.sleep(2000);
                    System.out.println("Nice, you got cought, now you have to remove this train, or simulation wont start!");
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
        else {
            System.out.println("There is no need to put sugar here");
        }
    }

    @Override
    public String toString() {
        return "LiquidMaterialWagon{" +
                super.toString() +
                "weight=" + weight +
                ", capacity=" + capacity +
                ", liquidType='" + liquidType + '\'' +
                '}';
    }

}
