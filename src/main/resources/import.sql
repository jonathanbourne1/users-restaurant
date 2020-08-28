INSERT INTO users (username, first_name,last_name,email,password,enabled) VALUES ("username1","jonathan","hernandez","jonathan.hernandez.oliva@gmail.com","$2a$10$f0Q47QzbpTcvan9RaWk7set3WHsVz.m3oGEJ6Q.kwpGMGjQtVzWL.",true);
INSERT INTO users (username, first_name,last_name,email,password,enabled) VALUES ("username2","name","lastName","correo@correo.com","$2a$10$IMst3olkrfgQmEvFgB.HEeKxrBOAWuqNaNom2QkDrV1.niU/LQ7xi",true);
INSERT INTO roles(role)VALUES("ROLE_ADMIN")
INSERT INTO roles(role)VALUES("ROLE_USER")
INSERT INTO users_to_roles(user_id,role_id)VALUES(1,1)
INSERT INTO users_to_roles(user_id,role_id)VALUES(1,2)
INSERT INTO users_to_roles(user_id,role_id)VALUES(2,2)
