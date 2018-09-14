package repository;

public interface GenericDAO <T>{
	
	void Create(T object);
	void Delete(T object);
	Object Find(long id);
	int CountAll();
}
