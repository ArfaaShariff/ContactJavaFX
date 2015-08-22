package sample;

/**
 * Created by ASUS on 18-Aug-15.
 */
public class Product {

    private String name;
    private String phone;
    private String email;

    public Product() {
        this.name = " ";
        this.phone = " ";
        this.email = " ";


    }

    public Product(String name, String price, String quantity) {
        this.name = name;
        this.phone = price;
        this.email = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

