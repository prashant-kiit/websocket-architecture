package Client1;
public class Client1 {
    public static void main(String[] args) {
        new Thread(new Sender1()).start();
    }
}
