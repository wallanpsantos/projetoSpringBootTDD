package com.br.projetoSpringBootTDD;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CadastroPessoasTest {

    @Test
    public void deveCriarCadastroPessoas() {
        // Cenario e Execução
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        //Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    public void adicionarPessoaNoCadastro() {
        // Cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Albus");

        //Execução
        cadastroPessoas.adicionaPessoa(pessoa);

        //Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test
    public void pessoaSemNome() {
        //Cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução e Verificação
        assertThrows(PessoaSemNomeException.class, () -> cadastroPessoas.adicionaPessoa(pessoa));
    }

    @Test
    public void removePessoa() {
        //Cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Dumbledore");

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Goku");


        //Execução
        cadastroPessoas.remove(pessoa1.getNome());

        //Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();

        System.out.println(pessoa1.getNome());
    }

}
