package com.lunastratos.mudspoon.Config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
/**
 * [MongoDB]
 * Configuration & Bean으로 싱글톤 적용
 * */
@Configuration
@EnableMongoRepositories(basePackages = ["com.lunastratos.mudspoon.Repository"])
class MongoConfig : AbstractMongoClientConfiguration() {

    @Bean
    fun transactionManager(dbFactory: MongoDatabaseFactory): MongoTransactionManager {

        return MongoTransactionManager(dbFactory)
    }

    override fun getDatabaseName(): String {

        return "test"
    }

    override fun mongoClient(): MongoClient {

        val connectionString = ConnectionString("mongodb://localhost:27017/mudspoon")
        val mongoClientSettings = MongoClientSettings
            .builder()
            .applyConnectionString(connectionString)
            .build()

        return MongoClients.create(mongoClientSettings)
    }
}