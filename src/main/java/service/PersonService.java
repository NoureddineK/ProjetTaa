package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import domaine.Person;
import io.undertow.Undertow;
import repository.PersonDAO;

@Path("/person")
public class PersonService {
	private static final Logger logger = Logger.getLogger(PersonService.class.getName());
	PersonDAO personDAO = new PersonDAO();

	public PersonService(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public PersonService() {
	}

	@GET
	public Response getStatus() {

		return Response.status(Response.Status.OK).entity("JO").build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("id") Long id) {
		return personDAO.Find(id);
	}

	@POST
	@Path("/createPerson")
	@Produces(MediaType.APPLICATION_JSON)
	public void CreatePerson(Person p) {
		personDAO.Create(p);
	}

	@POST
	@Path("/createPersons")
	@Produces(MediaType.APPLICATION_JSON)
	public void CreatePersons(List<Person> listP) {
		for (Person item : listP) {
			personDAO.Create(item);
		}
	}
	
	@DELETE
	@Path("/DeletePerson/{id}")
	public void deletePerson(@PathParam("id") long id) {
		personDAO.Delete(personDAO.Find(id));
	}
	
	

	public static void main(String[] args) {

		UndertowJaxrsServer ut = new UndertowJaxrsServer();

		TestApplication ta = new TestApplication();

		ut.deploy(ta);

		ut.start(Undertow.builder().addHttpListener(8080, "localhost")

		);

		logger.info("JAX-RS based micro-service running!");
	}

}
