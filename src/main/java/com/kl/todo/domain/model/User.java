/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kl.todo.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author kevin
 */

@Entity
public class User {

    private static final long serialVersionUID =       -8712872385957386182L;

    private long id;
    private String username;
    private String password;
    private String email;

    public void setId(long id) {
        this.id = id;
    }

    @Id
    public long getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private int accessLevel;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "access_level")
    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Column(name = "username")
    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
