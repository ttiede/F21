package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class OlaMundoController {
	@RequestMapping("/olaMundoSpring")
	private String execute() {
		return "ok";
	}
}
