package com.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class User {
    @JsonIgnore
    private String token;
    private boolean active;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    @JsonIgnore
    private boolean uses_parent_account;
    @JsonIgnore
    private boolean corporate_card_holder;
    @JsonIgnore
    private String created_time;
    @JsonIgnore
    private String last_modified_time;
    @JsonIgnore
    private List<String> metadata;
    @JsonIgnore
    private String account_holder_group_token;
    @JsonIgnore
    private String status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public boolean isUses_parent_account() {
        return uses_parent_account;
    }

    public void setUses_parent_account(boolean uses_parent_account) {
        this.uses_parent_account = uses_parent_account;
    }

    public boolean isCorporate_card_holder() {
        return corporate_card_holder;
    }

    public void setCorporate_card_holder(boolean corporate_card_holder) {
        this.corporate_card_holder = corporate_card_holder;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getLast_modified_time() {
        return last_modified_time;
    }

    public void setLast_modified_time(String last_modified_time) {
        this.last_modified_time = last_modified_time;
    }

    public List<String> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<String> metadata) {
        this.metadata = metadata;
    }

    public String getAccount_holder_group_token() {
        return account_holder_group_token;
    }

    public void setAccount_holder_group_token(String account_holder_group_token) {
        this.account_holder_group_token = account_holder_group_token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
