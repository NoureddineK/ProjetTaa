package myApp.repository;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import myApp.domaine.Weather;

@Transactional
public interface WeatherDAO extends JpaRepository<Weather, Long> {
	static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);

	String _findByWeatherID= "SELECT p FROM Weather p WHERE p.weatherID = :weatherID";
	String _findByDersciption = "SELECT p FROM Weather p WHERE p.Description = :Description";

	@Query(_findByWeatherID)
	public Weather findByWeatherID(@Param("weatherID") Integer weatherID);

	@Query(_findByDersciption)
	public Weather findByDersciption(@Param("Description") String Description);


}
