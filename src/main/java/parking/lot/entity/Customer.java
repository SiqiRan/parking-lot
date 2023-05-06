package parking.lot.entity;

public class Customer {
    String name;
    String identification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Customer(String name, String identification) {
        this.name = name;
        this.identification = identification;
    }
}
