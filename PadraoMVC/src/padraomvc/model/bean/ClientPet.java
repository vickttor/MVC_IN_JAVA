package padraomvc.model.bean;

public class ClientPet {

    private int id;
    private int idC;
    private int idP;
    private String obs;
    private Object pet;
    private Object client;

    public ClientPet(int id) {
        this.id = id;
    }

    public ClientPet(String obs) {
        this.obs = obs;
    }

    public ClientPet(int idC, int idP, String obs) {
        this.idC = idC;
        this.idP = idP;
        this.obs = obs;
    }

    public ClientPet(int id, int idC, int idP, String obs) {
        this.id = id;
        this.idC = idC;
        this.idP = idP;
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

    public Object getPet() {
        return pet;
    }

    public void setPet(Object pet) {
        this.pet = pet;
    }

    public Object getClient() {
        return client;
    }

    public void setClient(Object client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientPet{" + "id=" + id + ", idC=" + idC + ", idP=" + idP + ", obs=" + obs + '}';
    }
}
