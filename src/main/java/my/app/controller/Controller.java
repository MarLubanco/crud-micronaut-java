package my.app.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

import java.util.ArrayList;
import java.util.List;

@io.micronaut.http.annotation.Controller("api/controller")
public class Controller {

    List<String> nomes = new ArrayList<>();

    @Get("teste")
//    @Produces(MediaType.APPLICATION_JSON)
    public String teste() {
        return "DEU CERTO";
    }

    @Post("salva-nome")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> salvarNome(@Body String nome) {
        nomes.add(nome);
        return nomes;
    }


}
