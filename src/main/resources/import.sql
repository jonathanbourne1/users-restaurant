INSERT INTO users (username, first_name,last_name,email,password,enabled) VALUES ("username1","jonathan","hernandez","jonathan.hernandez.oliva@gmail.com","$2a$10$f0Q47QzbpTcvan9RaWk7set3WHsVz.m3oGEJ6Q.kwpGMGjQtVzWL.",true);
INSERT INTO users (username, first_name,last_name,email,password,enabled) VALUES ("username2","name","lastName","correo@correo.com","$2a$10$IMst3olkrfgQmEvFgB.HEeKxrBOAWuqNaNom2QkDrV1.niU/LQ7xi",true);

INSERT INTO roles(role)VALUES("ROLE_ADMIN")
INSERT INTO roles(role)VALUES("ROLE_USER")

INSERT INTO users_to_roles(user_id,role_id)VALUES(1,1)
INSERT INTO users_to_roles(user_id,role_id)VALUES(1,2)
INSERT INTO users_to_roles(user_id,role_id)VALUES(2,2)

INSERT INTO permissions (name)VALUES("create_profile")
INSERT INTO permissions (name)VALUES("read_profile")
INSERT INTO permissions (name)VALUES("update_profile")
INSERT INTO permissions (name)VALUES("delete_profile")

INSERT INTO permissions_to_roles (role_id,permission_id)VALUES(1,1)
INSERT INTO permissions_to_roles (role_id,permission_id)VALUES(1,2)
INSERT INTO permissions_to_roles (role_id,permission_id)VALUES(1,3)
INSERT INTO permissions_to_roles (role_id,permission_id)VALUES(1,4)

INSERT INTO permissions_to_roles (role_id,permission_id)VALUES(2,1)
INSERT INTO permissions_to_roles (role_id,permission_id)VALUES(2,2)
INSERT INTO permissions_to_roles (role_id,permission_id)VALUES(2,3)

INSERT INTO oauth_clients_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('mobile','{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu','http://localhost:8080/code','READ,WRITE',3600, 10000,'inventory,payment','authorization_code,password,refresh_token,implicit','{}');
