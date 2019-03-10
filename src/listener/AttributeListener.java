package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListener implements HttpSessionAttributeListener,
        ServletContextAttributeListener, ServletRequestAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("Session attribute added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("Session attribute removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("Session attribute replaced");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("Context attribute added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("Context attribute removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("Context attribute replaced");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Request attribute added");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("Request attribute removed");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Request attribute replaced");
    }

}
