package ex06.pyrmont.startup;

import ex06.pyrmont.core.*;
import org.apache.catalina.*;
import org.apache.catalina.connector.http.HttpConnector;

public final class Bootstrap {
    public static void main(String[] args) {


        Wrapper wrapper1 = new SimpleWrapper();
        wrapper1.setName("Primitive");
        wrapper1.setServletClass("PrimitiveServlet");

        Wrapper wrapper2 = new SimpleWrapper();
        wrapper2.setName("Modern");
        wrapper2.setServletClass("ModernServlet");

        Context context = new SimpleContext();
        context.addChild(wrapper1);
        context.addChild(wrapper2);

        Mapper mapper = new SimpleContextMapper();
        mapper.setProtocol("http");
        context.addMapper(mapper);

        LifecycleListener listener = new SimpleContextLifecycleListener();
        ((Lifecycle) context).addLifecycleListener(listener);

        Loader loader = new SimpleLoader();
        context.setLoader(loader);


        // context.addServletMapping(pattern, name);
        context.addServletMapping("/Primitive", "Primitive");
        context.addServletMapping("/Modern", "Modern");

        Connector connector = new HttpConnector();
        HttpConnector connector1 = (HttpConnector) connector;
        connector1.setPort(18080);

        connector.setContainer(context);
        try {
            connector.initialize();
            ((Lifecycle) connector).start();
            ((Lifecycle) context).start();

            // make the application wait until we press a key.
            System.in.read();
            ((Lifecycle) context).stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}