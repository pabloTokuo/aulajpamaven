package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Programa {
    public static void main(String[] args) {

//        Proprio banco de dados vai inserir as pessoas no banco
//        Por isso ID Null

        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

//        Como nao é uma leitura do banco de dados
//        Precisa começar uma Transação
        em.getTransaction().begin();
//        Persist que vai inserir o obj no banco de dados
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
//        Apos finalizar commitar as mudancas
        em.getTransaction().commit();
        System.out.println("Pronto!");
        
    }
}
