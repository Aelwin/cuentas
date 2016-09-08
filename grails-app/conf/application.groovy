environments {
  production {
    dataSource {
      dbCreate = "update"
      driverClassName = "org.postgresql.Driver"
      dialect = org.hibernate.dialect.PostgreSQLDialect
      uri = new URI(System.env.DATABASE_URL?:"postgres://test:test@localhost/test")
      username = uri.userInfo.split(":")[0]
      password = uri.userInfo.split(":")[1]
      url = "jdbc:postgresql://" + username + ":" + password + "@" + uri.host + ":" + uri.port + uri.path      
    }
  }
}
