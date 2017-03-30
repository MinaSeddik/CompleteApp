CREATE TABLE IF NOT EXISTS test.user (
  id          BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
  login       VARCHAR(30)  NOT NULL,
  password    VARCHAR(20)  NOT NULL,
  email       VARCHAR(30)  NOT NULL,
  firstName   VARCHAR(20)  NOT NULL,
  lastName    VARCHAR(20)  NOT NULL,
  phone       VARCHAR(20)  NOT NULL,
  roles       VARCHAR(100) NOT NULL,
  location_id BIGINT       NOT NULL,
  isActive    TINYINT      NOT NULL,
  updatedBy   BIGINT       NOT NULL,
  updatedOn   DATETIME     NOT NULL,
  FOREIGN KEY (location_id) REFERENCES location (id)
)