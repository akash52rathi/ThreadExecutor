import java.lang.reflect.Executable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task implements Runnable{

    private String name;
    public  Task(String name)
    {
        this.name= name;
    }

    @Override
    public void run() {

        try {
            for(int i=0;i<5;i++)
            {
                if(i==0)
                {
                    Date d = new Date();
                    SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");

                    System.out.println("Intilization of Task "  + name + " " + sd.format(d));
                }
                else
                {

                    Date d = new Date();
                    SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");

                    System.out.println("Execution of Task "  + name + " " + sd.format(d));

                }

            }

            System.out.println("Completed Task  " +name);

        }
        catch (Exception e)
        {

        }

    }
}

public class Main  {

    static  final int MAX_T =3;
    public static void main(String[] args) {

        Runnable r1 = new Task("R1");
        Runnable r2 = new Task("R2");
        Runnable r3 = new Task("R3");
        Runnable r4 = new Task("R4");


        ExecutorService pool = Executors.newFixedThreadPool(1);
      //  ExecutorService pool = Executors.newCachedThreadPool();  (Threads which are not running for last 60 seconds will be terminated)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.shutdown();

    }
}
