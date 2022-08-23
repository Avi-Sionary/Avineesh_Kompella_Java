package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );
    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<Customer>();

        for (int i = 0; i < customerData.size(); i++) {

            boolean unique = true; // To check if current customer we're looking at hasn't already been added
            int id = Integer.parseInt(customerData.get(i)[0]);
            String name = customerData.get(i)[1];

            AccountRecord a = new AccountRecord();
            int charge = Integer.parseInt(customerData.get(i)[2]);
            String chargeDate = customerData.get(i)[3];
            a.setCharge(charge);
            a.setChargeDate(chargeDate);

            for (Customer c : customerList) {
                if (c.getId() == id) { // Customer already exists in CustomerList
                    unique = false; // no need to add to CustomerList
                    c.addCharge(a); // still need to add charge
                    break;
                }
            }

            if (unique) { // Customer not in CustomerList yet -> we can create and add it
                Customer customer = new Customer();
                customer.setId(id);
                customer.setName(name);
                customer.addCharge(a);
                customerList.add(customer);
            }

        }

        System.out.println("Positive accounts:");
        for (Customer c : customerList) {
            if (c.getBalance() > 0) {
                System.out.println(c);
                System.out.println("\n");
            }
        }

        System.out.println("Negative accounts:");
        for (Customer c : customerList) {
            if (c.getBalance() <= 0) {
                System.out.println(c);
                System.out.println("\n");
            }
        }
    }
}
