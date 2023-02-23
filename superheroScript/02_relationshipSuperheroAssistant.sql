
ALTER TABLE assistant
ADD superhero_id INTEGER,
ADD FOREIGN KEY (superhero_id) REFERENCES superhero(superhero_id);
