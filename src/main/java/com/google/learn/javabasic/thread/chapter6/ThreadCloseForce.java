package com.google.learn.javabasic.thread.chapter6;

public class ThreadCloseForce {
    private static class Worker extends Thread {
        private boolean flag = true;
        @Override
        public void run() {
            while (true) {
                /*try {
                    Thread.sleep(10_000L);
                } catch (InterruptedException e) {
                    System.out.println("break thread");
                    break; // return
                }*/

                /*if (Thread.interrupted()) {
                    System.out.println("break thread");
                    break;
                }
                // TODO: 2019/8/3*/

                while (flag) {
                    // 长耗时操作，读文件或者连接网络，不会感知flag的变化 
                }
            }
        }

        /*public void shutDown() {
            this.start = false;
        }*/
    }


    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();
    }
}
