package bean;

import dao.Compte;
import dao.DAOCompte;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean
public class User {

    private String username;

    private String password;
    private int genre;
    private String fullname;
    private String pays;
    private String adresse;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private int age;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullName) {
        this.fullname = fullName;
    }


    public User() {
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


    public String login() {
        DAOCompte dao = new DAOCompte();
        Compte compte = dao.getCompte(username);
        if (compte != null) {
            if (compte.getPassword().equals(password)) {

                fullname = compte.getFullname();
                return "success";

            }
        }

        return "failure";
    }

    public String register() {
        DAOCompte dao = new DAOCompte();
        Compte compte = new Compte(username, password, fullname, genre, age, pays, adresse);
        if (compte.getPassword() != null && compte.getUsername() != null) {
            dao.create(compte);
            fullname = compte.getFullname();
            return "success";


        }

        return "login";
    }



    public void validateAge(FacesContext context, UIComponent comp,
                            Object value) {

        System.out.println("inside validate age");

        String age = (String) value;

        if (!age.matches("^[0-9]{0,2}")) {
            ((UIInput) comp).setValid(false);


            FacesMessage message = new FacesMessage(
                    "Age doit etre compris entre 18-99.");
            context.addMessage(comp.getClientId(context), message);

        }

    }

    public void validateDateNais(FacesContext context, UIComponent comp,
                                 Object value) {

        System.out.println("inside validate method");

        String date = (String) value;

        if (!date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$")) {
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage(
                    "date incorrecte: ex: 31/12/2000");
            context.addMessage(comp.getClientId(context), message);

        }

    }

}
