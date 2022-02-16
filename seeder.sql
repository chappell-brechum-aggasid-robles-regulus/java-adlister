USE adlister_db;

INSERT INTO categories (name)
    VALUES ('free'),('used'),('new'),
           ('jobs'),('services'),('lost'),('wanted'),
           ('electronics'),('vehicles'),('pets'),('furniture');

INSERT INTO ads(title, description)
    VALUES ('Junk','Super cool pile of useless things'),
           ('RTX-3090','$5000 or your soul, no low ballers'),
           ('Ford Truck','The wheels work, rest is broken, must be towed or pushed'),
           ('General Labor','Hiring Now, $15/hr, Call 867-5309 ask for Jenny'),
           ('TV','248 Inch 4k TV, cords not included'),
           ('Tacos','Yum Taco Truck Wed-Thurs at Main and 1st Street!'),
           ('Misc DVDs','Various DVDs 1970 to 1989, Lots of Bronson, Norris, etc'),
           ('PC Services','Will clean and repair your broken stuff! Call 123-4567'),
           ('Maid Service','We clean stuff');
