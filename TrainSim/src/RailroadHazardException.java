public class RailroadHazardException extends Exception{
    public RailroadHazardException(int ID) {
        super("Train " + ID + " going to fast\n");
    }
}
