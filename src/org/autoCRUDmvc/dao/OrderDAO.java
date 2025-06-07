package org.autoCRUDmvc.dao;

import org.autoCRUDmvc.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {

    public void insert(Order o) {
        String sql = "INSERT INTO items (ItemName, ItemType, ItemValue, ItemStock) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = ServerConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, o.getName());
            stmt.setString(2, o.getType());
            stmt.setDouble(3, o.getValue());
            stmt.setShort(4, o.getStock());
            stmt.executeUpdate();
            System.out.println("Item successfully registered.");

        } catch (SQLException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    public void alter(int id, String parameter, Parameter p) {
        switch (p) {
            case Name:
                String sql = "UPDATE items SET ItemName = ? WHERE ItemID = ?";

                try {
                    Connection conn = ServerConnection.connect();
                    PreparedStatement stmt = conn.prepareStatement(sql);

                    stmt.setString(1, parameter);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();

                } catch (SQLException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }

                break;

            case Type:
                sql = "UPDATE items SET ItemType = ? WHERE ItemID = ?";

                try {
                    Connection conn = ServerConnection.connect();
                    PreparedStatement stmt = conn.prepareStatement(sql);

                    stmt.setString(1, parameter);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                    System.out.println("Parameter altered successfully.");

                } catch (SQLException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }

                break;
        }
    }

    public void alter(int id, double parameter, Parameter p) {
        switch (p) {
            case Value:
                String sql = "UPDATE items SET ItemValue = ? WHERE ItemID = ?";

                try {
                    Connection conn = ServerConnection.connect();
                    PreparedStatement stmt = conn.prepareStatement(sql);

                    stmt.setDouble(1, parameter);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                    System.out.println("Parameter altered successfully.");

                } catch (SQLException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }

                break;
        }
    }

    public void alter(int id, short parameter, Parameter p) {
        switch (p) {
            case Stock:
                String sql = "UPDATE items SET ItemStock = ? WHERE ItemID = ?";

                try {
                    Connection conn = ServerConnection.connect();
                    PreparedStatement stmt = conn.prepareStatement(sql);

                    stmt.setShort(1, parameter);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                    System.out.println("Parameter altered successfully.");

                } catch (SQLException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }

                break;
        }
    }

    public void remove(int id) {
        String sql = "DELETE FROM items WHERE ItemID = ?";

        try {
            Connection conn = ServerConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("Item successfully deleted.");
    }

    public void list() {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM items";

        try {
            Connection conn = ServerConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Order o = new Order(
                        rs.getInt("ItemID"),
                        rs.getString("ItemName"),
                        rs.getString("ItemType"),
                        rs.getDouble("ItemValue"),
                        rs.getShort("ItemStock")
                );
                list.add(o);
            }

            System.out.println("ID -  Name  -  Type  -  Value  -  Stock");
            for (Order o : list) {
                System.out.println(o.getID() + "    "
                        + o.getName() + "    "
                        + o.getType() + "    "
                        + o.getValue() + "    "
                        + o.getStock());
            }

        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
