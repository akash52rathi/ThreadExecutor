import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WhyNotFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<List<Integer>> future =service.submit(()->{

            System.out.println("Thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.asList(1, 2, 3, 4);
        });

        System.out.println("Akash " + Thread.currentThread().getName());
        List<Integer> integers = future.get();

        System.out.println(integers + " " +Thread.currentThread().getName());
        System.out.println("Akash2");

    }
}
