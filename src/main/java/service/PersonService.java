package service;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import domaine.JpaTest;
import domaine.Person;
import io.undertow.Undertow;
import repository.PersonDAO;

@Path("/Person")
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
	@Path("/create")
	@Consumes("Application/json")
	public Person CreatePerson() {
		Person person = new Person("NOureddine");
		personDAO.Create(person);
		return person;
	}

	@POST
	@Path("/person")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson() {
		Person p = new Person();
		p.setName("test");
		//personDAO.Create(p);
		// p.setFirstName("t");
		return p;
	}

	@POST
	@Path("/person")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPerson(Person p) {
		System.err.println(p.getName());
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
