package my.app.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import my.app.model.Pessoa;
import my.app.service.PessoaService;

import javax.inject.Inject;

@Controller("/api/pessoas")
public class PessoaController {

    @Inject
    private PessoaService pessoaService;

    @Get
    public Iterable<Pessoa> findAllPessoas() {
        return pessoaService.getAllPessoas();
    }

    @Post
    public Pessoa savePessoa(@Body Pessoa pessoa) {
        return pessoaService.savePessoa(pessoa);
    }
}
