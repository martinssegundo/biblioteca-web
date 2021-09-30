package edu.facec.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.facec.model.Livro;
import edu.facec.repository.LivroRepository;

@Controller
public class IndexController {
	
	//List<Livro> livros = new ArrayList<>();
	
	@Autowired
	LivroRepository livroRepo;

	@RequestMapping("/")
	public String iniciar(Model model) {
		
		model.addAttribute("mensagem", "Boas vindas!");
		
		//model.addAttribute("livros", livros);
		model.addAttribute("livros", livroRepo.findAll());	
		
		return "index";
	}
	
	@GetMapping("formulario")
	public String abrirFormulario(Livro livro, Model model) {
		model.addAttribute("mensagem", "Formulario");
		
		return "formulario";
	}
	
	@PostMapping("salvar")
	public String salvar(Livro livro) {
		
		//livros.add(livro);
		livroRepo.save(livro);
		
		return "redirect:/";
	}
	
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model){
		
		model.addAttribute("mensagem", "Formulario");
		model.addAttribute("livro",livroRepo.getById(id));
		
		return "formulario";
	}
	
	@PostMapping("editar/salvar")
	public String atualizar(Livro livro) {
		
		//livros.add(livro);
		livroRepo.save(livro);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id, Model model){
		
		livroRepo.deleteById(id);
		
		return "redirect:/";
	}
	
}







