package net.itinajero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.model.Categoria;
import net.itinajero.service.ICategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriasService serviceCategorias;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = serviceCategorias.buscarTodas();
		model.addAttribute("categorias", lista);
		
		return "categorias/listCategorias";		
	}
	
	@GetMapping("/create")
	public String crear() {
		return "categorias/formCategorias";
	}
	
	@PostMapping("/save")
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			for (ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un Error: " + error.getDefaultMessage());
			}
			
			return "categorias/formCategorias";
		}
		
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		System.out.println("Categoria: " + categoria);		
		return "redirect:/categorias/index";
	}
	
	
	/*@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idCategoria, Model model) {
		
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		
		System.out.println("Categoria" + categoria);
		model.addAttribute("categoria", categoria);
		
		// buscar detalles de la vacante en la base de datos.......................
		
		return null;
	
	}*/
}
