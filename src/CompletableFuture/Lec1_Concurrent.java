package CompletableFuture;

public class Lec1_Concurrent {
    public static void main(String[] args) throws InterruptedException {
        // 스레드와 프로세스 차이
//        Thread1 thread1 = new Thread1();
//        thread1.start();

        // 2. Runnable 구현
//        Thread thread2 = new Thread((new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread: " + Thread.currentThread().getName());
//            }
//        }));

        // 3. Runnable 구현 + lambda
        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                // 자고 있는 애를 깨우면
//                e.printStackTrace();
//            }

            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit!");
                    return;
                }
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        Thread.sleep(3000L);
        thread.interrupt(); // 깨우기
        
        thread.join(); // thread 끝날 때까지 기다림

    }

    // 1. Thread 상속
    static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }


}
