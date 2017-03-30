DELIMITER $$

CREATE TRIGGER user_insert_trigger
AFTER INSERT
	ON user
FOR EACH ROW
	BEGIN
		INSERT INTO user_history (
			id,
			login,
			password,
			email,
			firstName,
			lastName,
			phone,
			roles,
			location_id,
			isActive,
			updatedBy,
			updatedOn,
			timestamp,
			action)
		VALUES (
			NEW.id,
			NEW.login,
			NEW.password,
			NEW.email,
			NEW.firstName,
			NEW.lastName,
			NEW.phone,
			NEW.roles,
			NEW.location_id,
			NEW.isActive,
			NEW.updatedBy,
			NEW.updatedOn,
			now(),
			'I');
	END;
$$
#
# DELIMITER $$
#
# CREATE TRIGGER user_update_trigger
# AFTER UPDATE
# 	ON user
# FOR EACH ROW
# 	BEGIN
# 		INSERT INTO user_history (
# 			id,
# 			login,
# 			password,
# 			email,
# 			firstName,
# 			lastName,
# 			phone,
# 			roles,
# 			location_id,
# 			isActive,
# 			updatedBy,
# 			updatedOn,
# 			timestamp,
# 			action)
# 			VALUES (
# 				NEW.id,
# 				NEW.login,
# 				NEW.password,
# 				NEW.email,
# 				NEW.firstName,
# 				NEW.lastName,
# 				NEW.phone,
# 				NEW.roles,
# 				NEW.location_id,
# 				NEW.isActive,
# 				NEW.updatedBy,
# 				NEW.updatedOn,
# 				now(),
# 				'U');
# 	END;
# $$
#
# DELIMITER $$
#
# CREATE TRIGGER user_delete_trigger
# AFTER DELETE
# 	ON user
# FOR EACH ROW
# 	BEGIN
# 		INSERT INTO user_history (
# 			id,
# 			login,
# 			password,
# 			email,
# 			firstName,
# 			lastName,
# 			phone,
# 			roles,
# 			location_id,
# 			isActive,
# 			updatedBy,
# 			updatedOn,
# 			timestamp,
# 			action)
# 		VALUES(
# 				OLD.id,
# 				OLD.login,
# 				OLD.password,
# 				OLD.email,
# 				OLD.firstName,
# 				OLD.lastName,
# 				OLD.phone,
# 				OLD.roles,
# 				OLD.location_id,
# 				OLD.isActive,
# 				OLD.updatedBy,
# 				OLD.updatedOn,
# 				now(),
# 				'D');
# 	END;
# $$
#
# DELIMITER ;