package com.example.webcustomertracker.dao;

import com.example.webcustomertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final SessionFactory sessionFactory;

    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers(){
        Session currSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery =currSession.createQuery("FROM Customer ,Customer.class");
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }
}
