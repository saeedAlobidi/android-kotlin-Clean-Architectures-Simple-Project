package com.example.clean_architectures_simple_project.Gateway

import com.example.clean_architectures_simple_project.Gateway.Database.UserDatabase
import com.example.clean_architectures_simple_project.Gateway.Server.API
import kotlinx.coroutines.Deferred

//------------------------------------------------------------------------------
// <auto-generated>
//   name :saeed mohammed alabidi
//  Email:saeed1adm@gmail.com
//  Phone:00967-733122038
// </auto-generated>
//------------------------------------------------------------------------------



suspend fun <R> withSuspendGateway(block:suspend GatewayDependencies.() -> R) = block(GatewayDependencies)
fun <R> withGateway(block: GatewayDependencies.() -> R) = block(GatewayDependencies)
object GatewayDependencies {
    lateinit var internalDatabase: Deferred<UserDatabase> private set
    lateinit var internalServer: Deferred<API> private set

    fun with(database: Deferred<UserDatabase>, server: Deferred<API>): GatewayDependencies {
        internalDatabase = database
        internalServer = server
        return this;
    }


}
