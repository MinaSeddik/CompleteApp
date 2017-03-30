CREATE OR REPLACE VIEW vw_city AS
  SELECT *
  FROM test.city
  WHERE isActive = TRUE
