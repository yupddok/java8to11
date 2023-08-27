package CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Lec5_CompletableFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("world " + Thread.currentThread().getName());
            return "world";
        });

        // 모든 작업 끝나기를 기다렸다가 처리
        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futruesArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futruesArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        results.get().forEach(System.out::println);

        // 아무거나 하나 빨리끝나는거
        CompletableFuture.anyOf(hello, world).thenAccept(System.out::println).get();

        CompletableFuture<String> future1 = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future1.get());


        CompletableFuture<String> future = hello.thenCompose(Lec5_CompletableFuture2::apply);
        System.out.println(future.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("world " + Thread.currentThread().getName());
            return message + " world";
        });
    }

    private static CompletionStage<String> apply(String s) {
        return getWorld(s);
    }
}
