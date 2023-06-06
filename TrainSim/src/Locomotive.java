import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Locomotive implements Runnable{
    protected int maxWagons = (int)(Math.random()* (10 - 5)+5);
    protected int thrust = (int)(Math.random()*(1000000-80000)+80000);
    protected int maxGridCapacity;
    private int speed = 150;
    private int ID;
    private static int counter = 200;
    private String name;
    private String currentStation;
    private String destination;
    private Map<String, List<Track>> network;
    protected static List<List<Object>> tabor = new ArrayList<>();
    protected static List<Object> wagons = new ArrayList<>();
    protected static List<Object> locomotives = new ArrayList<>();
    public Locomotive(String name, String currentStation, String destination, Map<String, List<Track>> network, List<String> path) {
        this.name = name;
        this.currentStation = currentStation;
        this.destination = destination;
        this.ID = counter++;
        this.maxGridCapacity = (int)(Math.random()*(3-1)+1);
        this.network = network;
        Thread thread = new Thread(() -> {
            while (true) {
                double random = Math.random()*10;
                if(random > 5) {
                    speed += (int) Math.round(speed * 0.03);
                }
                else
                    speed -= (int) Math.round(speed * 0.03);

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

    public Locomotive() {

    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "maxWagons=" + maxWagons +
                ", thrust=" + thrust +
                ", maxGridCapacity=" + maxGridCapacity +
                ", speed=" + speed +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", currentStation='" + currentStation + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public static void makeTrain(Object wagon){
        wagons.add(wagon);
    }
    public static void closeTrain(){
        tabor.add(wagons);
        wagons = new ArrayList<>();
    }
    public static List<Object> getLocomotive(){
        for (List<Object> loco : tabor){
            if(!loco.isEmpty())
                locomotives.add(loco.get(0));
        }

        return locomotives;
    }
    public static List<List<Object>> getTabor() {
        return tabor;
    }
    public void run() {
        try {
            while (true) {
                List<String> path = Main.bfs(network, currentStation, destination);
                for (int i = 0; i < path.size() - 1; i++) {
                    String currentStation = path.get(i);
                    String nextStation = path.get(i + 1);
                    double distance = getDistance(currentStation, nextStation);
                    //double percentage = (distance * speed / Main.totalDistance)*100;
                    System.out.println("Train " + ID + " is now traveling from " + currentStation + " to " + nextStation);
                    System.out.println("Train " + ID + " traveling at " + speed + " km/h");
                    System.out.println("Distance to nearest station: " + distance);
                    //System.out.println("Train covered: " + percentage + "% of it's distance");
                    Thread.sleep((long) (distance * speed));

                    System.out.println("Train " + ID + " arrived at next station " + nextStation + " waiting 2 sec...");
                    Thread.sleep(2000);
                }
                System.out.println("Train " + ID + " arrived at destination.");
                Thread.sleep(30000);
                System.out.println("Train " + ID + " returning to start station.");
                List<String> returnPath = Main.bfs(network, destination, currentStation);
                for (int i = 0; i < returnPath.size() - 1; i++) {
                    String currentStation = returnPath.get(i);
                    String nextStation = returnPath.get(i + 1);
                    int distance = getDistance(currentStation, nextStation);
                    System.out.println("Train " + ID + " is now traveling from " + currentStation + " to " + nextStation);
                    Thread.sleep(distance * speed);
                    System.out.println("Train " + ID + " arrived at next station " + nextStation + " waiting 2 sec...");
                    Thread.sleep(2000);
                }
                System.out.println("Train " + ID + " arrived at destination.");
                Thread.sleep(30000);
                System.out.println("Train " + ID + "  returning to end station.");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public int getDistance(String station1, String station2) {
        List<Track> tracks = network.get(station1);
        for (Track track : tracks) {
            if (track.getDestination().equals(station2)) {
                return track.getDistance();
            }
        }
        return 0;
    }

    public int getID() {
        return ID;
    }

    public  int getSpeed() {
        return speed;
    }
}

