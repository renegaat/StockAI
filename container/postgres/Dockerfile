FROM postgres:latest

# Install the JDK and other dependencies
RUN apt-get update && apt-get install -y \
    default-jdk \
    maven \
    git

RUN mkdir /app
WORKDIR /app

# Set the environment variables for the Postgres database
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB stockaidb

# Create the database schema
# ADD schema.sql /docker-entrypoint-initdb.d/

# Expose the default Postgres port
EXPOSE 5432

# Start the Postgres server and the application
CMD ["postgres", "-c", "listen_addresses=*"]
