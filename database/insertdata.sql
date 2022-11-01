Use luxhouse;

INSERT INTO roles(name) VALUES
('Adminitrator'),
('Users'),
('Gust')

INSERT INTO suppliers(supplier_code, supplier_name, decription) VALUES
('TP',N'Tien Phu Interior Co., Ltd',N'+84 901 557 218, +84 901 557 219'),
('EVN',N'Excel Viet Nam Company Limited',N'+84 797783229'),
('VC',N'Viet Cast Trading Production Company Limited',N'+84 903 112 786, +84 938 260 973')

INSERT INTO users(username, [password], fullname, gender, email, dob, phone, [address]) VALUES
('admin','admin',N'Administrator',0,'administrator@gmail.com','1-01-2002','0999999999',N'Công viên phẩn mềm Quang Trung'),
('huylth','1234',N'Lê Trần Hoàng Huy',0,'huyletran007@gmail.com','02-16-2002','0765230162',N'Đường Nguyễn Văn Luông')

INSERT INTO authorities([user_id], [role_id]) VALUES
(1,1),
(2,2)

INSERT INTO payment_types(payment_code, payment_name, [description]) VALUES
('BANKING',N'Chuyển khoảng ngân hàng Vietcombank','1018032534'),
('COD','Ship cod',N'Chuyển hàng và thu tiền'),
('MOMO',N'Chuyển Tiền qua MOMO','0765230162')

INSERT INTO categories(category_code, category_name) VALUES
('D-ROM','Dining room'),
('L-ROOM','Living room'),
('B-ROOM','Bed room'),
('OUTDOOR','Outdoor')

INSERT INTO category_products(category_product_code, category_product_name, category_id) VALUES
('D-TABLES',N'Dining Tables',1),
('D-CHAIR-1',N'Dining Chairs',1),
('D-CHAIR-2',N'Seat Cushions',1),
('L-SOFA',N'Living Room Sofa',2),
('L-TABLE',N'Tea Table',2),
('L-RACK',N'Living Room Racks',2),
('L-CHAIR',N'Living Room Armchair',2),
('B-BED-1',N'Bed',3),
('B-BED-2',N'Children Bed',3),
('B-BED-3',N'Daybeds',3),
('B-CABINET',N'Bedside Cabinet',3),
('O-SOFA',N'Outdoor Sofas',4),
('O-CHAIR-1',N'Outdoor Chairs',4),
('O-TABLE',N'Outdoor Coffee & Side Tables',4),
('O-CHAIR-2',N'Sun Lounger',4)

INSERT INTO products(product_code, product_name, [image], price, category_product_id) VALUES
('',N'','',,)

INSERT INTO product_images(product_id, [image]) VALUES
(,'')


