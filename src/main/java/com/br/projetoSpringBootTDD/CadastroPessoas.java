package com.br.projetoSpringBootTDD;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CadastroPessoas {
    private List<Pessoa> pessoas;

    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void adicionaPessoa(Pessoa pessoa) {
        if (Objects.isNull(pessoa.getPessoas())) {
            throw new PessoaSemNomeException();
        }
        this.pessoas.add(pessoa);
    }

    public void remove(String nomePessoa) {

        if (Objects.isNull(nomePessoa)) {
            throw new PessoaInexistenteException();
        }

        this.pessoas.remove(nomePessoa);
    }
}
