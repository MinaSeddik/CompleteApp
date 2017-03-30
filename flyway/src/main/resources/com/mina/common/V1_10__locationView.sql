CREATE OR REPLACE VIEW vw_location AS
  SELECT *
  FROM test.location
  WHERE isActive = TRUE
