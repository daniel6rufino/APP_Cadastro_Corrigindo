package com.example.cadastro.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PessoaDao {
    @Insert
    suspend fun insert(pessoa: Pessoa)

    @Query("SELECT * FROM pessoa")
    fun getAllPessoas(): Flow<List<Pessoa>>

    @Query("SELECT * FROM pessoa WHERE id=:id")
    fun getById(id: Int): Flow<Pessoa>

    @Delete
    suspend fun delete(pessoa: Pessoa)
}