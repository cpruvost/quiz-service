# Quiz Service

This is a SpringBoot sample microservice that focus on using Schema Versionning on Oracle Autonomous Database

Note : 

- To run this microservice locally, create a file application-dev.yml from application-prod.yml and replace the credentials of the DataSource with the right values


- To run this microservice on Kubernetes create first the Secret datasource-credentials with the right values :
kubectl create secret generic datasource-credentials --from-literal=username=root --from-literal=password=password --from-literal=url=url