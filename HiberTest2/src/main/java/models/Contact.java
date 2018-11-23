package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "contacts")
public class Contact extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String lastname;

    private String firstname;

    private String telephone;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Contact() {
    }

    public Contact(String lastname, String firstname, String telephone, String address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.telephone = telephone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public Group getGroup() {
        return group;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return lastname + "  " + firstname;
    }
}
