DELIMITER $$

CREATE TRIGGER location_insert_trigger
AFTER INSERT
	ON location
FOR EACH ROW
	BEGIN
		INSERT INTO location_history (
			id,
			address1,
			address2,
			city_id,
			isActive,
			updatedBy,
			updatedOn,
			timestamp,
			action)
		VALUES (
			NEW.id,
			NEW.address1,
			NEW.address2,
			NEW.city_id,
			NEW.isActive,
			NEW.updatedBy,
			NEW.updatedOn,
			now(),
			'I');
	END;
$$

DELIMITER $$

CREATE TRIGGER location_update_trigger
AFTER UPDATE
	ON location
FOR EACH ROW
	BEGIN
		INSERT INTO location_history (
			id,
			address1,
			address2,
			city_id,
			isActive,
			updatedBy,
			updatedOn,
			timestamp,
			action)
		VALUES (
			NEW.id,
			NEW.address1,
			NEW.address2,
			NEW.city_id,
			NEW.isActive,
			NEW.updatedBy,
			NEW.updatedOn,
			now(),
			'U');
	END;
$$

DELIMITER $$

CREATE TRIGGER location_delete_trigger
AFTER DELETE
	ON location
FOR EACH ROW
	BEGIN
		INSERT INTO location_history (
			id,
			address1,
			address2,
			city_id,
			isActive,
			updatedBy,
			updatedOn,
			timestamp,
			action)
		VALUES (
			OLD.id,
			OLD.address1,
			OLD.address2,
			OLD.city_id,
			OLD.isActive,
			OLD.updatedBy,
			OLD.updatedOn,
			now(),
			'D');

	END;
$$

DELIMITER ;