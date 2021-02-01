package com.hcl.usermanager.repository;

import com.hcl.usermanager.domain.Account;
import com.hcl.usermanager.domain.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class AccountDAO implements DAO<Account> {

    private SessionFactory factory;

    public AccountDAO() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Account> getAll() {

        return factory.openSession().createQuery("FROM Account").list();
    }

    @Override
    public Account get(Long id) {
        String query = "FROM Account A WHERE A.id =" + id;
        List<Account> accounts = factory.openSession().createQuery(query).list();
        if (!accounts.isEmpty()) {
            return accounts.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Account> getByProperty(String property, String match) {
        boolean propertyExists = Arrays.stream(Account.class.getDeclaredFields())
                .anyMatch(f -> f.getName().equals(property));

        if (propertyExists) {
            String query = "FROM Account A WHERE A." + property + " = \'" + match + "\'";
            List<Account> accounts = factory.openSession().createQuery(query).list();
            if (!accounts.isEmpty())
                return accounts;
        }
        return null;
    }

    @Override
    public Account add(Account account) {
        Session session = factory.openSession();
        session.beginTransaction();
        Long id = (Long)session.save(account);
        session.getTransaction().commit();
        session.close();
        return get(id);
    }

    @Override
    public boolean delete(Account entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Account entity) {
        return false;
    }

}