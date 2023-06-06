public interface ConnectionToGrid {
     default void connect(int ID){

          System.out.println("Wagon " + ID + " connected to grid");

     }

}
