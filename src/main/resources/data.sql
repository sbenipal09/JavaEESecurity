
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Jon', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into sec_role (roleName)
values ('ROLE_ADMIN');

insert into sec_role (roleName)
values ('ROLE_USER');

insert into sec_role (userName,encryptedPassword,1)
values ('Simmu','$2a$10$q.y2cVlRjdJENJheGuz.feu2RdX/eUf1VThpP6Ah4Iy93rkHUUHXe' , 1);

insert into user_role (userId, roleId)
values (3, 1);

insert into user_role (userId, roleId)
values (3, 2);

insert into user_role (userId, roleId)
values (3, 3);


insert into user_role (userId, roleId)
values (1, 1);

insert into user_role (userId, roleId)
values (1, 2);

insert into user_role (userId, roleId)
values (2, 2);

