package myApp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface Services<T> {
	static final Logger LOGGER = LoggerFactory.getLogger(Services.class);

	@GetMapping("/{id}")
	public T getObject(String id);

	@GetMapping("/allObjects")
	public List<T> getAllObjects();

	@PostMapping("/addObject")
	public void CreateObject(T object);

	@PostMapping("/addObjects")
	public void CreateObjects(List<T> listObject);

	@DeleteMapping("/delete/{id}")
	public void deleteObject(long id);

	@DeleteMapping("/deleteAll")
	public void deleteAllObjects();

	@GetMapping("/finByName/{name}")
	public T FinByName(String name);

}
