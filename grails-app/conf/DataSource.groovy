dataSource {
    pooled = false
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = "iaiwyd"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
	cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/grails_dev?useUnicode=true&characterEncoding=UTF-8"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/grails_dev?useUnicode=true&characterEncoding=UTF-8"
		}
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/grails_dev?useUnicode=true&characterEncoding=UTF-8"
        }
    }
}
