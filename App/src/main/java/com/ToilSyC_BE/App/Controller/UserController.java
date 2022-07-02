package com.ToilSyC_BE.App.Controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
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

import com.ToilSyC_BE.App.Models.User;
import com.ToilSyC_BE.App.Service.UserService;

import antlr.collections.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable int id){
		Optional<User> oUser = userService.findById(id);
		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll(){
		
		/*OPCION PARA CUANDO SE QUIERE RETORNAR UNA LISTA DE USUARIOS List<User>
		 * =============================================================
		 * List<User> userss = StreamSupport.stream(userService.findAll().spliterator(), false).collect(Collectors.toList());
		 */
		
		
		Iterable<User> users = userService.findAll();
		return ResponseEntity.ok(users);
	}
	
	//update user
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userUpdate, @PathVariable int id){
		Optional<User> user = userService.findById(id);
		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		/*ESTA LINEA SIRVE PARA COPIAR TODO EL USUARIO DE FORMA DIRECTA
		 * BeanUtils.copyProperties(userUpdate, user);
		 */
		
		user.get().setName(userUpdate.getName());
		user.get().setLast_name(userUpdate.getLast_name());
		user.get().setUsername(userUpdate.getUsername());
		user.get().setPassword(userUpdate.getPassword());
		user.get().setEmail(userUpdate.getEmail());
		user.get().setBorn_date(userUpdate.getBorn_date());
		user.get().setPhone(userUpdate.getPhone());
		user.get().setGender(userUpdate.getGender());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		if (!userService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
