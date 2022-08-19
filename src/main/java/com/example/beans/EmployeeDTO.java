package com.example.beans;

public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;

    private String meta;

    public EmployeeDTO() {}

    public EmployeeDTO(String firstName, String lastName, String role,String meta) {
        this.firstName = firstName;
        this.lastName= lastName;
        this.role = role;
        this.meta=meta;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }
}
