insert into address  (street1, street2, city, province, zip_code) values ('street1' ,'street2','Innopolis','Tatarstan','430500');
insert into address  (street1, street2, city, province, zip_code) values ('street1' ,'street2','Kazan','Tatarstan','430500');
insert into address  (street1, street2, city, province, zip_code) values ('street1' ,'street2','Naberezhnie Chelny','Tatarstan','430500');

insert into restaurants  (name, email, phone_number) values ('Amore','mail@amore.com','88008008070');
insert into restaurants  (name, email, phone_number) values ('Dolche vita','mail@dolche.com','88008008080');
insert into restaurants  (name, email, phone_number) values ('Georgia','mail@georgia.com','88008008090');


insert into products  (name, description, cost_price, restaurant_id) values ('Borsch','Soup with borsch',60.00, 1);
insert into products  (name, description, cost_price, restaurant_id) values ('Pasta','Pasta with  mushroom sauce', 100.00, 1);
insert into products  (name, description, cost_price, restaurant_id) values ('Tea','Black tea', 30.00, 1);

insert into lunch_sets (description, restaurant_id) values ('Main lunchset for first restaurant',1);
insert into lunch_sets (description, restaurant_id) values ('Second lunchset for first restaurant', 1);
insert into lunch_sets (description, restaurant_id) values ('Main lunchset for second restaurant', 2);
insert into lunch_sets (description, restaurant_id) values ('Second lunchset for second restaurant', 2);

insert into lunchset_product (lunchset_id, product_id) values (1,1);
insert into lunchset_product (lunchset_id, product_id) values (1,2);

