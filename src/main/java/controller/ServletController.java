package controller;

import database.CustomerDaoJDBC;
import domain.Customer;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("ServletController")
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Customer> customers = new CustomerDaoJDBC().List();
        int totalCustomers = customers.size();
        request.setAttribute("customers", customers);
        request.setAttribute("totalBalance", this.calculateBalanceTotal(customers));
        request.setAttribute("totalCustomers", totalCustomers);
        request.getRequestDispatcher("customers.jsp").forward(request, response);
    }

    private double calculateBalanceTotal(List<Customer> customers) {
        double totalBalance = 0;
        for (Customer c : customers) {
            totalBalance += c.getSaldo();
        }
        return totalBalance;
    }

}
