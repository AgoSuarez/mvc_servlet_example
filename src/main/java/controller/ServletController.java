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
import javax.servlet.http.HttpSession;

@WebServlet("ServletController")
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    editCustomer(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
            }
        } else {
            this.requestListCustomer(request, response);
        }
    }

    private void requestListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new CustomerDaoJDBC().List();
        int totalCustomers = customers.size();
        //Option 1
        HttpSession session = request.getSession();
        session.setAttribute("customers", customers);
        session.setAttribute("totalBalance", this.calculateBalanceTotal(customers));
        session.setAttribute("totalCustomers", totalCustomers);
        response.sendRedirect("customers.jsp");

    }

    private double calculateBalanceTotal(List<Customer> customers) {
        double totalBalance = 0;
        for (Customer c : customers) {
            totalBalance += c.getSaldo();
        }
        return totalBalance;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "create":
                    createCustomer(request, response);
                    break;
                case "update":
                    updateCustomer(request, response);
                    break;
            }
        }
        this.requestListCustomer(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Double balance = Double.valueOf(request.getParameter("balance"));
        Customer customer = new Customer(name, surname, email, phone, balance);
        int result = new CustomerDaoJDBC().Insert(customer);
        System.out.println("Customers add(" + result + ") " + customer);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idCustomer"));
        Customer customer = new CustomerDaoJDBC().findById(new Customer(id));
        request.setAttribute("customer", customer);
        String jspEdit = "/WEB-INF/pages/customer/editCustomer.jsp";
        request.getRequestDispatcher(jspEdit).forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomer"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Double balance = Double.valueOf(request.getParameter("balance"));
        Customer customer = new Customer(id, name, surname, email, phone, balance);
        int result = new CustomerDaoJDBC().Update(customer);

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Borrando el cliente: " + request.getParameter("idCustomer"));
        int id = Integer.parseInt(request.getParameter("idCustomer"));
        int delete= new CustomerDaoJDBC().Delete(new Customer(id));
        this.requestListCustomer(request, response);
    }

}
