package com.mycompany.mavenproject4.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import static javax.ws.rs.client.Entity.form;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("base")
public class JavaEE8Resource {
    
    @Path("latency")
    @GET
    public Response ping(){
        
        //String result = ClientBuilder.newClient().target("http://google.com.br").request().get(String.class);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.sandbox.paypal.com/v1/oauth2/token");
        
        Form form = new Form();
        form.param("grant_type", "client_credentials");
        
        Entity<Form> entity = Entity.entity(form,
        MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        
        Invocation.Builder builder = target.request();
        String response = builder.header("Accept", "application/json")
                                 .header("Accept-Language", "en_US")
                                 .header("Content-Type", "application/x-www-form-urlencoded")
                                 .header("Authorization", "Basic QWNXZVFCM1hEMkJOTmtScnliVThFZ0RRVXc1QWVSNi16RUhobF9MdGl5ZEp5WXM3eWdGdWtqcEx1Rmt1bUhQZllPNm92d0dlVXNpeGI1Rk06RUJRVWpCcFdTMzM1OFpUZ3VGZWJwODAxbGJTNVAyMm83V3luRUtNc0M3MnlkajFibi1ZWmJMZ0RHX3hBdDdfdWdwOHluZXpfUnRhaDY3Tmw=")
                                 .post(entity, String.class);
        
        return Response
                .ok(response)
                .build();
    }
}
