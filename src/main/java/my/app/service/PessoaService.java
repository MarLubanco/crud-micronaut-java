package my.app.service;

import my.app.model.Pessoa;
import my.app.repository.PessoaRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

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
}
