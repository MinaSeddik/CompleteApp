CREATE TABLE IF NOT EXISTS test.country (
  id         BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name       VARCHAR(30) NOT NULL,
  isActive   TINYINT     NOT NULL,
  updatedBy  BIGINT      NOT NULL,
  updatedOn  DATETIME    NOT NULL
)