CREATE OR REPLACE VIEW vw_user AS
  SELECT *
  FROM test.user
  WHERE isActive = TRUE
