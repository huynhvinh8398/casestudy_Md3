CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_user`(
	IN user_user_name VARCHAR(100),
    IN user_full_name VARCHAR(100),
    IN user_phone VARCHAR(50),
    In user_email VARCHAR(100),
    IN user_address VARCHAR(100),
    OUT success BOOLEAN,
    OUT message VARCHAR(100)
)
BEGIN
	DECLARE count_phone VARCHAR(100);
    DECLARE count_email VARCHAR(100);

    SET count_phone = (SELECT count(*) FROM users AS u WHERE u.phone = user_phone);
	SET count_email = (SELECT count(*) FROM users AS u WHERE u.email = user_email);
    SET success = FALSE;

    IF(count_phone > 0)
    THEN
		SET message = "Phone exists";
ELSE
        IF (count_email > 0)
        THEN
			SET message = "Email exist";
ELSE
		SET success = TRUE;

UPDATE users AS u
SET
    u.user_name = user_user_name,
    u.full_name = user_full_name,
    u.phone = user_phone,
    u.email = user_email,
    u.address = user_address;
END IF;
END IF;

END