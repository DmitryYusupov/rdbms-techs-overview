package ru.yusdm.technics.jooq.configuration

import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource

const val JOOQ_TX_MANAGER = "jooqTxManager"

@Configuration
class JooqConfig {

    @Bean(name = [JOOQ_TX_MANAGER])
    fun transactionManager(ds: DataSource) = DataSourceTransactionManager(ds)

    @Bean
    fun connectionProvider(ds: DataSource) =
        DataSourceConnectionProvider(TransactionAwareDataSourceProxy(ds))

    @Bean
    fun txProvider(@Qualifier(JOOQ_TX_MANAGER) txMngr: DataSourceTransactionManager) =
        SpringTransactionProvider(txMngr)

    @Bean
    fun configuration(
        connectionProvider: DataSourceConnectionProvider,
        txProvider: SpringTransactionProvider
    ) = DefaultConfiguration().apply {
        this.set(SQLDialect.POSTGRES)
        this.setConnectionProvider(connectionProvider)
        this.setTransactionProvider(txProvider)
    }

    @Bean
    fun dsl(configuration: DefaultConfiguration) = DefaultDSLContext(configuration)
}






