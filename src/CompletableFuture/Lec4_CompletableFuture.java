package CompletableFuture;

import java.util.concurrent.*;

public class Lec4_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        Future<String> future = executorService.submit(() -> "hello");
//        future.get();
        // Future의 한계 : 블로킹코드(get())을 사용하지 않고서는 작업이 끝났을 때 콜백을 실행할 수 없다.

//        CompletableFuture<String> future = new CompletableFuture<>();
//        future.complete("k"); // 기본 값
//        System.out.println(future.get());

//        CompletableFuture<String> future = CompletableFuture.completedFuture("k");
//        System.out.println(future.get());

        CompletableFuture.runAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
        }).get();

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(stringCompletableFuture.get());

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        System.out.println(voidCompletableFuture.get());

        CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        }).get();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService).get();
        executorService.shutdown();




    }
}
