package net.itinajero.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import net.itinajero.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService{
	
	private List<Vacante> lista = null;
	
	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			lista = new LinkedList<Vacante>();
		try {
			//Oferta de trabajo 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero civil");
			vacante1.setDescripcion("Empresa solicita Ingeniero en comunicacion para las instalaciones");
			vacante1.setFecha(sdf.parse("10-03-2020"));
			vacante1.setSalario(5000.0);
			vacante1.setEstatus("Creada");
			vacante1.setDestacado(0);
			vacante1.setImagen("no-image.png");
			
			//Oferta de trabajo 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Se busca profesor de filosofia para una universidad");
			vacante2.setFecha(sdf.parse("02-6-2010"));
			vacante2.setSalario(5.0);
			vacante2.setEstatus("Creada");
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			
			//Oferta de trabajo 3
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electronico");
			vacante3.setDescripcion("empresa internacional solicita ingeniero mecanico para mantenimiento de la instalacion electrica");
			vacante3.setFecha(sdf.parse("18-12-2013"));
			vacante3.setSalario(8000.0);
			vacante3.setEstatus("Eliminada");
			vacante3.setDestacado(1);
			vacante3.setImagen("empresa3.png");
			 
			//Agregar los trabajos a la lista vacantes
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			
		}catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

	@Override
	public List<Vacante> buscarTodas() {
		
		return lista;
	}

	@Override
	public Vacante buscarPorid(Integer idVacante) {
		
		for (Vacante v : lista) {
			if(v.getId()==idVacante) {
				return v;
			}
		}
		
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
	}

	
}
