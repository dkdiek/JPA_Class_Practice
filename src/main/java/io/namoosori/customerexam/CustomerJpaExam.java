package io.namoosori.customerexam;

import io.namoosori.customerexam.entity.Customer;
import jakarta.persistence.*;

import java.util.List;

public class CustomerJpaExam {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //
        try{
            /* 저장
            em.persist(Customer.sample()); */

            /* 조회
            Customer customer = em.find(Customer.class, "ID0001"); */

            /* 업데이트
            Customer foundCustomer = em.find(Customer.class, "ID0001");
            foundCustomer.setName("Park"); */

            /* 삭제
            Customer foundCustomer = em.find(Customer.class, "ID0001");
            em.remove(foundCustomer); */

            /*
            Customer customer = new Customer("ID0001","Kim");
            em.persist(customer);
            //위의 persist를 통해 1차 캐시에 ID0001이 있어 select문이 실행안되고 조회가 된다
            Customer customer1 = em.find(Customer.class, "ID0001");
            System.out.println(customer1.toString()); */



            Customer customer = new Customer("ID0004","Hong"); // 비영속 상태(new)
            em.persist(customer); // customer 객체가 영속 상태(managed)

            
            /* JPQL
            Query query = em.createQuery("Select c From Customer c", Customer.class);
            List customers = query.getResultList();
            System.out.println(customers);
            //em.flush(); */








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
