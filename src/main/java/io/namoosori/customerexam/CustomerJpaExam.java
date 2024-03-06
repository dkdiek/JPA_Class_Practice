package io.namoosori.customerexam;

import io.namoosori.customerexam.entity.Customer;
import io.namoosori.customerexam.entity.Major;
import io.namoosori.customerexam.entity.Student;
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


            /*
            Customer customer = new Customer(1L,"Jin"); // 비영속 상태(new)
            em.persist(customer); // customer 객체가 영속 상태(managed)
            //em.detach(customer); // 준영속 상태(Detached)
            Customer foundCustomer = em.find(Customer.class, "ID0005");
            System.out.println(foundCustomer.toString()); */

            /* JPQL
            Query query = em.createQuery("Select c From Customer c", Customer.class);
            List customers = query.getResultList();
            System.out.println(customers);
            //em.flush(); */

            /*
            for(int i = 0 ; i<3 ; i++){
                Customer customer = new Customer();
                customer.setName("Kim");
                customer.setRegisterDate(System.currentTimeMillis());
                em.persist(customer);
            }
            System.out.println("before commit"); */


            Major major = new Major("Computer Science","college of Engineering");
            em.persist(major);

            Student student = new Student("Kim","3");
            student.setMajor(major);
            em.persist(student);

            em.flush();
            em.clear();

            //Student 검색
            Student foundStudent =  em.find(Student.class,1);
            System.out.println(foundStudent);

       //     Major foundMajor = em.find(Major.class,foundStudent.getMajorId());



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
