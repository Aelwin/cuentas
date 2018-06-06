environments {
  production {
    dataSource {
      dbCreate = "update"
      driverClassName = "org.postgresql.Driver"
      dialect = org.hibernate.dialect.PostgreSQLDialect
      uri = new URI(System.env.DATABASE_URL?:"postgres://test:test@localhost/test")      
      url = "jdbc:postgresql://" + uri.host + ":" + uri.port + uri.path
      username = uri.userInfo.split(":")[0]
      password = uri.userInfo.split(":")[1]
    }
  }
}
//indicamos que patrones tiene que convertir a Dates al hacer un bindeo con strings
grails.databinding.dateFormats = [
		'dd/MM/yyyy', 'yyyy-MM-dd'
]

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'jlr.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'jlr.security.UserRole'
grails.plugin.springsecurity.authority.className = 'jlr.security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/gastos/**',   	 access: ['permitAll']],
	[pattern: '/graficas/**',  	 access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/principal',      access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]
