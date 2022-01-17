package com.example.jobportal.service;

import com.example.jobportal.model.Employee;
import com.example.jobportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    public List<Employee> getAllEmployees() { return this.employeeRepository.findAll(); }

    //add single employee
    public void saveEmployee(Employee employee) { employeeRepository.save(employee); }

    //add list of employees
    public void saveEmployees(List<Employee> employees) { this.employeeRepository.saveAll(employees); }

    //delete employee by id
    public void deleteEmployeeById(int id) { this.employeeRepository.deleteById(id); }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    //update employee details
    public Employee updateEmployeeDetails(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getEmp_id()).orElse(null);
        emp.setEmp_id(employee.getEmp_id());
        emp.setFirst_name(employee.getFirst_name());
        emp.setLast_name(employee.getLast_name());
        emp.setEmail(employee.getEmail());
        emp.setRole(employee.getRole());
        return this.employeeRepository.save(emp);
    }

    //send an email
    public void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("myemail@gmail.com", "password");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("myemail@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("myemail@gmail.com"));
        msg.setSubject("Sample Email Subject");
        msg.setContent("This is the text for sample email.", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("This is the text for sample email.", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}
