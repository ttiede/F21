package br.com.caelum.tarefas.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class removeTarefaMain {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager =  factory.createEntityManager();
		manager.getTransaction().begin();
		Tarefa t =  manager.find(Tarefa.class, 6l);

		
		System.out.println("Id da tarefa:" + t.getId());
		System.out.println("Desc da tarefa:" + t.getDescricao());
		System.out.println("Data finaliazacao da tarefa:" + t.getDataFinalizacao().getInstance().getTime());
		System.out.println("Foi finalizadp a tarefa:" + t.isFinalizado());
		
		manager.remove(t);
		manager.getTransaction().commit();
		manager.close();
	}
}
