# Flyway and Spring Boot

It is a simple project to try out the flyway framework.
We have a User model that we want to create a table for in the database.
The database schema is built in PostgreSQL, and it is called `flyway_demo_db`.
We have two migrations in this project:
* V1_1__create_users_table.sql
* V1_2__add_gender_to_users_table.sql

The first migration is as its name says creates the users table. And the second one updates the users table to add the gender column which is an enum (Male, Female)

