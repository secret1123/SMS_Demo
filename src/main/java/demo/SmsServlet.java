package demo;

import com.aliyuncs.exceptions.ClientException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingfei.net@gmail.com
 * 7/27/17 09:14
 * https://github.com/thu/SMS/
 */
@WebServlet(urlPatterns = "/sms")
public class SmsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mobileNumbers = req.getParameter("mobileNumbers");
        System.out.println(mobileNumbers);
        mobileNumbers = mobileNumbers.replaceAll("\\s+", ",");
        System.out.println(mobileNumbers);
        try {
            SmsDemo.send(mobileNumbers);
        } catch (ClientException | InterruptedException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("index.jsp");
    }
}
