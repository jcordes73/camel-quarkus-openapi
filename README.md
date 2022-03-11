* Install Quarkus CLI

curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/
curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio

(see https://quarkus.io/guides/cli-tooling)

* Build Java

	mvn camel-restdsl-openapi:generate
	mvn package

java -jar target/quarkus-app/quarkus-run.jar

* Build Native Image

export STORAGE_DRIVER=vfs

mvn package -Pnative

* Run on OpenShift

mvn install -Popenshift

oc create route edge --service=camel-quarkus-openapi --port=8080
