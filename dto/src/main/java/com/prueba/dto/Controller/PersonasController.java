package com.prueba.dto.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.dto.Dto.PersonasDto;
import com.prueba.dto.Entity.Personas;
import com.prueba.dto.IService.IPersonasService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/personas")
public class PersonasController {

		
		@Autowired
		private IPersonasService service;
		
		@GetMapping
		public List<Personas> all() {
			return service.all();
		}
		
		@GetMapping("{id}")
		public Optional<Personas> show(@PathVariable Integer id) {
			return service.findById(id);
		}
		
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		public Personas save(@RequestBody Personas personas) {
			return service.save(personas);
		}
		
		@PutMapping("{id}")
		@ResponseStatus(code = HttpStatus.CREATED)
		 public Personas update(@PathVariable Integer id, @RequestBody Personas personas) {
	        Optional<Personas> op = service.findById(id);

	        if (op.isPresent()) {
	        	Personas personsUpdate = op.get();
	            BeanUtils.copyProperties(personas, personsUpdate, "id");
	            return service.save(personsUpdate);
	        }

	        return personas;
	    }
		
		@DeleteMapping("{id}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Integer id) {
			service.delete(id);
		}
		
		@PostMapping("/login")
		public PersonasDto login(@RequestBody Personas personas) {
			return service.login(personas.getUser(), personas.getPassword());
		}
}
