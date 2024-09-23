package fr.g123k.deviceapps;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class AsyncWork {

    private final ThreadPoolExecutor threadPoolExecutor;

    AsyncWork() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        this.threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, workQueue);
    }

    void run(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    void stop() {
        threadPoolExecutor.shutdown();
    }
}
