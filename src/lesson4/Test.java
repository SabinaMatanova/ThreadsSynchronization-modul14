package lesson4;

//как проверить потоки, как увидеть их ошибки

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    //создаем два лока
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    //создаем ситуацию, когда потоки блокируются, из-за ожидания другого потока
    private void doWork1 (){
        synchronized (lock1){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("Working on job 1");
            }
        }
    }
    private void doWork2 (){
        synchronized (lock2){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("Working on job 2");
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
//задаем фикс - 2 пользовательских потока
        ExecutorService service = Executors.newFixedThreadPool(2);
// Говорим сделать dowork
        service.execute(() -> test.doWork1());
        service.execute(() -> test.doWork2());
// Чтобы остановить потоки - закрывает shutdown
        service.shutdown();

        // после этого запускаем программу и нажимаем на фотоаппарат слева



    }
}
