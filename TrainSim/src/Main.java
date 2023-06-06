import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Random;
public class Main {
    public static int totalDistance;
    private static Map<String, List<Track>> network = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trainMass = 0;
        int wagonCounter = 0;
        int gridConnectionCounter = 0;
        int locomotiveCounter = 0;
        int stealCounter = 0;
        int sugarCounter = 0;
        Locomotive locomotive = new Locomotive();
        PassengerWagon paswag = new PassengerWagon("PKP");
        MailWagon mailWagon = new MailWagon("Poczta Polska");
        BaggageAndMailWagon bam = new BaggageAndMailWagon("Poczta Polska");
        DiningWagon din = new DiningWagon("InterCity");
        BasicFreightWagon bfw = new BasicFreightWagon("PKPCargo");
        HeavyFreightWagon hbfw = new HeavyFreightWagon("PKPCargo");
        RefigeratedWagon rw = new RefigeratedWagon("PKPCargo");
        LiquidMaterialWagon liquid = new LiquidMaterialWagon("PKPCargo");
        GasMaterialsWagon gas = new GasMaterialsWagon("PKPCargo");
        ExplosivesWagon expl = new ExplosivesWagon("PKPCargo");
        ToxicMaterialWagon toxic = new ToxicMaterialWagon("PKPCargo");
        LiquidToxicMaterialsWagon ltoxic = new LiquidToxicMaterialsWagon("PKPCargo");

