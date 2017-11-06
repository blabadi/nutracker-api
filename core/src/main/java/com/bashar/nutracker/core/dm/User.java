package com.bashar.nutracker.core.dm;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bashar on 2017-11-05.
 */
@Document(collection = "users")
public class User {
    private String id;
    private String name;
    private String password;
    private boolean active;
    private Date createdAt;
    private Set<String> roles = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", active=").append(active);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }


}
