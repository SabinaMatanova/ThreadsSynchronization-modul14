package lesson3_volatile;

class Processor extends Thread {
//volatile — это инструкция для JVM не сохранять и читать из кэш-памяти потока,
// а всегда сохранять и читать из общей памяти. В таком случае любые изменения с
// переменной извне будут видны действующему потоку и напротив, все изменения,
// которые проводит действующий поток с переменной, будут сразу видны другим потокам.
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Processing...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void shutDown() {
        running = false;
    }
}

public class App {

    public static void main(String[] args) throws InterruptedException {
        Processor processor1 = new Processor();
        processor1.start();

        Thread.sleep(1000);

        processor1.shutDown();
    }

}