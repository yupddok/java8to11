package CompletableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Lec2_Executor {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread " + Thread.currentThread().getName());
//            }
//        });

//        executorService.submit(() -> {
//
//        });

//        executorService.shutdown(); // graceful shutdown : 현재진행중 작업 끝내고 마치기
//        executorService.shutdownNow(); // 당장종료


//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(getRunnable("hello"));
//        executorService.submit(getRunnable("k"));
//        executorService.submit(getRunnable("the"));
//        executorService.submit(getRunnable("java"));
//        executorService.submit(getRunnable("thread"));
//        executorService.shutdown();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(getRunnable("hello"), 1, 2, TimeUnit.SECONDS);

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
