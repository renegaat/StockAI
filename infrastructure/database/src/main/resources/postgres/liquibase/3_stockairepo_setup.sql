call drop_user_if_exists ('stockairepo');

CREATE USER stockairepo
  IDENTIFIED BY "stockai"
  DEFAULT TABLESPACE stockairepo
  TEMPORARY TABLESPACE temp
  QUOTA UNLIMITED ON stockairepo;

GRANT CONNECT TO stockairepo;

GRANT RESOURCE TO stockairepo;
