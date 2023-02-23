CREATE TABLE superheroPower (	
  superhero_id INTEGER NOT NULL,
  power_id INTEGER NOT NULL,
  PRIMARY KEY (superhero_id, power_id),
  FOREIGN KEY (superhero_id) REFERENCES superhero (superhero_id),
  FOREIGN KEY (power_id) REFERENCES powers (powers_id)
);