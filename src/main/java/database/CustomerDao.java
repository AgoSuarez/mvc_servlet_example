package database;

import domain.Customer;
import java.util.List;


public interface CustomerDao {
    public List<Customer> List();
    public Customer findById(Customer customer);
    public int Insert(Customer customer);
    public int Update(Customer customer);
    public int Delete(Customer customer);
    
}
