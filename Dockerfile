# syntax=docker/dockerfile:1

# ---- Build stage: compile and package the application distribution ----
FROM gradle:8.2-jdk17 AS build
WORKDIR /home/gradle/project
# Copy build scripts first so dependency resolution is cached across code changes.
COPY --chown=gradle:gradle settings.gradle build.gradle ./
COPY --chown=gradle:gradle src ./src
# `installDist` produces a self-contained distribution with a launcher script.
RUN gradle --no-daemon clean installDist

# ---- Runtime stage: minimal JRE with just the built distribution ----
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /home/gradle/project/build/install/bundle_test ./
COPY logging.properties ./
# The CLI reads order lines from stdin; run the container with `-i` to pipe input.
ENTRYPOINT ["./bin/bundle_test"]
