insert into users (encrypted_password, email, enabled, first_name, last_name, user_id) values ("test", "correo@correo.com", 1, "usuario1", "usuario1", "c507c0f2-c314-4db5-9dc7-1f92b54a582a")
insert into users (encrypted_password, email, enabled, first_name, last_name, user_id) values ("test", "correo1@correo.com", 1, "usuario2", "usuario2", "ff54b11d-0ac1-40ef-8b3b-56b293552979")
insert into roles (user_role) values( "ADMIN")
insert into roles (user_role ) values( "USER")
insert into users_to_roles (user_id, role_id) values (1,1)