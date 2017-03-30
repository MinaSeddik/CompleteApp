DELIMITER $$

CREATE TRIGGER city_insert_trigger
AFTER INSERT
	ON city
FOR EACH ROW
	BEGIN
		INSERT INTO city_history (
			id,
			name,
			country_id,
			isActive,
			updatedBy,
			updatedOn,
			timestamp,
			action)
		VALUES (
			NEW.id,
			NEW.name,
			NEW.country_id,
			NEW.isActive,
			NEW.updatedBy,
			NEW.updatedOn,
			now(),
			'I');
	END;
$$

DELIMITER $$

CREATE TRIGGER city_update_trigger
AFTER UPDATE
	ON city
FOR EACH ROW
	BEGIN
		INSERT INTO city_history (
			id,
			name,
			country_id,
			isActive,
			updatedBy,
			updatedOn,
			timestamp,
			action)
		VALUES (
			NEW.id,
			NEW.name,
			NEW.country_id,
			NEW.isActive,
			NEW.updatedBy,
			NEW.updatedOn,
			now(),
			'U');
	END;
$$

DELIMITER $$

CREATE TRIGGER city_delete_trigger
AFTER DELETE
	ON city
FOR EACH ROW
	BEGIN
		INSERT INTO city_history (
			id,
			name,
			country_id,
			isActive,
			updatedBy,
			updatedOn,
			timestamp,
			action)
		VALUES (
			OLD.id,
			OLD.name,
			OLD.country_id,
			OLD.isActive,
			OLD.updatedBy,
			OLD.updatedOn,
			now(),
			'D');
	END;
$$

DELIMITER ;