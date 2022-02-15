USE adlister_db;

INSERT INTO categories (name)
    VALUES ('free'),('used'),('new'),
           ('jobs'),('services'),('lost'),('wanted'),
           ('electronics'),('vehicles'),('pets'),('furniture');

INSERT INTO ads (user_id, title, description)
    VALUES (1,'Junk','Super cool pile of useless things'),
           (2,'RTX-3090','$5000 or your soul, no low ballers'),
           (3,'Ford Truck','The wheels work, rest is broken, must be towed or pushed'),
           (1,'General Labor','Hiring Now, $15/hr, Call 867-5309 ask for Jenny'),
           (2,'TV','248 Inch 4k TV, cords not included'),
           (4,'Tacos','Yum Taco Truck Wed-Thurs at Main and 1st Street!'),
           (1,'Misc DVDs','Various DVDs 1970 to 1989, Lots of Bronson, Norris, etc'),
           (2,'PC Services','Will clean and repair your broken stuff! Call 123-4567'),
           (3,'Maid Service','We clean stuff');
