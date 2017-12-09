package br.com.caelum.tarefas.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.tarefas.modelo.Tarefa;

public class ListTarefasMain {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select t from Tarefas as t where t.finalizado = :paramFinalizado");
		query.setParameter("paramFinalizado", false);
		List<Tarefa> tarefas = query.getResultList();
		
		for (Tarefa tarefa : tarefas) {
			System.out.println("Id da tarefa:" + tarefa.getId());
			System.out.println("Desc da tarefa:" + tarefa.getDescricao());
			//System.out.println("Data finaliazacao da tarefa:" + tarefa.getDataFinalizacao().getInstance().getTime());
			System.out.println("Foi finalizadp a tarefa:" + tarefa.isFinalizado());
		}

		manager.close();
	}
}
