grant drop user to system
/

CREATE OR REPLACE PROCEDURE drop_user_if_exists (user_name VARCHAR2) AS
   BEGIN
      EXECUTE IMMEDIATE 'drop user ' || user_name || ' cascade';
   EXCEPTION WHEN OTHERS
     THEN
       IF SQLCODE = -01918 THEN
         NULL; -- ORA-01918 user does not exist
       ELSE#
         RAISE;
       END IF;
   END drop_user_if_exists;
/
