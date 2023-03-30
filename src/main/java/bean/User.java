package bean;

import dao.Compte;
import dao.DAOCompte;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class User {

    private String username;

    private String password;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullName) {
        this.fullname = fullName;
    }

    private String fullname;
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


    public String login(){
        DAOCompte dao=new DAOCompte();
        Compte compte=dao.getCompte(username);
        if(compte!=null){
            if(compte.getPassword().equals(password)){
                fullname=compte.getFullname();
                return "success";
            }
        }

        return "login";
    }

    public String register(){
        DAOCompte dao=new DAOCompte();
        Compte compte=new Compte(username,password,fullname);
        if(compte.getPassword()!=null && compte.getUsername()!=null ){
            dao.create(compte);
            return "success";

        }

        return "index";
    }

}
