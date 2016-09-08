environments {
  production {
    dataSource {
      dbCreate = "create"
      driverClassName = "org.postgresql.Driver"
      dialect = org.hibernate.dialect.PostgreSQLDialect      
      url = "jdbc:postgresql://fdptuejixcpmwl:ZOblCrvU1d6qwnrPlPc-fMDAFB@ec2-54-243-212-122.compute-1.amazonaws.com:5432/db1m382o2ljaem"
      username = "fdptuejixcpmwl"
      password = "ZOblCrvU1d6qwnrPlPc-fMDAFB"
    }
  }
}

/*environments {
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
}*/
