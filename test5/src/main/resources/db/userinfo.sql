
CREATE TABLE userinfo(name VARCHAR(16) NOT NULL PRIMARY KEY,password VARCHAR(16) NOT NULL)

insert into userinfo values ('test','9981')
insert into userinfo values ('ace','5598')
insert into userinfo values ('first','9989')
insert into userinfo values ('yeah','998')
insert into userinfo values ('zzz','9978')
insert into userinfo values ('kyung','99998')
insert into userinfo values ('1234','99778')
insert into userinfo values ('12366','99811')
insert into userinfo values ('15311','95598')
insert into userinfo values ('15322','95598')
insert into userinfo values ('15333','95598')
insert into userinfo values ('15223','95598')
insert into userinfo values ('1513','95598')
insert into userinfo values ('1523','95598')
insert into userinfo values ('1543','955198')
insert into userinfo values ('15993','95598')
insert into userinfo values ('1tt53','95598')
insert into userinfo values ('16653','95598')
insert into userinfo values ('19953','95598')
/*
/*인덱스 설정*/
CREATE INDEX userinfo_index on userinfo(name);

/*함수 설정*/
CREATE or REPLACE FUNCTION userinfo_function1 (test VARCHAR2) RETURN VARCHAR2 
	IS num1 NUMBER;
    
	BEGIN
	    
  	IF TEST = 'EX1' THEN
      SELECT count(*) INTO  num1 FROM userinfo;
      
 	ELSIF TEST = 'EX2' THEN
        select count(*)+10 INTO  num1 FROM userinfo;
        
    END IF;
    
      RETURN num1;
        
	END userinfo_function1;
*/