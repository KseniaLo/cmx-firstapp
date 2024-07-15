################################################
#             LIQUIBASE MICROSERVICE IMAGE     #
################################################
FROM liquibase/liquibase:4.28

LABEL ru.gazprom.gpplt.zptt="gpplt-ms-zptt-document-db"

ENV JAVA_APP_JAR firstapp-db-0.0.1-SNAPSHOT-jar-with-dependencies.jar
ENV CHANGELOG_FILE database-changelog.xml

COPY ./target/$JAVA_APP_JAR /liquibase/changelog/

CMD ["bash", "-c", "[[ ${SKIP_MIGRATION:-false} = false ]] && docker-entrypoint.sh --url=${DB_URL} --defaultSchemaName=${DB_SCHEMA}  --username=${DB_LOGIN} --password=${DB_PASSWORD} --classpath=/liquibase/changelog/${JAVA_APP_JAR} --changeLogFile=${CHANGELOG_FILE} --log-level=${LB_LOG_LEVEL:-INFO} update"]
