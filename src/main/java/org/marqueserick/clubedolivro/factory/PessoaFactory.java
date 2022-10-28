package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.pessoa.PessoaDto;
import org.marqueserick.clubedolivro.dto.pessoa.PessoaFisicaDto;
import org.marqueserick.clubedolivro.dto.pessoa.PessoaJuridicaDto;
import org.marqueserick.clubedolivro.model.Pessoa;
import org.marqueserick.clubedolivro.model.PessoaFisica;
import org.marqueserick.clubedolivro.model.PessoaJuridica;

import javax.inject.Singleton;

@Singleton
public class PessoaFactory {

    public PessoaDto toDto(Pessoa pessoa){
        if(pessoa.getClass().equals(PessoaFisica.class)){
            return toDto((PessoaFisica) pessoa);
        }
            return toDto((PessoaJuridica) pessoa);
    }

    public Pessoa toPessoa(PessoaDto dto){
        if(dto.getClass().equals(PessoaFisicaDto.class)){
            return toPessoa((PessoaFisicaDto) dto);
        }
        return toPessoa((PessoaJuridicaDto) dto);
    }

    public PessoaFisica toPessoa(PessoaFisicaDto dto){
        return PessoaFisica.builder()
                .rg(dto.getRg())
                .cpf(dto.getCpf())
                .build();
    }

    public PessoaFisicaDto toDto(PessoaFisica pessoa){
        return PessoaFisicaDto.builder()
                .rg(pessoa.getRg())
                .cpf(pessoa.getCpf())
                .build();
    }

    public PessoaJuridica toPessoa(PessoaJuridicaDto dto){
        return PessoaJuridica.builder()
                .cnpj(dto.getCnpj())
                .ie(dto.getIe())
                .build();
    }

    public PessoaJuridicaDto toDto(PessoaJuridica pessoa){
        return PessoaJuridicaDto.builder()
                .cnpj(pessoa.getCnpj())
                .ie(pessoa.getIe())
                .build();
    }
}
