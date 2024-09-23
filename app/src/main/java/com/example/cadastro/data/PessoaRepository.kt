package com.example.cadastro.data

import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.Flow

class PessoaRepository(private val pessoaDao: PessoaDao) {

    val todasAsPessoas: Flow<List<Pessoa>> = pessoaDao.getAllPessoas()

    suspend fun inserir(pessoa: Pessoa) {
        pessoaDao.insert(pessoa)
    }

    suspend fun deletar(id: Int) {
        val pessoa = pessoaDao.getById(id). collect {
            pessoa -> pessoaDao.delete(pessoa)
        }
    }

    suspend fun findBy(id: Int): Flow<Pessoa> {
        return pessoaDao.getById(id)
    }
}
