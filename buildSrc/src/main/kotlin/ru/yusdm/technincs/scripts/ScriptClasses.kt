package ru.yusdm.technincs.scripts

data class JooqConfig(
    val driver: String,
    val url: String,
    val user: String,
    val password: String,
    val schema: String,
    val jooqMetaDbName: String,
    val packageName: String,
    val directory: String,
    val exclude : String = "excludes = 'databasechangelog|databasechangeloglock"
)