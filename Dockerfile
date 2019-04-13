FROM openjdk:8-jre-alpine

CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -jar app.jar

ARG DEPS_SOURCE_DIR
ARG DEPS_TARGET_DIR

ADD ${DEPS_SOURCE_DIR}  ./${DEPS_TARGET_DIR}
ADD static /www
ADD config /config

ARG JAR_FILE
ADD ${JAR_FILE} app.jar

