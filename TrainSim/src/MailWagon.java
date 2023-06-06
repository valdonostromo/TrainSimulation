public class MailWagon extends Wagon implements ConnectionToGrid{
    private int mailCapacity;
    public MailWagon(String sender) {
        super(sender, 15000);
        this.mailCapacity = 2000;
    }
    public void loadMail(){
        super.setWeight(getWeight() + (mailCapacity * 2));
        System.out.println("Mails loaded");
    }

    public void guardMail(String security){
        if(security.equals("gun")) {
            System.out.println("                           ______\n" +
                    "        |\\_______________ (_____\\\\______________\n" +
                    "HH======#H###############H#######################\n" +
                    "        ' ~\"\"\"\"\"\"\"\"\"\"\"\"\"\"`##(_))#H\\\"\"\"\"\"Y########\n" +
                    "                          ))    \\#H\\       `\"Y###\n" +
                    "                          \"      }#H)");
            System.out.println("Better don't mess with my mails!");
        }
        else
            System.out.println("Security you provided is to weak");
    }
    public void burnMails(){
        Thread thread = new Thread(()->{
                try {
                    if(super.getWeight() > 15000) {
                        System.out.println("Employees starting to burn mails...");
                        Thread.sleep(2000);
                        System.out.println("Mails burned!");
                        System.out.println("⠀⠀⠀⠀⠀⠀⢱⣆⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠈⣿⣷⡀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣧⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⡀⢠⣿⡟⣿⣿⣿⡇⠀⠀\n" +
                                "⠀⠀⠀⠀⣳⣼⣿⡏⢸⣿⣿⣿⢀⠀\n" +
                                "⠀⠀⠀⣰⣿⣿⡿⠁⢸⣿⣿⡟⣼⡆\n" +
                                "⢰⢀⣾⣿⣿⠟⠀⠀⣾⢿⣿⣿⣿⣿\n" +
                                "⢸⣿⣿⣿⡏⠀⠀⠀⠃⠸⣿⣿⣿⡿\n" +
                                "⢳⣿⣿⣿⠀⠀⠀⠀⠀⠀⢹⣿⡿⡁\n" +
                                "⠀⠹⣿⣿⡄⠀⠀⠀⠀⠀⢠⣿⡞⠁\n" +
                                "⠀⠀⠈⠛⢿⣄⠀⠀⠀⣠⠞⠋⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀");
                        super.setWeight(getWeight() - mailCapacity);
                    }
                    else
                        System.out.println("There is not much to burn");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        });
        thread.start();
    }

    @Override
    public String toString() {
        return "MailWagon{" +
                super.toString() +
                " mailCapacity=" + mailCapacity +
                '}';
    }
}
