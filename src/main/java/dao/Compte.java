package dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Compte {
    @Id
    private String username;

    private String password;

    private int genre;
    private int age;
    private String pays;
    private String adresse;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private String fullname;

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }



    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }





    public Compte(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Compte(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }
    public Compte(String username, String password, String fullname,int genre) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.genre = genre;
    }
    public Compte(String username, String password, String fullname,int genre,int age,String pays,String adresse) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.genre = genre;
        this.age = age;
        this.pays = pays;
        this.adresse = adresse;
    }

    public Compte() {
    }

    public Compte(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
