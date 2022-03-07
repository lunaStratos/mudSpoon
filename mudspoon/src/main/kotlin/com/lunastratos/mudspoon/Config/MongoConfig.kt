package com.lunastratos.mudspoon.Config

/**
 * [MongoDB]
 * Configuration & Bean으로 싱글톤 적용
 * 가격적인 이유로 사용 X
 * */
//@Configuration
//@EnableMongoRepositories(basePackages = ["com.lunastratos.mudspoon.Repository"])
//class MongoConfig : AbstractMongoClientConfiguration() {
//
//    @Bean
//    fun transactionManager(dbFactory: MongoDatabaseFactory): MongoTransactionManager {
//
//        return MongoTransactionManager(dbFactory)
//    }
//
//    override fun getDatabaseName(): String {
//
//        return "test"
//    }
//
//    override fun mongoClient(): MongoClient {
//
//        val connectionString = ConnectionString("mongodb://localhost:27017/mudspoon")
//        val mongoClientSettings = MongoClientSettings
//            .builder()
//            .applyConnectionString(connectionString)
//            .build()
//
//        return MongoClients.create(mongoClientSettings)
//    }
//}