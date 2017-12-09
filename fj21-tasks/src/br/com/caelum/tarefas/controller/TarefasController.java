package br.com.caelum.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	private JdbcTarefaDao dao;

	// sem construtor

	@Autowired
	public void setTarefaDao(JdbcTarefaDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("/adicionaTarefa")
	public String adicionaTarefa(Tarefa tarefa) {
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

	@RequestMapping("/listaTarefas")
	public String lista(Model model) {
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@ResponseBody
	@RequestMapping("finalizaTarefa")
	private void finalizaTarefa(Long id) {
		dao.finaliza(id);

	}

}
