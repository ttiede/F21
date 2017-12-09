package br.com.caelum.tarefas.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class InsertTarefaMain {
	public static void main(String[] args) {
		Tarefa t = new Tarefa();
		t.setDataFinalizacao(Calendar.getInstance());
		t.setDescricao("desc");
		t.setFinalizado(false);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager =  factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		
		System.out.println("Id da tarefa:" + t.getId());

		manager.close();
	}
}
