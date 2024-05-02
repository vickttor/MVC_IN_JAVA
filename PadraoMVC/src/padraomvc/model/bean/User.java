/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.bean;

import java.io.Serializable;

/**
 *
 * @author Vickttor
 */
public class User implements Serializable{
    
    private int id;
    private String login;
    private String password;
    private String status;
    private String type;

    public User(int id) {
        this.id = id;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public User(String login) {
        this.login = login;
    }

    public User(String login, String password, String status, String type) {
        this.login = login;
        this.password = password;
        this.status = status;
        this.type = type;
    }

    public User(int id, String login, String password, String status, String type) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", password=" + password + ", status=" + status + ", type=" + type + '}';
    }
    
    
    
    
}
