CREATE TABLE IF NOT EXISTS test.location_history (
  id        BIGINT      NOT NULL,
  address1  VARCHAR(50) NOT NULL,
  address2  VARCHAR(50) NOT NULL,
  city_id   BIGINT      NOT NULL,
  isActive  TINYINT     NOT NULL,
  updatedBy BIGINT      NOT NULL,
  updatedOn DATETIME    NOT NULL,

  timestamp DATETIME    NOT NULL,
  action    CHAR        NOT NULL
)