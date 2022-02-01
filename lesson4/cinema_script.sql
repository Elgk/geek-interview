CREATE TABLE `cinema`.`film` (
  `id`       INT NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(255) NOT NULL,
  `duration` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
COMMENT = 'list of films';

CREATE TABLE `cinema`.`session` (
  `id`           INT NOT NULL AUTO_INCREMENT,
  `start_time`   DATETIME NOT NULL,
  `film_id`      INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_film_id_idx` (`film_id` ASC) VISIBLE,
  CONSTRAINT `fk_film_id`
    FOREIGN KEY (`film_id`)
    REFERENCES `cinema`.`film` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'timetable of sessions';

CREATE TABLE `cinema`.`price` (
  `id`         INT NOT NULL AUTO_INCREMENT,
  `session_id` INT NOT NULL,
  `price`      INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_session_id_idx` (`session_id` ASC) VISIBLE,
  CONSTRAINT `fk_session_id`
    FOREIGN KEY (`session_id`)
    REFERENCES `cinema`.`session` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'ticket price list';

CREATE TABLE `cinema`.`ticket` (
  `id`       INT NOT NULL AUTO_INCREMENT,
  `number`   INT NOT NULL,
  `price_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_price_id_idx` (`price_id` ASC) VISIBLE,
  CONSTRAINT `fk_price_id`
    FOREIGN KEY (`price_id`)
    REFERENCES `cinema`.`price` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'ticket sales ';