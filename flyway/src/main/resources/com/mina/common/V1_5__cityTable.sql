CREATE TABLE IF NOT EXISTS test.city (
  id         BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name       VARCHAR(30) NOT NULL,
  country_id BIGINT      NOT NULL,
  isActive   TINYINT     NOT NULL,
  updatedBy  BIGINT      NOT NULL,
  updatedOn  DATETIME    NOT NULL,
  FOREIGN KEY (country_id) REFERENCES country (id)
)