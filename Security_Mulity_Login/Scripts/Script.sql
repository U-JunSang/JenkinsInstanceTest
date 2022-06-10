CREATE TABLE SECURITY_LOGIN(
ID VARCHAR2(50),
PW VARCHAR2(1000),
AUTH VARCHAR2(10),
NAME VARCHAR2(20)
);

INSERT INTO SECURITY_LOGIN
(ID, PW, AUTH, NAME)
VALUES('nobrand01', '1234', 'ROLE_Admin', '노브랜드');

SELECT PW, AUTH 
FROM SECURITY_LOGIN
WHERE ID = 'nobrand01';

SELECT * FROM SECURITY_LOGIN s;

--<select id="loginChk" parameterType="String" resultType="MDto">
--  SELECT PW, AUTH 
--	FROM SECURITY_LOGIN
--		WHERE ID = #{id}
--</select>
--
--<insert id="signUp" parameterType="MDto">
--INSERT INTO SECURITY_LOGIN
--(ID, PW, AUTH, NAME)
--VALUES(#{id}, #{pw}, 'ROLE_User', #{name})
--</insert>
