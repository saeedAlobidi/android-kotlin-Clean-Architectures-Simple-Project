package com.example.clean_architectures_simple_project.Entity

import com.example.clean_architectures_simple_project.Gateway.Database.LiveUsers
import com.example.clean_architectures_simple_project.Gateway.Database.Users
import kotlinx.coroutines.Deferred


typealias  UserEntity = com.example.clean_architectures_simple_project.Entity.User

data class User(
    val userId: Int,
    val title: String,
    val completed: Boolean,
    var id: Int = 1
)


interface UserGateway {

    suspend  fun getUserAll(): LiveUsers;
    suspend fun setUser(user: Users);
    suspend fun getUserAsync(id: Int): Deferred<UserEntity>;

}



