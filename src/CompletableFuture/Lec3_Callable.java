package CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Lec3_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };
        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };
        Callable<String> k = () -> {
            Thread.sleep(1000L);
            return "k";
        };
        
        // invokeAll(): 제일 긴 스레드까지 기다린 후  List로 결과가져옴
//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, k));
//        for (Future<String> future : futures) {
//            System.out.println(future.get());
//        }

        // invokeAny(): 제일 빨리 끝난거 반환
        String s = executorService.invokeAny(Arrays.asList(hello, java, k));
        System.out.println(s);


//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println(helloFuture.isDone());
//        System.out.println("started!");
//
//        helloFuture.get(); // 블록킹
//
//        helloFuture.cancel(true); // true: 현재 진행중 작업 인터럽트하면서 종료. false: 기다림
//
//        System.out.println(helloFuture.isDone());
//        System.out.println("End!");
        executorService.shutdown();
    }
}
