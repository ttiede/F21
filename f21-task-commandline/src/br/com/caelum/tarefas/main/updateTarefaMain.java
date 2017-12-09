package br.com.caelum.tarefas.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class updateTarefaMain {
	public static void main(String[] args) {
		Tarefa t = new Tarefa();
		t.setDataFinalizacao(Calendar.getInstance());
		t.setDescricao("desc2");
		t.setFinalizado(false);
		t.setId(1l);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager =  factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
		
		System.out.println("Id da tarefa:" + t.getId());

		manager.close();
	}
}
