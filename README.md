### Database settings
You should create file `application-database.properties` at `/src/main/resources` directory and add your personal specific properties to this file like this:
```sh
    spring.datasource.url=jdbc:postgresql://localhost:5432/database
    spring.datasource.username=username
    spring.datasource.password=password
```
### Email sender settings
To configure email sending create file `application-mail.properties` at `/src/main/resources` directory and add your personal specific properties to this file like this:
```sh
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=example@gmail.com
    spring.mail.password=example
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    spring.mail.properties.mail.smtp.starttls.required=true
```
