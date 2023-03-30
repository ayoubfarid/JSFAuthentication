package dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOCompte {
    public boolean create( Compte Em) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getsessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(Em);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e);
            return false;

        }
    }

    public Compte getCompte(String username){
        Transaction tr=null;
        Session session=null;
        try{
            session=HibernateUtil.getsessionFactory().openSession();
            tr=session.beginTransaction();
            Compte compte=session.get(Compte.class,username);
            tr.commit();
            session.close();
            return compte;
        }catch (Exception e){
            tr.rollback();
            session.close();
            return null;
        }
    }
}
