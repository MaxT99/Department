package app.model;

import net.sf.oval.constraints.Length;
import net.sf.oval.constraints.NotEmpty;
import net.sf.oval.constraints.RegEx;


public class Department {


    private int id;

    @NotEmpty(message = "Field 'Name' has not to be empty")
    private String name;


    @NotEmpty(message = "field 'Phone' has  to be filled")
    @RegEx(pattern = "^((\\+?380)[0-9]{9})$", message = "this format phone has not to be rely")
    private String phone;

    @RegEx(pattern ="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "This format for email has not to be rely")
    private String email;

    @Length(min = 5, max = 50, message = "Input text between 5 and 50 symbols")
    @NotEmpty(message = "Field 'Address'  has to be filled")
    private String address;

    @Length(min = 5, max = 150, message = "Input text between 5 and 150 symbols")
     @NotEmpty(message = "Field 'Description' has to be filled")
    private String description;

    public Department() {
    }

    public Department(String name, String phone, String email, String address, String description) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.description = description;
    }

    public Department(int id, String name, String phone, String email, String address, String description) {

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.description = description;
    }

    public int getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
