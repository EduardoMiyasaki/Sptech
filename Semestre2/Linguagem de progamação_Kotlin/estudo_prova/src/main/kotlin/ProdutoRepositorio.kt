import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.JdbcTemplate

class ProdutoRepositorio {

        lateinit var jdbcTemplate: JdbcTemplate

        fun configurar() {
            val dataSource = BasicDataSource()
            dataSource.driverClassName = "org.h2.Driver"
            dataSource.url = "jdbc:h2:mem:Mercado"
            dataSource.username = "sa"
            dataSource.password = ""

            jdbcTemplate = JdbcTemplate(dataSource);

}
}
