DELIMITER $$

CREATE TRIGGER country_insert_trigger
AFTER INSERT
  ON country
FOR EACH ROW
  BEGIN
    INSERT INTO country_history (
      id,
      name,
      isActive,
      updatedBy,
      updatedOn,
      timestamp,
      action)
    VALUES(
        NEW.id,
        NEW.name,
        NEW.isActive,
        NEW.updatedBy,
        NEW.updatedOn,
        now(),
        'I');
  END;
$$

DELIMITER $$

CREATE TRIGGER country_update_trigger
AFTER UPDATE
  ON country
FOR EACH ROW
  BEGIN
    INSERT INTO country_history (
      id,
      name,
      isActive,
      updatedBy,
      updatedOn,
      timestamp,
      action)
    VALUES (
      NEW.id,
      NEW.name,
      NEW.isActive,
      NEW.updatedBy,
      NEW.updatedOn,
      now(),
      'U');
  END;
$$

DELIMITER $$

CREATE TRIGGER country_delete_trigger
AFTER DELETE
  ON country
FOR EACH ROW
  BEGIN
    INSERT INTO country_history (
      id,
      name,
      isActive,
      updatedBy,
      updatedOn,
      timestamp,
      action)
    VALUES (
      OLD.id,
      OLD.name,
      OLD.isActive,
      OLD.updatedBy,
      OLD.updatedOn,
      now(),
      'D');
  END;
$$

DELIMITER ;