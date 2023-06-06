import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DiningWagon extends Wagon implements ConnectionToGrid{

    private static final ArrayList<String> menu = new ArrayList<>();
    private int foodItems = 10;
    private static ArrayList<String> menuList(){
        if(menu.isEmpty()) {
            menu.add("Pierogi");
            menu.add("Tomato soup");
            menu.add("Toast");
            menu.add("Pizza");
            menu.add("Beer");
        }
        return menu;
    }
    public DiningWagon(String sender) {
        super(sender, 30000);
    }

    public void buyFood(){
        if(foodItems == 0)
            System.out.println("Sorry, we don't have food anymore");
        System.out.println("Our today's menu is: ");
        for(String m : menuList())
            System.out.println(m);

        System.out.println("Would you like to order? yes/no");
        Scanner scanner = new Scanner(System.in);
        String yesNo = scanner.nextLine();
        List<String> orderList = null;
        if(yesNo.equals("yes")){
            System.out.println("What do you want to get?");
            String option = scanner.nextLine();
            for(String m : menuList()){
                if(option.equals(m)) {
                    orderList = Collections.singletonList(m);
                    break;
                }
                else {
                    System.out.println("We don't have that in our menu, order again");
                    break;
                }
            }
        }
        else if(yesNo.equals("no")) {
            System.out.println("That's alright, have a nice day :)");
        }
        else
            System.out.println("Wrong answer");
        if(orderList != null) {
            foodItems--;
            for (String order : orderList) {
                System.out.println("Serving " + order + " in just few seconds :)");
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(3000);
                        System.out.println("Here you go, your order");
                        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⣀⠀⡀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀\n" +
                                "⠀⣿⠀⡇⣿⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣷⡀⠀\n" +
                                "⠀⣿⣤⣧⣿⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣷⣦⣄⠀⠀⠀⠀⠀⢸⣿⡇⠀\n" +
                                "⠀⣿⣿⣿⣿⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⢸⣿⣿⠀\n" +
                                "⠀⠈⢻⡟⠁⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⢸⣿⡇⠀\n" +
                                "⠀⠀⢸⡇⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⢸⡿⠁⠀\n" +
                                "⠀⠀⢸⣿⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⢸⡆⠀⠀\n" +
                                "⠀⠀⢸⣿⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⢸⡇⠀⠀\n" +
                                "⠀⠀⣿⣿⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⢸⡇⠀⠀\n" +
                                "⠀⠀⣿⣿⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⢸⣿⠀⠀\n" +
                                "⠀⠀⣿⣿⠀⠀⠀⠀⠀⠙⠻⢿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⢸⣿⠀⠀\n" +
                                "⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡄⠀\n" +
                                "⠀⠀⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                thread.start();
            }
            }
    }

    @Override
    public String toString() {
        return "DiningWagon{" +
                super.toString() +
                "foodItems=" + foodItems +
                '}';
    }
}
