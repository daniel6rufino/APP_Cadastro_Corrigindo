package com.example.cadastro.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cadastro.data.Pessoa
import com.example.cadastro.data.PessoaDao
import com.example.cadastro.data.PessoaRepository
import kotlinx.coroutines.launch

class PessoaViewModel(private val repository: PessoaRepository) : ViewModel() {

    val todasAsPessoas = repository.todasAsPessoas

    fun inserirPessoa(nome: String, idade: Int, cpf: String) {
        val pessoa = Pessoa(nome = nome, idade = idade, cpf = cpf)
        viewModelScope.launch {
            repository.inserir(pessoa)
        }
    }

    fun deletarPessoa(id: Int) {
        viewModelScope.launch {
           repository.deletar(id)
        }

    }
}
