CREATE TABLE IF NOT EXISTS test.location (
  id        BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  address1  VARCHAR(50) NOT NULL,
  address2  VARCHAR(50) NOT NULL,
  city_id   BIGINT      NOT NULL,
  isActive  TINYINT     NOT NULL,
  updatedBy BIGINT      NOT NULL,
  updatedOn DATETIME    NOT NULL,
  FOREIGN KEY (city_id) REFERENCES city (id)
)
