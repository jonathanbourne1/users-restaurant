INSERT INTO users (username, first_name,last_name,email,password,enabled) VALUES ("username1","jonathan","hernandez","jonathan.hernandez.oliva@gmail.com","12345678",true);
INSERT INTO users (username, first_name,last_name,email,password,enabled) VALUES ("username2","name","lastName","correo@correo.com","12345678",true);
INSERT INTO roles(role)VALUES("ROLE_ADMIN")
INSERT INTO roles(role)VALUES("ROLE_USER")
INSERT INTO users_to_roles(user_id,role_id)VALUES(1,1)
INSERT INTO users_to_roles(user_id,role_id)VALUES(1,2)
INSERT INTO users_to_roles(user_id,role_id)VALUES(2,2)
