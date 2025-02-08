package Client2;

public class Client2 {
    public static void main(String[] args) {
        new Thread(new Receiver2()).start();
    }
}
