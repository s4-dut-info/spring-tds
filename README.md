# spring-tds

Each branch corresponds to a session and the spring-boot application created.
These applications are deployed on [Heroku](https://www.heroku.com/spring-boot) in a [pipeline](https://devcenter.heroku.com/articles/pipelines).

## Repository content

* TD n°1 :
  * [source code](https://github.com/s4-dut-info/spring-tds/tree/td1)
  * [Heroku deployment](https://spring-td1.herokuapp.com)

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](https://git-scm.com/)
* Java 8+
* [maven](http://maven.apache.org/download.html)

## Installation

* `git clone <repository-url>` this repository
* `cd spring-tds`

## Navigation

* `git checkout <branch-name>` to navigate to an application (td or project)
* `mvn package`

## Running / Development

* `mvn spring-boot:run`
* Visit your app at [http://127.0.0.1:8080](http://127.0.0.1:8080).

## Further Reading / Useful Links

* [Spring initializr](https://start.spring.io)
* [Using spring-boot](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html)
* Documentation
  * [Baeldung](https://www.baeldung.com/spring-boot)
