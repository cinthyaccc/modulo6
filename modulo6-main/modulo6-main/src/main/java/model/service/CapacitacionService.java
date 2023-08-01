package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.entity.Capacitacion;
import model.repository.ICapacitacionRepository;
@Service
public class CapacitacionService {
@Autowired
private ICapacitacionRepository cliRepo;


	public CapacitacionService() {
		super();
	}
	
	public List<Capacitacion> getCapacitaciones(){
		return cliRepo.findAll();
	}
	
	public void crearCapacitaciones(Capacitacion c, String detalle) {
	    // Antes de guardar la capacitación, asignamos el detalle usando el método mostrarDetalle()
	    c.mostrarDetalle();
	    cliRepo.save(c);
	}
}
