package com.example.jobportal.demojobportal;

import org.springframework.stereotype.Repository;

// Importing the employees class to use the defined properties in this class
import com.example.jobportal.demojobportal.Employees;

@Repository
// Class to create a list of employees
public class EmployeeDAO {

    private static Employees list = new Employees();

    // This static block is executed before executing the main block
    static
    {
        // Creating a few employees and adding them to the list
        list.getEmployeeList().add(
                new Employee(
                        1,
                        "Prem",
                        "Tiwari",
                        "premtiwari@gmail.com"));

        list.getEmployeeList().add(
                new Employee(
                        2, "Vikas",
                        "Kumar",
                        "vikaskumar@gmail.com"));

        list.getEmployeeList().add(
                new Employee(
                        3, "Ritesh",
                        "Ojha",
                        "riteshojha@gmail.com"));
    }

    // Method to return the list
    public Employees getAllEmployees() {
        return list;
    }

    // Method to add an employee to the employees list
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }

    // Method to change an employee
    public void changeEmployee(int id, Employee body) {
        int size = list.getEmployeeList().size();
        Employees mylist = list;
        for(int i = 0; i < size; i++) {
            if (mylist.getEmployeeList().get(i).getId().equals(id)) {
                if(body.getFirstName() != null)
                    mylist.getEmployeeList().get(i).setFirstName(body.getFirstName());
                if(body.getLastName() != null)
                    mylist.getEmployeeList().get(i).setLastName(body.getLastName());
                break;
            }
        }
    }

    // Method to delete an employee record
    public void deleteEmployeeRecord(int id) {
        int size = list.getEmployeeList().size();
        Employees mylist = list;
        for(int i = 0; i < size; i++) {
            if(mylist.getEmployeeList().get(i).getId().equals(id)) {
                mylist.getEmployeeList().remove(i);
                break;
            }
        }
    }
}

