# api-email Project

This is an API to manage clients and newsletter.

Features:
 - Send newsletter to all active clients at 8am.
 - Create and Edit Newsletter
 - Create and Edit Clients.

For use this Project:

Database: Postgresql 12
Create Database with name : newsletter
In Ubuntu Terminal execute: 
```LINUX
createdb -U "postgresql" -O "#YOURUSERNAME#" newsletter
```
Configure username and password in file "application.properties" in the path "src/main/resources/"

Execute this script to Create tables and active hibernate sequence.
  ```SQL
 CREATE TABLE IF NOT EXISTS client (
	name varchar(255) not null,
	email varchar(255) not null,
	id int8 ,
	dt_nascimento int8,
	active boolean
);




create table if not EXISTS newsletter (
	id int8 ,
	title varchar(255) not null,
	description varchar(255) not null,
	processada boolean not null,
	link varchar(50) not null
	
) ;

	CREATE SEQUENCE hibernate_sequence START 1;
  ```
  Execute the application with command ```mvn quarkus:dev```
  
  
