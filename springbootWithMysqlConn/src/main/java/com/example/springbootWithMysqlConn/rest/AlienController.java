package com.example.springbootWithMysqlConn.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootWithMysqlConn.model.Alien;
import com.example.springbootWithMysqlConn.repository.AlienRepository;

@RestController
@RequestMapping("/aliensHomeinfo")
public class AlienController {

	@Autowired
	private AlienRepository alienRepository;

	@PostMapping("/alien")
	public void saveAlien(@RequestBody Alien alien) {
		alienRepository.saveObject(alien);
	}

	@GetMapping("/alien/{id}")
	public Alien getListOfObjects(@PathVariable("id") String id) {
		System.out.println("Fetching Alien Object with id::" + id);
		return alienRepository.findById(id);
	}

	@GetMapping("/alienList")
	public List<Alien> getListOfObjects() {
		return alienRepository.getAlienList();
	}

	@PostMapping("/alienUpdate")
	public Alien updateAlien(@RequestBody Alien alien) {
		alienRepository.updateObject(alien);
		return alienRepository.findById(alien.getId());
	}

	@DeleteMapping("/alienDelete/{id}")
	public void deleteAlien(@PathVariable("id") String id) {
		alienRepository.deleteId(id);
	}

}
