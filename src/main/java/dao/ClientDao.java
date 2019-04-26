package dao;

import dao.impl.IClientDao;
import models.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

@Repository("IClientDAO")
public class ClientDao implements IClientDao {

    @Override
    public Client findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    }

    @Override
    public void save(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = (List<Client>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from "+ Client.class.getSimpleName()).list();
        return clients;
    }
}
