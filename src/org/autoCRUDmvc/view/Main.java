package org.autoCRUDmvc.view;

import org.autoCRUDmvc.controller.OrderController;
import org.autoCRUDmvc.dao.Parameter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner cs = new Scanner(System.in);

    public static void main (String[] args) {
        OrderController controller = new OrderController();

        int menuOption = 0;

        do {
            printMenu();
            try {

                menuOption = cs.nextInt();
                clearBuffer();

            } catch (InputMismatchException e) {
                clearBuffer();
            }

            switch (menuOption) {
                case 1:
                    System.out.println("============| NEW ITEM |============");
                    System.out.println("Name:");
                    String name = cs.nextLine();
                    System.out.println("Type:");
                    String type = cs.nextLine();
                    System.out.println("Value:");
                    String value = cs.nextLine();
                    System.out.println("Stock:");
                    String stock = cs.nextLine();
                    try {
                        controller.insert(name, type, Double.parseDouble(value), Short.parseShort(stock));

                    } catch (NumberFormatException e) {
                        System.out.println("One or more inputs aren't valid.");
                    }
                    break;

                case 2:
                    System.out.println("============| ITEMS |============");
                    controller.list();
                    break;

                case 3:
                    System.out.println("The ID of the item to alter:");
                    String id = cs.nextLine();
                    System.out.println("Parameter you would like to change:");
                    parameters();
                    int parameterOption = 0;
                    try {
                        parameterOption = cs.nextInt();
                        clearBuffer();

                    } catch (InputMismatchException e) {
                        clearBuffer();
                    }

                    Parameter choice = choice(parameterOption);
                    if (choice == Parameter.Invalid) break;

                    System.out.println("New parameter:");
                    String parameter = cs.nextLine();

                    switch (choice) {
                        case Name, Type:
                            try {
                                controller.alter(Integer.parseInt(id), parameter, choice);
                            } catch (NumberFormatException e) {
                                System.out.println("One or more inputs aren't valid.");
                            }
                            break;

                        case Value:
                            try {
                                controller.alter(Integer.parseInt(id), Double.parseDouble(parameter), choice);
                            } catch (NumberFormatException e) {
                                System.out.println("One or more inputs aren't valid.");
                            }
                            break;

                        case Stock:
                            try {
                                controller.alter(Integer.parseInt(id), Short.parseShort(parameter), choice);
                            } catch (NumberFormatException e) {
                                System.out.println("One or more inputs aren't valid.");
                            }
                            break;
                    }
                    break;

                case 4:
                    System.out.println("The ID of the item to remove:");

                    try {

                        id = cs.nextLine();
                        controller.remove(Integer.parseInt(id));

                    } catch (NumberFormatException e) {
                        System.out.println("ID must be a number.");
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Option is invalid.");
                    break;
            }

        } while (menuOption != 5);
    }

    public static void printMenu() {
        System.out.println("=================| MENU |=================");
        System.out.println("1 - Register Item");
        System.out.println("2 - List Items");
        System.out.println("3 - Alter Item");
        System.out.println("4 - Delete Item");
        System.out.println("5 - Exit");
    }

    public static void parameters() {
        System.out.println("1 - Name");
        System.out.println("2 - Type");
        System.out.println("3 - Value");
        System.out.println("4 - Stock");
    }

    public static Parameter choice(int choice) {
        switch (choice) {
            case 1:
                return Parameter.Name;

            case 2:
                return Parameter.Type;

            case 3:
                return Parameter.Value;

            case 4:
                return Parameter.Stock;

            default:
                System.out.println("Option is invalid.");
                return Parameter.Invalid;
        }
    }

    public static void clearBuffer() {
        cs.nextLine();
    }
}
