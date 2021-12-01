package p;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Hello", value = {"/"})
public class App extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GiftWrapper wrappedPresent = new SantasWrapperFactory().wrap(new JavaBook("Java Concurrency in Practice"));
        resp.getWriter().println(wrappedPresent.unwrap().toString());
    }

}