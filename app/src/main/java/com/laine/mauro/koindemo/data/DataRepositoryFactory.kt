package com.laine.mauro.koindemo.data

class DataRepositoryFactory(
    private val localDataSource: LocalRepositoryImpl,
    private val remoteDataSource: RemoteRepositoryImpl
) {

    fun retrieveRemoteSource(): RemoteRepositoryImpl {
        return remoteDataSource
    }

    fun retrieveLocalSource(): LocalRepositoryImpl {
        return localDataSource
    }
}