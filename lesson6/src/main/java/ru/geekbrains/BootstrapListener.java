package ru.geekbrains;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {
// напрмер, используется для инициализации ресурсов, которые необходимы приложению
// context - синоним веб-приложения, вся работа с сервером приложений идет через context

    @Override // действия сразу после того, как сервер запустился
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("some object", new Object());
    }
}
