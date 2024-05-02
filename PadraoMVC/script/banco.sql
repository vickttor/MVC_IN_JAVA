DROP DATABASE ams20241;

CREATE database IF NOT EXISTS ams20241;

CREATE TABLE ams20241.users (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  password VARCHAR(255),
  status VARCHAR(255),
  type VARCHAR(255),
  primary key (id)
);

CREATE TABLE ams20241.clients (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  cpf VARCHAR(255),
  tel VARCHAR(255),
  address VARCHAR(255),
  primary key (id)
);

CREATE TABLE ams20241.pets (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    gender ENUM('Male', 'Female'),
    age INT UNSIGNED,
    primary key (id)
);


-- My new Relational Table
CREATE TABLE ams20241.clients_pets (
    id BIGINT NOT NULL AUTO_INCREMENT,
    idC BIGINT NOT NULL,
    idP BIGINT NOT NULL,
    obs VARCHAR(255),
    primary key (id)
);

-- Altering the tables to have foreing keys
ALTER TABLE ams20241.clients_pets ADD CONSTRAINT fk_ce FOREIGN KEY (idC) REFERENCES ams20241.clients(id);
ALTER TABLE ams20241.clients_pets ADD CONSTRAINT fk_pc FOREIGN KEY (idP) REFERENCES ams20241.pets(id);

-- Inserting datas
INSERT INTO `ams20241`.`users` (`login`, `password`, `status`, `type`) VALUES ('victor@gmail.com', 'Visi@dev1', 'ATIVO', 'ADM');
INSERT INTO `ams20241`.`users` (`login`, `password`, `status`, `type`) VALUES ('lincon@hotmail.com', 'marjoire@$1', 'ATIVO', 'COLLABORATOR');
INSERT INTO `ams20241`.`users` (`login`, `password`, `status`, `type`) VALUES ('roberto@ibm.com', 'robertin01', 'ATIVO', 'ADM');

INSERT INTO `ams20241`.`clients` (`name`, `cpf`, `tel`, `address`) VALUES ('Hector', '872.543.110-20', '+55 (92) 4351-5004', 'Quadra 84 943 Felícia Marginal, Costa da Caparica, AZ 1426');
INSERT INTO `ams20241`.`clients` (`name`, `cpf`, `tel`, `address`) VALUES ('Sophia', '118.634.280-38', '+55 (27) 5990-3691', 'Casa 9 170 Marcelo Avenida, Santiago do Cacém, NY 8404');
INSERT INTO `ams20241`.`clients` (`name`, `cpf`, `tel`, `address`) VALUES ('Carlos', '363.519.190-61', '+55 (68) 0374-5719', '4157 Melo Alameda, Alcácer do Sal, IL 5115');

INSERT INTO `ams20241`.`pets` (`name`, `gender`, `age`) VALUES ('Mel', 'Female', 7);
INSERT INTO `ams20241`.`pets` (`name`, `gender`, `age`) VALUES ('Pipoca', 'Female', 6);
INSERT INTO `ams20241`.`pets` (`name`, `gender`, `age`) VALUES ('Max', 'Male', 8);

