package java.com.mobiletrain.web;

import com.mobiletrain.domain.Contact;
import com.mobiletrain.service.ContactService;
import com.mobiletrain.service.impl.ContactServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_broker")
public class UpdateBrokerServlet extends HttpServlet {
    private ContactService service;
    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        this.service = context.getBean("contactService",ContactService.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收数据
        String contactId = request.getParameter("id");

        // 2. 处理数据
        Contact contact = service.queryById(contactId);

        // 3. 响应数据
        request.setAttribute("contact", contact);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
