/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package service;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domaine.Person;


@Path("/Person")
public class StatusEndpoint {

    private static final Logger logger = Logger.getLogger(StatusEndpoint.class.getName());

    @GET
    public Response getStatus() {

        return Response.status(Response.Status.OK).entity("JO").build();
    }
    
    @GET
    @Path("/{name}")
    public String helloWorld(@PathParam("name") String name) {

        return "hello "+name;
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
    	Person p = new Person();
    	p.setName("test");
    	//p.setFirstName("t");
        return p;
    }

    @POST
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(Person p) {
    	System.err.println(p.getName());
    }
    

}

