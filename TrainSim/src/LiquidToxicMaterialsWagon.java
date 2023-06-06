import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LiquidToxicMaterialsWagon extends HeavyFreightWagon implements LiquidInterface{

    private int weight;
    private int capacity;
    private String liquidType;
    private static List<String> liquidList = new ArrayList();
    public LiquidToxicMaterialsWagon(String sender) {
        super(sender);
    }

    @Override
    public void liquid() {
         weight = 30000;
         capacity = 10000;
    }
    private static List<String> liquids(){
        if(liquidList.isEmpty()) {
            liquidList.add("Hydrochloric acid");
            liquidList.add("Sulphuric acid");
            liquidList.add("Pesticides");

        }
        return liquidList;
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
        this.weight = weight + capacity*2;
    }



}
