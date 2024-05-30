import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {
    public PrimitiveServlet() {
    }

    public void init(ServletConfig var1) throws ServletException {
        System.out.println("init");
    }

    private String responseToByte(String status) {
        return new StringBuilder().append("HTTP/1.1").append(" ")
                .append(status).append(" ")
                .append("描述").append("\r\n\r\n")
                .toString();
    }

    public void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException {

        System.out.println("from service");

        PrintWriter var3 = var2.getWriter();
        var3.write(responseToByte("200"));
        var3.println("Hello. Roses are red.");
        var3.print("Violets are blue.");

    }

    public void destroy() {
        System.out.println("destroy");
    }

    public String getServletInfo() {
        return null;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

}
