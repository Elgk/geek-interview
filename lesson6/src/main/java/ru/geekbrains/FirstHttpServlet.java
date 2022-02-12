package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/first_http_servlet")
public class FirstHttpServlet extends HttpServlet {
    // по функции сопоставимо с контроллером MVC-модели
    @Override
    public void init() throws ServletException {
        Object object = getServletContext().getAttribute("some object");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  req.setAttribute("some data", new ArrayList<>()); // напр, для передачи этой информации на другой сервлет

        resp.setContentType("text/html");
        resp.getWriter().println("<h1> Привет from http servlet</h1>");
        req.getRequestDispatcher("/first_servlet").forward(req, resp);
        // forward - перенаправляет на другой сервлет и там остается управление приложением
        // include - перенаправляет на другой сервлет, тот что-то записывает в responce и возвращает управление обратно
    }
}
