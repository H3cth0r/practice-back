package com.zentinel.resume.resume.dto;

public class CreateUserInfoDto {
    private String name;
    private Boolean active;
    private String email;
    private String secondEmail;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getEmail() { return email; }
    public void setMail(String email) { this.email = email; }

    public String getSecondEmail() { return secondEmail; }
    public void setSecondEmail(String secondEmail) { this.secondEmail = secondEmail; }

}
