DROP TABLE IF EXISTS people;

CREATE TABLE people (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  cpf VARCHAR(20) NOT NULL,
  age INT DEFAULT NULL,
  gender VARCHAR(20) NOT NULL
);
ALTER TABLE people ADD CONSTRAINT UNIQUE_PEOPLE_CPF UNIQUE (cpf);
ALTER TABLE people ADD CONSTRAINT UNIQUE_PEOPLE_EMAIL UNIQUE (email);
commit;

INSERT INTO people (name, email, cpf, age, gender) VALUES
('Rodrigo Fournier', 'rodrigo.fournier@b2wdigital.com', '12345678910', 35, 'Masculino'),
('Diogo Gomes', 'diogo.gomes@b2wdigital.com', '10987654321', 35, 'Masculino'),
('Luiza Leal', 'luiza.leal@b2wdigital.com', '45612398701', 23, 'Feminino');
