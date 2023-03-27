package lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// другой способ посмотреть потоки
public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(() -> System.out.println("Executing"));
        //поток ЖДЕТ  заданий, не завершается
    }
}
