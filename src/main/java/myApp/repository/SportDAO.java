package myApp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import myApp.domaine.Sport;

@Transactional
public interface SportDAO  extends JpaRepository<Sport, Long> {

}