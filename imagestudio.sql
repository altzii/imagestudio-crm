/* imagestudio-crm */

CREATE TABLE users (
	id serial NOT NULL,
	enabled boolean NOT NULL DEFAULT false,
	email varchar(50) NOT NULL,
	first_name varchar(50),
	last_name varchar(50),
	password varchar(100),
);

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY (id);


CREATE TABLE roles (
	id serial NOT NULL,
	name varchar(20)
);

ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY (id);


CREATE TABLE roles_users (
	user_id int
	role_id int
);

ALTER TABLE roles_users ADD CONSTRAINT roles_users_users_fk FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE roles_users ADD CONSTRAINT roles_users_roles_fk FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE roles_users ADD CONSTRAINT roles_users_pk PRIMARY KEY (user_id, role_id);

