package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Programa {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

//        Exemplo de entidade monitorada
//        Como ja tinha sido inserida no banco de dados
//        Precisou recuperar(procurar)
        Pessoa p = em.find(Pessoa.class, 4);
//        E como não era uma simples leitura do banco de dados
//        Preciso iniciar uma transação
        em.getTransaction().begin();
//        Metodo para remover a pessoa
        em.remove(p);
//        E commitando a operacao
        em.getTransaction().commit();

        System.out.println("Pronto!");

        em.close();
        emf.close();
    }
}
