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

            Customer customer = new Customer("ID0001","Kim");
            em.persist(customer);
            //1차 캐시에 ID0001이 있어 select문이 실행안되고 조회가 된다
            Customer customer1 = em.find(Customer.class, "ID0001");
            System.out.println(customer1.toString());


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