        Random rand = new Random();
        String[] stationsList = Stations.getStations();
        List<String> path;
        while (true) {
            try {
                Commands option = Commands.valueOf(scanner.nextLine());

                switch (option) {
                    case ADD_LOCO -> {
                         totalDistance = 0;
                        if(locomotiveCounter == 0) {
                            String startStation = stationsList[rand.nextInt(stationsList.length)];
                            String endStation = stationsList[rand.nextInt(stationsList.length)];
                            path = addConnectionsAndGetPath(network, stationsList, startStation, endStation);
                            System.out.println("Train's path: " + path);
                            locomotive = new Locomotive("PKP", startStation, endStation, network, path);
                            Locomotive.makeTrain(locomotive);
                            System.out.println("Locomotive max wagons capacity: " + locomotive.maxWagons);
                            System.out.println("Thrust: " + locomotive.thrust);
                            System.out.println("Max grid capacity: " + locomotive.maxGridCapacity);
                            System.out.println("ID: " + locomotive.getID());
                            for (int i = 0; i < path.size() - 1; i++) {
                                String currentStation = path.get(i);
                                String nextStation = path.get(i + 1);
                                int distance = locomotive.getDistance(currentStation, nextStation);
                                totalDistance += distance;
                            }
                            System.out.println("Total distance to cover : " + totalDistance + " km");
                            locomotiveCounter++;
                        }
                        else
                            System.out.println("Cannot add another Locomotive!");

                    }
                    case ADD_PASWAG -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if(checkLocomotiveStats(gridConnectionCounter, trainMass, wagonCounter, locomotive));
                        else {
                            paswag = new PassengerWagon("PKP");
                            Locomotive.makeTrain(paswag);
                            paswag.connect(paswag.getID());
                            trainMass += paswag.getWeight();
                            wagonCounter++;
                            gridConnectionCounter++;
                        }
                    }
                    case ADD_MAIL -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if(checkLocomotiveStats(gridConnectionCounter, trainMass, wagonCounter, locomotive));
                        else {
                            mailWagon = new MailWagon("Poczta Polska");
                            Locomotive.makeTrain(mailWagon);
                            mailWagon.connect(mailWagon.getID());
                            trainMass += mailWagon.getWeight();
                            wagonCounter++;
                            gridConnectionCounter++;
                        }
                    }
                    case ADD_BAM -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if(checkLocomotiveStats(trainMass, wagonCounter, locomotive));
                        else {
                            bam = new BaggageAndMailWagon("Poczta Polska");
                            Locomotive.makeTrain(bam);
                            trainMass += bam.getWeight();
                            wagonCounter++;
                        }
                    }
                    case ADD_DIN -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if((checkLocomotiveStats(gridConnectionCounter, trainMass, wagonCounter, locomotive)));
                        else {
                            din = new DiningWagon("Poczta Polska");
                            Locomotive.makeTrain(din);
                            trainMass += bam.getWeight();
                            din.connect(din.getID());
                            wagonCounter++;
                            gridConnectionCounter++;
                        }
                    }
                    case ADD_BFW -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if(checkLocomotiveStats(trainMass, wagonCounter, locomotive));
                        else {
                            bfw = new BasicFreightWagon("Poczta Polska");
                            Locomotive.makeTrain(bam);
                            trainMass += bfw.getWeight();
                            wagonCounter++;
                        }
                    }
                    case ADD_HBFW -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if(checkLocomotiveStats(trainMass, wagonCounter, locomotive));
                        else {
                            hbfw = new HeavyFreightWagon("Poczta Polska");
                            Locomotive.makeTrain(hbfw);
                            trainMass += hbfw.getWeight();
                            wagonCounter++;
                        }
                    }
                    case ADD_FRIDGE -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if((checkLocomotiveStats(gridConnectionCounter, trainMass, wagonCounter, locomotive)));
                        else {
                            rw = new RefigeratedWagon("Poczta Polska");
                            Locomotive.makeTrain(rw);
                            rw.connect(rw.getID());
                            trainMass += rw.getWeight();
                            wagonCounter++;
                            gridConnectionCounter++;
                        }
                    }
                    case ADD_LIQUID -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if(checkLocomotiveStats(trainMass, wagonCounter, locomotive));
                        else {
                            liquid = new LiquidMaterialWagon("Poczta Polska");
                            Locomotive.makeTrain(liquid);
                            trainMass += liquid.getWeight();
                            wagonCounter++;
                        }
                    }
                    case ADD_GAS -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if(checkLocomotiveStats(trainMass, wagonCounter, locomotive));
                        else {
                            gas = new GasMaterialsWagon("Poczta Polska");
                            Locomotive.makeTrain(gas);
                            trainMass += gas.getWeight();
                            wagonCounter++;
                        }
                    }
                    case ADD_EXPL -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if(checkLocomotiveStats(trainMass, wagonCounter, locomotive));
                        else {
                            expl = new ExplosivesWagon("Poczta Polska");
                            Locomotive.makeTrain(expl);
                            trainMass += expl.getWeight();
                            wagonCounter++;
                        }
                    }
                    case ADD_TOXIC -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if (checkLocomotiveStats(trainMass, wagonCounter, locomotive)) ;
                        else {
                            toxic = new ToxicMaterialWagon("Poczta Polska");
                            Locomotive.makeTrain(toxic);
                            trainMass += toxic.getWeight();
                            wagonCounter++;
                        }
                    }
                    case ADD_LTOXIC -> {
                        if (Locomotive.wagons.isEmpty())
                            System.out.println("First you have to add Locomotive!");
                        else if (checkLocomotiveStats(trainMass, wagonCounter, locomotive)) ;
                        else {
                            ltoxic = new LiquidToxicMaterialsWagon("Poczta Polska");
                            Locomotive.makeTrain(ltoxic);
                            trainMass += ltoxic.getWeight();
                            wagonCounter++;
                        }
                    }
                    case LOAD_LTOXIC -> ltoxic.loadWagon();
                    case LOAD_TOXIC -> toxic.loadWagon();
                    case LOAD_EXPL -> expl.loadWagon();
                    case FILL_GAS -> gas.loadWagon();
                    case CHECK_PRESS -> gas.checkPressure();
                    case LOAD_HBFW -> hbfw.loadWagon();
                    case DRINK -> expl.detonateWagon();
                    case ORDER_FOOD -> din.buyFood();
                    case SHOW_TRAIN -> {
                        System.out.println("What train you want to see? (provide ID of a locomotive)");
                        int trainID = scanner.nextInt();
                        scanner.nextLine();
                        List<List<Object>> wholeSquad = Locomotive.getTabor();
                        List<Object> resultList = null;
                        for (List<Object> train : wholeSquad) {
                            for (Object obj : train) {
                                if (obj instanceof Locomotive && ((Locomotive) obj).getID() == trainID) {
                                    resultList = train;
                                    break;
                                }
                            }
                            if (resultList != null)
                                break;
                        }
                        if (resultList != null) {
                            for (Object obj : resultList)
                                System.out.println(obj);
                        } else
                            System.out.println("Train with ID " + trainID + " was not found.");
                    }
                    case CLOSE_TRAIN -> {
                        Locomotive.closeTrain();
                        try{
                            FileWriter writer = new FileWriter("AppState.txt", true);
                            for(List<Object> train : Locomotive.tabor) {
                                for (Object wagons : train) {
                                    writer.write(wagons.toString());
                                    writer.write(System.lineSeparator());
                                }

                            }
                            writer.close();
                        }
                        catch (IOException e){
                            System.out.println("File don't exist");
                        }
                        locomotiveCounter = 0;
                        trainMass = 0;
                        gridConnectionCounter = 0;
                        wagonCounter = 0;
                    }
                    case EXIT -> {
                        System.exit(0);
                    }
                    case START -> {
                        if(sugarCounter == 0) {
                            List<Object> loco = Locomotive.getLocomotive();
                            for (int i = 0; i < loco.size(); i++) {
                                Thread thread = new Thread((Runnable) loco.get(i));
                                thread.start();
                            }
                        }
                        else
                            System.out.println("There is sugar in benzine, remove train with it");
                    }
                    case SIMULATION -> {
                        for(int i = 0; i < 25; i++){
                            String startStation = stationsList[rand.nextInt(stationsList.length)];
                            String endStation = stationsList[rand.nextInt(stationsList.length)];
                            path = addConnectionsAndGetPath(network, stationsList, startStation, endStation);
                            locomotive = new Locomotive("PKP", startStation, endStation, network, path);
                            System.out.println("Train " + locomotive.getID() + " path: " + path);
                            Locomotive.makeTrain(locomotive);
                            Locomotive.closeTrain();
                        }
                    }
                    case LOAD_PASWAG -> {
                        paswag.loadPassangers();
                    }
                    case RM_TRAIN -> {
                        System.out.println("What train you want to remove? (provide ID of locomotive)");
                        int trainID = scanner.nextInt();
                        scanner.nextLine();
                        List<List<Object>> wholeSquad = Locomotive.getTabor();
                        Iterator<List<Object>> iterator = wholeSquad.iterator();

                        while (iterator.hasNext()) {
                            List<Object> train = iterator.next();
                            for (Object obj : train) {
                                if (obj instanceof Locomotive && ((Locomotive) obj).getID() == trainID) {
                                    iterator.remove();
                                    break;
                                }
                            }
                        }
                        sugarCounter = 0;
                    }
                    case CLIMA -> paswag.turnOnClimatizotion();
                    case KICK -> paswag.kickOutPassengers();
                    case LOAD_MAIL -> mailWagon.loadMail();
                    case GUARD -> {
                        System.out.println("Provide security messures");
                        Scanner scan = new Scanner(System.in);
                        String security = scan.nextLine();
                        mailWagon.guardMail(security);
                    }
                    case BURN -> mailWagon.burnMails();
                    case STEAL -> {
                        if(stealCounter == 0) {
                            stealCounter++;
                            bam.alarm();

                        }
                        else{
                            System.out.println("Stealing is very bad! I can't let you do it anymore, I'm closing this program");
                            bam.stopCrime();
                        }

                    }
                    case SORT_BAM -> bam.sort();
                    case LOAD_BFW -> bfw.loadWagon();
                    case LOWER_TEMP -> rw.lowerTemperature();
                    case CHECK_TEMP -> rw.sensor();
                    case FILL_LIQUID -> liquid.loadWagon();
                    case SABOTAGE -> {
                        sugarCounter++;
                        liquid.throwSugarToLiquid();
                    }
                    case EX -> toxic.callMyEx(); //791101702
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Wrong command!");
           }
            catch (LocomotiveOverloadException e){
                System.out.println(e);
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("You haven't added any train yet!");
            }
            catch (InputMismatchException e){
                System.out.println("Wrong input!");
            }
            catch (stealingException e){
                System.out.println(e);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static boolean checkLocomotiveStats(int gridConnectionCounter, int trainMass, int wagonCounter,  Locomotive locomotive) throws Exception{
        if(gridConnectionCounter >= locomotive.maxGridCapacity ||trainMass >= locomotive.thrust || wagonCounter >= locomotive.maxWagons)
            throw new LocomotiveOverloadException();
        return false;
    }
    public static boolean checkLocomotiveStats(int trainMass, int wagonCounter,  Locomotive locomotive) throws Exception{
        if(trainMass >= locomotive.thrust || wagonCounter >= locomotive.maxWagons)
            throw new LocomotiveOverloadException();
        return false;
    }
    public static List<String> addConnectionsAndGetPath(Map<String, List<Track>> network, String[] stationsList, String start, String end) {
        Random rand = new Random();
        List<String> stationList = Arrays.asList(stationsList);
        for (int i = 0; i < stationsList.length; i++) {
            String source = stationList.get(i);
            String destination1, destination2;
            do {
                destination1 = stationList.get(rand.nextInt(stationList.size()));
                destination2 = stationList.get(rand.nextInt(stationList.size()));
            } while (destination1.equals(source) || destination2.equals(source) || destination1.equals(destination2));

            int distance1 = rand.nextInt(100);
            int distance2 = rand.nextInt(100);

            if (!network.containsKey(source)) {
                network.put(source, new ArrayList<>());
            }
            if (!network.containsKey(destination1)) {
                network.put(destination1, new ArrayList<>());
            }
            if (!network.containsKey(destination2)) {
                network.put(destination2, new ArrayList<>());
            }

            network.get(source).add(new Track(destination1, distance1));
            network.get(destination1).add(new Track(source, distance1));

            network.get(destination1).add(new Track(destination2, distance2));
            network.get(destination2).add(new Track(destination1, distance2));
        }

        return bfs(network, start, end);
    }
    public static List<String> bfs(Map<String, List<Track>> network, String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();

        for (String station : network.keySet()) {
            visited.put(station, false);
        }

        queue.offer(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            String currentStation = queue.poll();
            if (end != null && currentStation.equals(end)) {
                return reconstructPath(predecessors, start, end);
            }
            for (Track track : network.get(currentStation)) {
                String neighbor = track.getDestination();
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.offer(neighbor);
                    predecessors.put(neighbor, currentStation);
                }
            }
        }
        if (end != null) {
            return null;
        } else {
            List<String> reachableStations = new ArrayList<>();
            for (String station : network.keySet()) {
                if (visited.get(station)) {
                    reachableStations.add(station);
                }
            }
            return reachableStations;
        }
    }

    private static List<String> reconstructPath(Map<String, String> predecessors, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;
        while (!current.equals(start)) {
            path.add(current);
            current = predecessors.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
}



