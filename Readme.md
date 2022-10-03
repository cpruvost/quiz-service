# Quiz Service

This is a SpringBoot sample microservice application that focuses on using Schema Versionning on Oracle Autonomous Database. So the version of the microservice is in a driect relation with the version of the schema in the Database.

## Prerequisites

You need to have a Database  with a schema (tables, views, ..) ready. So use the project [quiz-db](https://github.com/cpruvost/quiz-db) for that. With this project you have a schema in two versions (V1 and V1POINT2).

If you use for ex Oracle SQLDeveloper and if you connect to the database.

execute : alter session set edition=V1; --> The view V_QUIZ has 2 colums

![Quiz V1](docs/quizV1.png)

execute : alter session set edition=V1POINT2; --> The view V_QUIZ has 3 colums

![Quiz V1](docs/quizV1POINT2.png)

You need to be able to run a docker container locally.

## Run the microservices application locally.

- in V1 : docker run -d -p 8001:8000 cpruvost/cn-quiz-service:1.0.4-SNAPSHOT

- To run this microservice locally, create a file application-dev.yml from application-prod.yml and replace the credentials of the DataSource with the right values


- To run this microservice on Kubernetes create first the Secret datasource-credentials with the right values :
kubectl create secret generic datasource-credentials --from-literal=username=root --from-literal=password=password --from-literal=url=url