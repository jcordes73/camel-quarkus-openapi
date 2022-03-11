# Camel Quarkus OpenAPI

An example application exposing a REST API ([TMF 629 Customer Management](https://github.com/tmforum-apis/TMF629_CustomerManagement)) using [Camel Quarkus](https://quarkus.io/guides/camel) as a

* Java fast-jar
* Native executible
* Container running on [Red Hat OpenShift](https://www.redhat.com/en/technologies/cloud-computing/openshift)

Prerequisites

* Java 11
* Maven 3.6.3
* [Podman](https://podman.io/) or Docker
* [OpenShift CLI](https://mirror.openshift.com/pub/openshift-v4/clients/ocp/4.9.18/)
* OpenShift cluster (f.e. [CodeReady Containers](https://developers.redhat.com/products/codeready-containers/overview))

This example is using Camel Quarkus 2.7.0 and Red Hat OpenShift 4.9.18

## Build Java
To build the application in Java mode run
```
mvn camel-restdsl-openapi:generate
mvn package
```
Once the build has finished you can start the application via
```
java -jar target/quarkus-app/quarkus-run.jar
```
To test the application run
```
curl "http://localhost/customer/1"
```
## Build Native Image
In order to build a native Quarkus image and to make the setup easy install either Docker or Podman.
There is no need to install GraalVM as a container image will be used during the build process.

Below you can find an example for the setup of Podman 1.6.4 on RHEL 7.9.
```
yum install podman-common
alias docker=podman
export STORAGE_DRIVER=vfs
```
Afterwards build the native executable
```
mvn package -Pnative
```
## Deploy on OpenShift
Deploying on OpenShift requires that you are logged into the cluster and created a project
```
oc login -u <your-user> <your-cluster>
oc new-project camel-quarkus-openapi
```
The application can then be deployed to OpenShift
```
mvn install -Popenshift
```