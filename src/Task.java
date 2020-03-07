import java.util.TimerTask;
public class Task extends TimerTask {

    public void run()
    {
        if(Bankqueue.queue.size() > 0) {
            //队首出队，所有人在队伍中的的次序-1
            Bankqueue.ready = Bankqueue.queue.poll();
            for(Visitor s:Bankqueue.queue){
                s.order--;
            }
        }
    }

}