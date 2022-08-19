package com.example.entities;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String meta;

    Employee() {}

    public Employee(String firstName,String lastName, String role, String meta) {
        this.firstName = firstName;
        this.lastName= lastName;
        this.role = role;
        this.meta=meta;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {return this.lastName;}

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && (Objects.equals(this.firstName, employee.firstName )&& Objects.equals(this.firstName, employee.firstName ))
                && Objects.equals(this.role, employee.role);
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", meta='" + meta + '\'' +
                '}';
    }
}
