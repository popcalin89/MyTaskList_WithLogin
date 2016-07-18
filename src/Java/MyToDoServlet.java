import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by caly on 7/17/2016.
 */
public class MyToDoServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) {


        System.out.println("service called...");
        String myValue  = request.getParameter("myValue");
        System.out.println("myvalue venita din ui este:"+myValue);

    }
}
