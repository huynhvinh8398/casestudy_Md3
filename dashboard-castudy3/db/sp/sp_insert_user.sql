CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_user`(
	IN user_user_name VARCHAR(100),
    IN user_password VARCHAR(100),
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

INSERT INTO users(user_name, password, full_name , phone, email, address)
VALUES (user_user_name, user_password, user_full_name , user_phone, user_email, user_address);
END IF;
END IF;

END