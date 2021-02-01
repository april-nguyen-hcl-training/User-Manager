# User Manager

User Manager is a Java project that allows a user to register and login. The project uses JSP, Servlets, Maven, Apache Tomcat, Hibernate, and a MySQL database.

## Installation

Use [docker](https://docs.docker.com/get-docker/) to install.

```bash
docker-compose --file docker/compose.yaml up --build -d
```

## Usage

In browser, go to [link](http://localhost:8081/user/).

## Stopping

```bash
docker-compose --file docker/compose.yaml down
```

## License
[MIT](https://choosealicense.com/licenses/mit/)