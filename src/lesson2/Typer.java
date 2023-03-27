package lesson2;

public class Typer extends Thread {
    static Object lock = new Object();
    String message;

    public Typer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < message.length(); i++) {
                System.out.println(message.charAt(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
