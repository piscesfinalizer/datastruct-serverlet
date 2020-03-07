import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;



@WebServlet(name = "Bank queue")
public class Bankqueue extends HttpServlet {
    public static Queue<Visitor> queue = new LinkedList<Visitor>();//模拟运作的队伍
    public static Visitor ready;//轮到的客户


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应内容类型
        response.setContentType("text/json;charset = utf-8");
        //实例化输出流对象
        PrintWriter printWriter = response.getWriter();

        switch(Integer.parseInt(request.getParameter( "parameter1"))){
            case 1://新人入队
                String newid = request.getParameter("parameter2");
                Visitor newvisitor = new Visitor(newid,this.queue.size()+1);
                this.queue.offer(newvisitor);
                break;
            case 2://查询队伍情况
                String queryid = request.getParameter("parameter2");
                Queue<Visitor> copy = new LinkedList<Visitor>();
                if(queue.size()>0) {
                    for (Visitor s : this.queue) {
                        Visitor m = new Visitor(s.id, s.order);
                        copy.offer(m);
                    }

                    Visitor query;
                    query = copy.poll();
                    while ((!query.id.equals(queryid)) && copy.size() > 0) {
                        query = copy.poll();
                    }
                    printWriter.print("您排在第"+query.order+"位,");
                }

                printWriter.println("队伍有"+queue.size() + "人");
                break;

        }
    }



}
