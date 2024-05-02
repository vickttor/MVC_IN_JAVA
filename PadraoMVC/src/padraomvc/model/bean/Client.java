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
public class Client implements Serializable {
    
    private int id;
    private String name;
    private String cpf;
    private String tel;
    private String address;

    public Client(int id) {
        this.id = id;
    }

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, String cpf, String tel, String address) {
        this.name = name;
        this.cpf = cpf;
        this.tel = tel;
        this.address = address;
    }

    public Client(int id, String name, String cpf, String tel, String address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.tel = tel;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", cpf=" + cpf + ", tel=" + tel + ", address=" + address + '}';
    }
    
    
    
    
}
