package io.namoosori.customerexam;

import io.namoosori.customerexam.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //
        try{
//저장            em.persist(Customer.sample());
//조회           Customer customer = em.find(Customer.class, "ID0001");

            /* 업데이트
            Customer foundCustomer = em.find(Customer.class, "ID0001");
            foundCustomer.setName("Park"); */

            /* 삭제
            Customer foundCustomer = em.find(Customer.class, "ID0001");
            em.remove(foundCustomer); */



            tx.commit(); // tx.rollback();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        //
        emf.close();
    }
}
