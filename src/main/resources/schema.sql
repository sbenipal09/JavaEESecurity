create table SEC_USER
(
	userId           BIGINT NOT NULL Primary Key AUTO_INCREMENT,
	userName         VARCHAR(36) NOT NULL UNIQUE,
	encryptedPassword VARCHAR(128) NOT NULL,
	ENABLED           BIT NOT NULL
) ;


create table SEC_ROLE
(
	roleId   BIGINT NOT NULL Primary Key AUTO_INCREMENT,
	roleName VARCHAR(30) NOT NULL UNIQUE
) ;
create table USER_ROLE
(
	ID      BIGINT NOT NULL Primary Key AUTO_INCREMENT,
	userId BIGINT NOT NULL,
	roleId BIGINT NOT NULL
);