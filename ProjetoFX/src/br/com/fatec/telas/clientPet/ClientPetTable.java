/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.telas.clientPet;

/**
 *
 * @author vickttor
 */
public class ClientPetTable {
    
    private int id;
    private int idC;
    private int idP;
    private String obs;
    private String clientName;
    private String petName;

    public ClientPetTable(int id, int idC, String clientName, int idP, String petName, String obs) {
        this.id = id;
        this.idC = idC;
        this.idP = idP;
        this.clientName = clientName;
        this.petName = petName;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }



    @Override
    public String toString() {
        return "ClientPet{" + "id=" + id + ", idC=" + idC + ", idP=" + idP + ", obs=" + obs + '}';
    }
    
}
