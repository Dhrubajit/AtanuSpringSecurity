-- The encrypted client_secret it `secret`
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
  VALUES ('client123', '{bcrypt}$2a$10$vCXMWCn7fDZWOcLnIEhmK.74dvK1Eh8ae2WrWlhr2ETPLoxQctN4.', 'read,write', 'password,refresh_token,client_credentials', 'ROLE_CLIENT', 900, 7200);

-- The encrypted password is `pass`
INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (1, 'user', '{bcrypt}$2a$10$cyf5NfobcruKQ8XGjUJkEegr9ZWFqaea6vjpXWEaSqTa2xL9wjgQC', 1);
INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (2, 'guest', '{bcrypt}$2a$10$cyf5NfobcruKQ8XGjUJkEegr9ZWFqaea6vjpXWEaSqTa2xL9wjgQC', 1);
INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (2, 'atanu', '{bcrypt}$2a$10$2eZZxaWBHRbzH4zwS8R8Ne.yThyyE1aRTZ77uEjNT8yBSImg2H33e', 1);

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('user', 'ROLE_USER');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('guest', 'ROLE_GUEST');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('atanu', 'ROLE_ADMIN');
