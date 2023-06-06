import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GasMaterialsWagon extends BasicFreightWagon{
    private int weight = 20000;
    private int pressure;
    private static List<String> gasMaterials = new ArrayList();
    public GasMaterialsWagon(String sender) {
        super(sender);
    }
    public List<String> gasList(){
        if(gasMaterials.isEmpty()){
            gasMaterials.add("Metan");
            gasMaterials.add("Etan");
            gasMaterials.add("Propan");
            gasMaterials.add("Butan");
        }
        return gasMaterials;
    }
    public void loadWagon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to put in gas tank?");
        for(String l : gasList())
            System.out.println(l);
        String option = scanner.nextLine();
        for(String l : gasList()){
            if(option.equals(l)) {
                gasMaterials = Collections.singletonList(l);
                System.out.println(l + " poured");
                break;
            }
            else {
                System.out.println("You can't fill gas tank with it");
                break;
            }
        }
        this.pressure = 100;
    }
    public void checkPressure(){
        if(pressure < 100)
            System.out.println("Fill wagon with gas");
        System.out.println("Pressure OK");
    }

    @Override
    public String toString() {
        return "GasMaterialsWagon{" +
                super.toString() +
                "weight=" + weight +
                ", pressure=" + pressure +
                '}';
    }
}
