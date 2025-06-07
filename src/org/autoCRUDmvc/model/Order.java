package org.autoCRUDmvc.model;

import org.autoCRUDmvc.dao.OrderDAO;
import org.autoCRUDmvc.dao.Parameter;

public class Order {
    private int id;
    private String name;
    private String type;
    private double value;
    private short stock;

    public Order() {
        this.id = 0;
        this.name = " ";
        this.type = " ";
        this.value = 0d;
        this.stock = 0;
    }

    public Order(String name, String type, double value, short stock) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.stock = stock;
    }

    public Order(int id, String name, String type, double value, short stock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.stock = stock;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setStock(short stock) {
        this.stock = stock;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public short getStock() {
        return stock;
    }

    public void insert(Order o) {
        OrderDAO oDAO = new OrderDAO();
        oDAO.insert(o);
    }

    public void alter(int id, String parameter, Parameter p) {
        OrderDAO oDAO = new OrderDAO();
        oDAO.alter(id, parameter, p);
    }

    public void alter(int id, double parameter, Parameter p) {
        OrderDAO oDAO = new OrderDAO();
        oDAO.alter(id, parameter, p);
    }

    public void alter(int id, short parameter, Parameter p) {
        OrderDAO oDAO = new OrderDAO();
        oDAO.alter(id, parameter, p);
    }

    public void remove(int id) {
        OrderDAO oDAO = new OrderDAO();
        oDAO.remove(id);
    }

    public void list(){
        OrderDAO oDAO = new OrderDAO();
        oDAO.list();
    }
}
