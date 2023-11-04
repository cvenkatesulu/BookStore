server:
  error:
    include-message: always
    include-binding-errors: always
    whitelabel:
      enabled: false 
  port: 9999

spring:
  application:
    name: BOOK_STORE_MANAGEMENT_API_EXAMPLE
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        show_sql: true
        format_sql: true
  datasource:
    url: jdbc:mysql://localhost:3306/sys
    username: root
    password: cvenky
    driver-class-name: com.mysql.cj.jdbc.Driver

#sending mail
  mail:
    host: smtp.gmail.com
    port: 587
    username: Gamail
    password: Gamilpassword
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
          connectiontimeout: 5000
          timeout: 3000
          writetimeout: 5000		  
            
#Loggin
logging:
  #  file:
  #   name: LOGIN_APP.log
  level:
    root: INFO
    com.javautilitylearner: DEBUG
