package database;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoJDBC implements CustomerDao {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM cliente"
            + " WHERE id_cliente=?";
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre, apellido,email,telefono,saldo) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?,email=?,telefono=?, saldo=?  "
            + "WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";

    @Override
    public List<Customer> List() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Customer customer = null;
        List<Customer> customers = new ArrayList<>();
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                Double saldo = rs.getDouble("saldo");
                customer = new Customer(idCliente, nombre, apellido, email, telefono, saldo);
                customers.add(customer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionDB.close(rs);
            ConnectionDB.close(stmt);
            ConnectionDB.close(conn);
        }
        return customers;
    }

    @Override
    public Customer findById(Customer customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;         
        try {
            conn= ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, customer.getIdCliente());
            rs=stmt.executeQuery();
          //  rs.absolute(1); //First element
            while (rs.next()){
            customer.setNombre(rs.getString("nombre"));
            customer.setApellido(rs.getString("apellido"));
            customer.setEmail(rs.getString("email"));
            customer.setTelefono(rs.getString("telefono"));
            customer.setSaldo(rs.getDouble("saldo"));            
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionDB.close(rs);
            ConnectionDB.close(stmt);
            ConnectionDB.close(conn);
        }
        return customer;
    }
    
    @Override
    public int Insert(Customer customer){
        Connection conn = null;
        PreparedStatement stmt = null;   
        int rows = 0;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, customer.getNombre());
            stmt.setString(2, customer.getApellido());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getTelefono());
            stmt.setDouble(5, customer.getSaldo());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(conn);
        }
        return rows;
    }
    
        @Override
    public int Update(Customer customer){
        Connection conn = null;
        PreparedStatement stmt = null;   
        int rows = 0;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, customer.getNombre());
            stmt.setString(2, customer.getApellido());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getTelefono());
            stmt.setDouble(5, customer.getSaldo());
            stmt.setInt(6, customer.getIdCliente());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(conn);
        }
        return rows;
    }
    
      @Override
    public int Delete(Customer customer){
        Connection conn = null;
        PreparedStatement stmt = null;   
        int rows = 0;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, customer.getIdCliente());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(conn);
        }
        return rows;
    }
}
