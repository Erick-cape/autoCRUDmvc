package org.autoCRUDmvc.controller;

import org.autoCRUDmvc.dao.Parameter;
import org.autoCRUDmvc.model.Order;

public class OrderController {

    public void insert(String name, String type, double value, short stock) {
        Order o = new Order(name, type, value, stock);
        o.insert(o);
    }

    public void alter(int id, String parameter, Parameter p) {
        Order o = new Order();
        o.alter(id, parameter, p);
    }

    public void alter(int id, double parameter, Parameter p) {
        Order o = new Order();
        o.alter(id, parameter, p);
    }

    public void alter(int id, short parameter, Parameter p) {
        Order o = new Order();
        o.alter(id, parameter, p);
    }

    public void remove(int id) {
        Order o = new Order();
        o.remove(id);
    }

    public void list() {
        Order o = new Order();
        o.list();
    }
}
