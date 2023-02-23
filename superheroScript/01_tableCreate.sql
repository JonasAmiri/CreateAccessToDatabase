DROP TABLE IF EXISTS superheroPower CASCADE;
DROP TABLE IF EXISTS assistant CASCADE;
DROP TABLE IF EXISTS powers CASCADE;
DROP TABLE IF EXISTS superhero CASCADE;


CREATE TABLE superhero ( 
	superhero_id serial PRIMARY KEY,
	superhero_name varchar(50) NOT NULL,
	superhero_alias varchar(50) NOT NULL,
	superhero_origin varchar(50) NOT NULL
);

CREATE TABLE assistant(	
	assistant_id serial PRIMARY KEY,
	assistant_name varchar(50) NOT NULL
	
);

CREATE TABLE powers (
	powers_id serial PRIMARY KEY,
	powers_name varchar(50) NOT NULL,
	powers_description varchar(50) NOT NULL,
	superhero_id int
);

