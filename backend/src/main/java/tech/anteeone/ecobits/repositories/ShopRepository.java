package tech.anteeone.ecobits.repositories;

import tech.anteeone.ecobits.models.Order;
import tech.anteeone.ecobits.services.JDBCConnectionService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShopRepository extends Repository implements CrudRepository<Order>{

    @Override
    public ArrayList<Order> getAll() {
        ArrayList<Order> list = new ArrayList();
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT id,title,description,bitsprice from orders");
            rs = ps.executeQuery();
            while (rs.next()){
                Integer idSQL = rs.getInt(1);
                String titleSQL = rs.getString(2);
                String descriptionSQL = rs.getString(3);
                Integer bitsPriceSQL = rs.getInt(4);
                list.add(new Order(idSQL,titleSQL,descriptionSQL,bitsPriceSQL));
            }
        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return list;
    }

    @Override
    public boolean create(Order entity) {
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("INSERT INTO orders (title, description, bitsprice) values (?,?,?)");
            ps.setString(1,entity.getTitle());
            ps.setString(2,entity.getDescription());
            ps.setInt(3,entity.getBitsPrice());
            rs = ps.executeQuery();

        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("DELETE FROM orders WHERE id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            return true;

        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return false;
    }

    @Override
    public Order getByParameter(Object object) {
        return null;
    }

    public static ShopRepository getInstance() {
        return new ShopRepository();
    }
}
