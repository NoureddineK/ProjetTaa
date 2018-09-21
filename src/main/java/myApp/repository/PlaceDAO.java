package myApp.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import myApp.domaine.Place;

@Transactional
public interface PlaceDAO extends JpaRepository<Place, Long> {

}