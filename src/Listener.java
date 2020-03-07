import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

public class Listener implements ServletContextListener {
    public  Queue<String> queue = new LinkedList<String>();


    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // web停止时执行
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        //web 启动时执行

        Timer timer = new Timer();
        timer.schedule(new Task(),0,10000);
    }

}