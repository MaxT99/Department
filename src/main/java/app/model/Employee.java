package app.model;

import net.sf.oval.constraints.Length;
import net.sf.oval.constraints.NotEmpty;
import net.sf.oval.constraints.RegEx;

public class Employee {

    private int id;

    @NotEmpty(message = "Name has to be filled")
    private String firstname;

    @NotEmpty(message = "Lastname has to be filled")
    private String lastname;
    @NotEmpty(message = "Field 'Age' has to be filled")
    @RegEx(pattern ="^(?:[2-5][0-9])$", message = "Enter number from 20 to 59" )
    private String age;

    @NotEmpty(message = "field 'Phone' has  to be filled")
    @RegEx(pattern = "^((\\+?380)[0-9]{9})$", message = "this format phone has not to be rely")
    private String phone;
    @RegEx(pattern ="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "This format for email has not to be rely")
    private String email;

    @NotEmpty(message = "Position has to be filled")
    @Length(min = 5, max = 150, message = "Input text between 5 and 150 symbols")
    private String position;
    private int depId;

    public Employee(){ }

    public Employee(String firstname, String lastname, String age, String phone, String email, String position, int depId){

        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.depId = depId;
    }
    public Employee(int id, String firstname, String lastname, String age , String phone, String email , String position, int depId){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.depId = depId;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getDepId() {
        return depId;
    }
    public void setDepId(int depId) {
        this.depId = depId;
    }


}
