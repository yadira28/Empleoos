package net.itinajero.service;


import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import net.itinajero.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService{

	private List<Categoria> lista = null;
	
	public CategoriasServiceImpl() {
		lista = new LinkedList<Categoria>();
		
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNombre("Contabilidad");
		categoria1.setDescripcion("Descripcion de categoria contabilidad");
		
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("Ventas");
		categoria2.setDescripcion("Trabajos relacionados con ventas ");
		
		Categoria categoria3 = new Categoria();
		categoria3.setId(3);
		categoria3.setNombre("Comunicaciones");
		categoria3.setDescripcion("Trabajos relacionados con Comunicacion");
	
		
		lista.add(categoria1);
		lista.add(categoria2);
		lista.add(categoria3);
		
		
		
	}
	
	
	
	
	
	
	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodas() {
		
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for (Categoria cat : lista) {
			if(cat.getId()==idCategoria) {
				return cat;
			}
		}
		
		return null;
	}

}
