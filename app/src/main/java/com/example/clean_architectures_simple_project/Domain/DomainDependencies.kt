package com.example.clean_architectures_simple_project.Domain

import com.example.clean_architectures_simple_project.Entity.UserGateway


suspend fun <R> withSuspendDomain(block: suspend DomainDependencies.() -> R) = block(DomainDependencies)
fun <R> withDomain(block: DomainDependencies.() -> R) = block(DomainDependencies)

object DomainDependencies {
    lateinit var internalGateway: UserGateway private set
    fun with(gateway: UserGateway): DomainDependencies {
        internalGateway = gateway
        return this;
    }
}