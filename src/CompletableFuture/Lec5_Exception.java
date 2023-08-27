package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Lec5_Exception {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("hello" + Thread.currentThread().getName());
            return "hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error";
        });

        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("hello" + Thread.currentThread().getName());
            return "hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "ERROR!!";
            }
            return result;
        });
        System.out.println(hello2.get());
    }
}
