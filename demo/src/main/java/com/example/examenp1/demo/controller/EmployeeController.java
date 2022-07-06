package com.example.examenp1.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenp1.demo.exception.Mensaje;
import com.example.examenp1.demo.model.Employee;
import com.example.examenp1.demo.service.EmployeeService;

@RestController //Notación para indicar que es un controlador de tipo Rest y que puede interceptar peticiones al servidor.
@RequestMapping("/apiv1/clientes")//Notación para mapear los endpoint (las urls de nueestra API) es decir /products/nombredelServicio
public class EmployeeController {

	//Inyección de dependencias
	@Autowired
	private EmployeeService employeeService; //Contiene los metodos del CRUD que va a poder utilizar nuestra apliacion
	
	@GetMapping("/lista")
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> lista = employeeService.getAllEmployee();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin empleados en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(employeeService.getAllEmployee());
	}

	@GetMapping("/detalleempleado/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
	}
	
	@PutMapping("/actualizaempleado/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}

	@DeleteMapping("/eliminaempleado/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id) {
		this.employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}
}