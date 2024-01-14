# Use uma imagem oficial do Maven como imagem base
FROM openjdk:17-alpine AS builder

# Configuração do Maven
ENV MAVEN_VERSION 3.9.6
ENV MAVEN_HOME /usr/apache-maven-${MAVEN_VERSION}
ENV PATH ${MAVEN_HOME}/bin:${PATH}

# Instalação do Maven usando curl
RUN apk add --no-cache curl \
    && curl -fsSL https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -o /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    && tar xzf /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /usr/ \
    && ln -s /usr/apache-maven-${MAVEN_VERSION} /usr/maven \
    && rm -f /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz

WORKDIR /app 

COPY ./backend .

WORKDIR /app

EXPOSE 8080
RUN mvn clean install
# RUN mvn package spring-boot:repackage
RUN mvn package
CMD ["java", "-jar","target/kanban-1.0-SNAPSHOT.jar"]

