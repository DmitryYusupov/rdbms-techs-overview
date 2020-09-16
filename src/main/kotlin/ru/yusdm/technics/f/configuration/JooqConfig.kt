package ru.yusdm.technics.f.configuration

import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource

@Configuration
class JooqConfig {

  /*  @Bean
    fun configuration(
        dataSource: DataSource,
        transactionManager: DataSourceTransactionManager
    ) = DefaultConfiguration().apply {
        this.set(SQLDialect.POSTGRES)
        this.setConnectionProvider(DataSourceConnectionProvider(TransactionAwareDataSourceProxy(dataSource)))
        this.setTransactionProvider(SpringTransactionProvider(transactionManager))
    }

    @Bean
    fun dsl(configuration: DefaultConfiguration) = DefaultDSLContext(configuration)*/
}






