package hibernate;

import hibernate.model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PhoneRunner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        PhoneRunner phoneRunner = new PhoneRunner();

        phoneRunner.addPhone(1, "779900");
        phoneRunner.addPhone(8, "889911");

        System.out.println("===================================");

        List<Phone> phones = phoneRunner.listPhones();
        for (Phone phone : phones) {
            System.out.println(phone);
        }

        System.out.println("===================================");

    }

    public void addPhone(int user_id, String phone_number){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Phone phone = new Phone(user_id, phone_number);
        session.save(phone);
        transaction.commit();
        session.close();
    }
    public List<Phone> listPhones(){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Phone> phones = session.createQuery("FROM Phone").list();

        transaction.commit();
        session.close();
        return phones;
    }



}
