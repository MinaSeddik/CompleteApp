CREATE TABLE IF NOT EXISTS test.city_history (
  id         BIGINT      NOT NULL,
  name       VARCHAR(30) NOT NULL,
  country_id BIGINT      NOT NULL,
  isActive   TINYINT     NOT NULL,
  updatedBy  BIGINT      NOT NULL,
  updatedOn  DATETIME    NOT NULL,

  timestamp  DATETIME    NOT NULL,
  action     CHAR        NOT NULL
)