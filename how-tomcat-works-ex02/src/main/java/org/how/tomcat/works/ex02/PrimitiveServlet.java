// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.how.tomcat.works.ex02.constant.HttpVersionConstant;
import org.how.tomcat.works.ex02.enums.HttpStatusEnum;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {
    public PrimitiveServlet() {
    }

    public void init(ServletConfig var1) throws ServletException {
        System.out.println("init");
    }

    private String responseToByte(HttpStatusEnum status) {
        return new StringBuilder().append(HttpVersionConstant.HTTP_1_1).append(" ")
                .append(status.getStatus()).append(" ")
                .append(status.getDesc()).append("\r\n\r\n")
                .toString();
    }

    public void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException {

        System.out.println("from service");

        PrintWriter var3 = var2.getWriter();
        var3.write(responseToByte(HttpStatusEnum.OK));
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
