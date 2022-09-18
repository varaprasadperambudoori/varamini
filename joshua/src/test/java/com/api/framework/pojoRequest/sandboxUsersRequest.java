package com.api.framework.pojoRequest;

public class sandboxUsersRequest {
    private String firstName;
    private String lastName;
    private Boolean active;
    private String email;
    private String phone;
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
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{" +
                "first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", active=" + active +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
