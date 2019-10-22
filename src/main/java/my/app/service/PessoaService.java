package my.app.service;

import my.app.model.Pessoa;
import my.app.repository.PessoaRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class PessoaService {

    @Inject
    private PessoaRepository pessoaRepository;

    public Iterable<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void inativaPessoa(Integer id) {
        Pessoa pessoaExistente = pessoaRepository.findById(id).orElseThrow();
        pessoaExistente.setStatus(false);
        pessoaRepository.save(pessoaExistente);
        System.out.printf("Pessoa %s Inativada%n", pessoaExistente.getApelido());
    }

    public List<Pessoa> retornaPessoasAtivas() {
        Iterable<Pessoa> pessoas = pessoaRepository.findAll();
        List<Pessoa> pessoasAtivas = new ArrayList<>();
        pessoas.forEach(pessoasAtivas::add);
        pessoasAtivas.removeIf(pessoa -> pessoa.getStatus() == false);
        return pessoasAtivas;
    }
}
