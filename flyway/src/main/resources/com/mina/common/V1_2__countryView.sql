CREATE OR REPLACE VIEW vw_county AS
  SELECT *
  FROM test.country
  WHERE isActive = TRUE
