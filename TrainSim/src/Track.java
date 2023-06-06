public class Track implements Comparable<Track>{
    public final String destination;
    public final int distance;


    public Track(String destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Track t) {
        return 0;
    }
}