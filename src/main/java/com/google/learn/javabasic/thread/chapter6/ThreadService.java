package com.google.learn.javabasic.thread.chapter6;

public class ThreadService {
    private Thread executeThread;
    private boolean finished = false;

    public void execute(Runnable task) {
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);

                runner.start();

                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
                    ///e.printStackTrace();
                }
            }
        };
        executeThread.start();

    }

    public void shutDown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("ren wu chao shi");
                executeThread.interrupt();
                break;
            }

            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("zhi xing xian cheng bei da duan");
                break;
                //e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();

        threadService.execute(() -> {
            // load very heavy resource
            /*while (true) {

            }*/
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadService.shutDown(10_000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
