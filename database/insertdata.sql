﻿Use luxhouse;

INSERT INTO roles(name) VALUES
('Adminitrator'),
('Users')

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
 ('D-TABLES',N'Ellington Side Table','Ellington_Side_Table_White1.jpg', 7599000, 1),
 ('D-TABLES',N'Woodside Table','Woodside_Table1.jpg', 134999000, 1),
 ('D-TABLES',N'Beach House Breakfast Table','Breakfast_Table1.jpg', 59999000, 1),
 ('D-CHAIR-1',N'Riviera Dining Chair','Riviera_Dining_Chair1.jpg', 9590000, 2),
 ('D-CHAIR-1',N'Tucker Dining Chair','Tucker_Dining_Chair1.jpg', 6200000, 2),
 ('D-CHAIR-1',N'Avalon Dining Chair','AvalonDiningChair1.jpg', 17000000, 2),
 ('D-CHAIR-2',N'Cushion Cover for Balboa Side Chair - Mist','BalboaSideChair1.jpg', 4000000, 3),
 ('D-CHAIR-2',N'Venice Rattan Chair Cushion','VeniceRattanChairCushion1.jpg', 3500000, 3),
 ('D-CHAIR-2',N'Cushion Cover for Balboa Counter Stool - Natural','BalboaCounterStool1.jpg', 4000000, 3),
 ('L-SOFA',N'Barton Sofa','BartonSofa1.jpg', 125000000, 4),
 ('L-SOFA',N'Beach House Sofa','BeachHouseSofa1.jpg', 160000000, 4),
 ('L-SOFA',N'Grady Sofa','GradySofa1.jpg', 125000000, 4),
 ('L-TABLE',N'Crosby Teak Expandable Dining Table','DiningTable1.jpg', 100000000, 5),
 ('L-TABLE',N'Teak Garden Table','TeakGardenTable1.jpg', 35000000, 5),
 ('L-TABLE',N'Terrace Teak Dining Table','TerraceTeakDiningTable1.jpg', 50000000, 5),
 ('L-RACK',N'Balboa Wide Bookshelf','BalboaWideBookshelf1.jpg', 100000000, 6),
 ('L-RACK',N'Driftway Bookshelf','DriftwayBookshelf1.jpg', 100000000, 6),
 ('L-RACK',N'Balboa Bookshelf','BalboaBookshelf1.jpg', 70000000, 6),
 ('L-CHAIR',N'Mattituck Armchair','MattituckArmchair1.jpg', 35000000, 7),
 ('L-CHAIR',N'Driftwood Armchair','DriftwoodArmchair1.jpg', 25000000, 7),
 ('L-CHAIR',N'Catalina Armchair','CatalinaArmchair1.jpg', 10000000, 7),
 ('B-BED-1',N'Hughes Bed','HughesBed1.jpg', 65000000, 8),
 ('B-BED-1',N'Webster Bed','WebsterBed1.jpg', 45000000, 8),
 ('B-BED-1',N'Avalon Bed','AvalonBed1.jpg', 65000000, 8),
 ('B-BED-2',N'Kids Avalon Daybed','Daybed1.jpg', 25000000, 9),
 ('B-BED-2',N'Webster Convertible Crib','WebsterConvertibleCrib1.jpg', 50000000, 9),
 ('B-BED-2',N'Harbour Cane Convertible Crib','HarbourCaneConvertibleCrib1.jpg', 45000000, 9),
 ('B-BED-3',N'Avalon Daybed','Avalon_Daybed1.jpg', 35000000, 10),
 ('B-BED-3',N'Presidio Trundle Daybed','PresidioTrundleDaybed1.jpg', 80000000, 10),
 ('B-BED-3',N'Broderick Daybed','BroderickDaybed1.jpg', 95000000, 10),
 ('B-CABINET',N'Ellington Side Table','EllingtonSideTable1.jpg', 7500000, 11),
 ('B-CABINET',N'Driftway Wide Nightstand','DriftwayWideNightstand1.jpg', 50000000, 11),
 ('B-CABINET',N'Hunter Side Table','HunterSideTable1.jpg', 17000000, 11),
 ('O-SOFA',N'Tofino Sofa','TofinoSofa1.jpg', 120000000, 12),
 ('O-SOFA',N'Pacifica Sofa','PacificaSofa1.jpg', 100000000, 12),
 ('O-SOFA',N'Pacifica Loveseat','PacificaLoveseat1.jpg', 8500000, 12),
 ('O-CHAIR-1',N'Tofino Swivel Chair','TofinoSwivelChair1.jpg', 7000000, 13),
 ('O-CHAIR-1',N'Pacifica Swivel Chair','PacificaSwivelChair1.jpg', 6000000, 13),
 ('O-CHAIR-1',N'Capistrano Lounge Chair','CapistranoLoungeChair1.jpg', 45000000, 13),
 ('O-TABLE',N'Boonville Coffee Table','BoonvilleCoffeeTable1.jpg', 6000000, 14),
 ('O-TABLE',N'Trestle Outdoor Coffee Table','TrestleOutdoorCoffeeTable1.jpg', 45000000, 14),
 ('O-TABLE',N'Bamileke Coffee Table','BamilekeCoffeeTable1.jpg', 60000000, 14),
 ('O-CHAIR-2',N'Tide Stripe Beach Chair','TideStripeBeachChair1.jpg', 5000000, 15),
 ('O-CHAIR-2',N'Teak Beach Chair','TeakBeachChair1.jpg', 7500000, 15),
 ('O-CHAIR-2',N'Teak Sling Chair','TeakSlingChair1.jpg', 10000000, 15),
 ('D-TABLES',N'Beach House Expandable','Furn_Beach_House_Expandable_Dining_Table_Sun_Bleached_Pine_Angle_MV_0031_Crop_SH.jpg', 95582185, 1),
 ('D-TABLES',N'California Dining Table','Furn_California_Dining_Table_White_Angle_MV_1501_Crop_SH.jpg', 78830445 , 1),
 ('D-TABLES',N'Balboa Dining Table','Furn_Balboa_Dining_Table_Angle_MV_0147_Crop_SH.jpg', 95562195, 1),
 ('D-CHAIR-1',N'Riviera Dining Chair','Furn_Riviera_Armchair_White_Black_NEW_WEAVE_Angle_MV_0339_Crop_SH.jpg', 9035145, 2),
 ('D-CHAIR-1',N'Sunwashed Riviera Dining Chair','Furn_Sunwashed_Riviera_Dining_Side_Chair_Mist_Angle_NK_5189_SH.jpg', 7840020, 2),
 ('D-CHAIR-1',N'Hughes Dining Chair','Furn_Hughes_Arm_Chair_Blue_Angle_SM_2352_SH.jpg', 19078584, 2),
 ('D-CHAIR-2',N'Cushion Cover for Islesboro Chair','Cushion_Cover_for_Islesboro_Chair.jpg', 3539420, 3),
 ('D-CHAIR-2',N'Cushion Cover for Avalon Dining Chair','avalon_dining_chair_perennials_white.jpg', 3539420, 3),
 ('D-CHAIR-2',N'Cushion Cover for Mattituck Armchair','Cushion_Cover_for_Mattituck_Armchair.jpg', 6400000, 3),
 ('L-SOFA',N'Eastgate Sofa - Slipcovered','Eastgate Sofa_Slipcovered.jpg', 150616670, 4),
 ('L-SOFA',N'Cutler Sofa - Sky Washed Linen with White Applied Border','Furn_Cutler_Sofa_Washed_Linen_With_White_Taping_MV_0087_Crop_SH.jpg', 167357170, 4),
 ('L-SOFA',N'Edgewater Sofa','Edgewater_Sofa.jpg', 78870021, 4),
 ('L-TABLE',N'South Seas Side Cart','cart_sth_seas_sm_silo_Crop_SH.jpg', 1310.146, 5),
 ('L-TABLE',N'Scallop Side Table','Furn_Scallop_Rattan_Side_Table_MV_0129_Crop_SH.jpg', 14300871, 5),
 ('L-TABLE',N'St. Germain Stone Side Table','Furn_Saint_Germaine_Side_Table_MV_Crop_SH.jpg', 40606821, 5),
 ('L-CHAIR',N'Hanging Rattan Chair','chr_rttn_hng_front_silo_NoCrop_BASE.jpg', 11909421, 7),
 ('L-CHAIR',N'Double Hanging Rattan Chair','CH27-02_7.jpg', 23866671, 7),
 ('L-CHAIR',N'Yarmouth Swivel Chair','Furn_Yartmouth_Swivel_Chair_Natural_Per_Basketweave_Chalk_Angle_MV_431_Crop_SH.jpg', 42998271, 7),
 ('B-BED-1',N'Hughes Four Poster Bed','Furn_Hughes_Four_Poster_Bed_Natural_Angle_MJ_Crop_SH.jpg', 109958871, 8),
 ('B-BED-1',N'Balboa Bed','Furn_Balboa_Bed_Natural_MV_Crop_SH.jpg.jpg', 88435821, 8),
 ('B-BED-1',N'Harbour Cane Bed','Bed_Harbour_Cane_Low_Foot_Board_Natural_MV_0422_Crop_SH.jpg', 78870021, 8),
 ('B-BED-3',N'Presidio Trundle Daybed','mDB.jpg', 78870021, 10),
 ('B-BED-3',N'Miramar Chaise','mMRCHSU.jpg', 100393071, 10),
 ('B-BED-3',N'Bennett Chaise - Left','mBENCHSL.jpg', 124307571, 10),
 ('O-SOFA',N'Pacifica Sofa - Harbor Grey','m12323.jpg', 95610171, 12),
 ('O-SOFA',N'Hampton Modular Sofa','mOCVNAL.jpg', 181702371, 12),
 ('O-SOFA',N'Hampton Modular Armed Sofa','mOCVNSF.jpg', 193898766, 12),
 ('O-CHAIR-1',N'Pacifica Swivel Chair - Harbor Grey','m12704.jpg', 57346971, 13),
 ('O-CHAIR-1',N'Tofino Swivel Chair','m13952.jpg', 64521321, 13),
 ('O-CHAIR-1',N'Capistrano Lounge Chair - Light Dune','m13243.jpg', 42998271, 13),
 ('O-TABLE',N'Rockmere Coffee Table','Furn_Rockmere_Coffee_Table_White_MV_0779_Crop_SH.jpg', 46000000, 14),
 ('O-TABLE',N'Blithedale Coffee Table','Furn_Blithedale_Outdoor_Coffee_Table_White_TS_0706_Crop_SH.jpg', 46800000, 14),
 ('O-TABLE',N'Bamileke Coffee Table','Furn_Bamileke_Coffee_Table_MV_0478_Crop_SH.jpg', 54962415, 14),
 ('O-CHAIR-2',N'Outdoor Riviera Dining Chair','Furn_Riviera_Outdoor_Side_Chair_White_MV_0167_Crop_SH.jpg', 10715040, 15),
 ('O-CHAIR-2',N'Outdoor Riviera Dining Chair','Furn_Riviera_All_Weather_Arm_Chair_White_Chambray_Angle_MV_0071_Crop_SH.jpg', 13106790, 15),
 ('O-CHAIR-2',N'Outdoor Riviera Swivel Bar & Counter Stools','Furn_Outdoor_Riviera_Swivel_Counter_Stool_Dune_MV_0183_Crop_SH.jpg', 17411940, 15),
 ('D-TABLES',N'Terrace Round Dining Table','Terrace_Round_Dining_Table.jpg', 83637180, 1),
 ('D-TABLES',N'St. Germain Stone Dining Table','St_Germain_Stone_Dining_Table.jpg', 88409935, 1),
 ('D-TABLES',N'Downing Round Dining Table','Downing_Round_Dining_Table.jpg', 54927945, 1),
 ('D-CHAIR-1',N'Balboa Side Chair','Balboa_Side_Chair.jpg', 17401020, 2),
 ('D-CHAIR-1',N'Carson Dining Chair','Carson_Dining_Chair.jpg', 16687784, 2),
 ('D-CHAIR-1',N'Portside Dining Chair','Portside_Dining_Chair.jpg', 19084170, 2),
 ('D-CHAIR-2',N'Hanging Rattan Chair Cushion','Hanging_Rattan_Chair_Cushion.jpg', 3539420, 3),
 ('D-CHAIR-2',N'Double Hanging Rattan Chair Cushion','Double_Hanging_Rattan_Chair_Cushion.jpg', 4735170, 3),
 ('D-CHAIR-2',N'Hanging Rattan Bench Cushion','Hanging_Rattan_Bench_Cushion.jpg', 6409220, 3),
 ('L-SOFA',N'Eastgate Sofa','Eastgate_Sofa.jpg', 143442170, 4),
 ('L-SOFA',N'Chatham Sofa','Chatham_Sofa.jpg', 150616670, 4),
 ('L-SOFA',N'Cambridge Sofa','Cambridge_Sofa.jpg', 143442170, 4),
 ('L-TABLE',N'Hunter Side Table','Hunter_Side_Table.jpg', 15496596, 5),
 ('L-TABLE',N'Cape Side Table','Cape_Side_Table.jpg', 31041021, 5),
 ('L-TABLE',N'Rope Stool','Rope_Stool.jpg', 9517971, 5),
 ('L-RACK',N'Black_Rubic_and_Teak_Wall_Display Shelf','Black_Rubic_and_Teak_Wall_Display_Shelf.jpg', 140532014, 6),
 ('L-RACK',N'Industrial Storage Shelf w2 Shutter Doors','Industrial_Storage_Shelf_w2_Shutter_Doors.jpg', 10324084, 6),
 ('L-CHAIR',N'Elm Swivel Chair','Elm_Swivel_Chair.jpg', 81261471, 7),
 ('L-CHAIR',N'Elm Chair','Elm_Chair.jpg', 69304221, 7),
 ('L-CHAIR',N'Lakeshore Chair','Lakeshore_Chair.jpg', 76478571, 7),
 ('B-BED-1',N'Broderick Bed','Broderick_Bed.jpg', 93218721, 8),
 ('B-BED-1',N'Broderick Slipcovered Bed','Broderick_Slipcovered_Bed.jpg', 98001621, 8),
 ('B-BED-1',N'Tall Broderick Bed','Tall_Broderick_Bed.jpg', 105175971, 8),
 ('B-BED-2',N'Gingham Crib Sheet','Gingham_Crib_Sheet.jpg', 1147896, 9),
 ('B-BED-2',N'Seahaven Crib Sheet','Seahaven_Crib_Sheet.jpg', 1147896, 9),
 ('B-BED-2',N'Melville Crib Sheet','Melville_Crib_Sheet.jpg', 1147896, 9),
 ('B-BED-3',N'Spruce Street Sleeper Queen','Spruce_Street_Sleeper_Queen.jpg', 167374665, 10),
 ('B-BED-3',N'Grady Sleeper King','Grady_Sleeper_King.jpg', 181725165, 10),
 ('B-BED-3',N'Spruce Street Sleeper King','Spruce_Street_Sleeper_King.jpg', 198467415, 10),
 ('B-CABINET',N'Cabot Console','Cabot_Console.jpg', 47787165, 11),
 ('B-CABINET',N'Driftway Console','Driftway_Console.jpg', 59745915, 11),
 ('B-CABINET',N'Bar Island Console','Bar_Island_Console.jpg', 107580915, 11),
 ('O-SOFA',N'Springwood Hanging Daybed','Springwood_Hanging_Daybed.jpg', 83663415, 12),
 ('O-SOFA',N'Pacifica Bench','Pacifica_Bench.jpg', 35828415, 12),
 ('O-SOFA',N'Sundial Luxury Depth Sofa','Sundial_Luxury_Depth_Sofa.jpg', 246302415, 12),
 ('O-CHAIR-1',N'Capistrano Hanging Chair & Stand','Capistrano_Hanging_Chair_&_Stand.jpg', 40611915, 13),
 ('O-CHAIR-1',N'Catalina Rocker','Catalina_Rocker.jpg', 21477915, 13),
 ('O-CHAIR-1',N'Loring Chair','Loring_Chair.jpg', 17890290, 13),
 ('O-TABLE',N'Seabrook Outdoor Ottoman','Seabrook_Outdoor_Ottoman.jpg', 31044915, 14),
 ('O-TABLE',N'Bamileke Side Table','Bamileke_Side_Table.jpg', 21477915, 14),
 ('O-TABLE',N'Rockridge Side Table','Rockridge_Side_Table.jpg', 28653165, 14),
 ('O-CHAIR-2',N'Lawn Chaise','Lawn_Chaise.jpg', 7127415, 15),
 ('O-CHAIR-2',N'Salt Creek Chaise','Salt_Creek_Chaise.jpg', 57354165, 15),
 ('O-CHAIR-2',N'Crosby Teak Chaise Natural','Crosby_Teak_Chaise_Natural.jpg', 66921165, 15)

 go
 INSERT INTO product_images(product_id, [image]) VALUES
 ('1','Ellington_Side_Table_White2.jpg'),('1','Ellington_Side_Table_White3.jpg'),
 ('2','Woodside_Table2.jpg'),('2','Woodside_Table3.jpg'),
 ('3','Breakfast_Table2.jpg'),('3','Breakfast_Table3.jpg'),
 ('4','Riviera_Dining_Chair2.jpg'),('4','Riviera_Dining_Chair3.jpg'),
 ('5','Tucker_Dining_Chair2.jpg'),('5','Tucker_Dining_Chair3.jpg'),
 ('6', 'AvalonDiningChair2.jpg'),('6', 'AvalonDiningChair3.jpg'),
 ('7', 'BalboaSideChair2.jpg'),('7', 'BalboaSideChair3.jpg'),
 ('8', 'VeniceRattanChairCushion2.jpg'),('8', 'VeniceRattanChairCushion3.jpg'),
 ('9', 'BalboaCounterStool2.jpg'),('9', 'BalboaCounterStool3.jpg'),
 ('10', 'BartonSofa2.jpg'),('10', 'BartonSofa3.jpg'),
 ('11', 'BeachHouseSofa2.jpg'),('11', 'BeachHouseSofa3.jpg'),
 ('12', 'GradySofa2.jpg'),('12', 'GradySofa3.jpg'),
 ('13', 'DiningTable2.jpg'),('13', 'DiningTable3.jpg'),
 ('14', 'TeakGardenTable2.jpg'),('14', 'TeakGardenTable3.jpg'),
 ('15', 'TerraceTeakDiningTable2.jpg'),('15', 'TerraceTeakDiningTable3.jpg'),
 ('16', 'BalboaWideBookshelf2.jpg'),('16', 'BalboaWideBookshelf3.jpg'),
 ('17', 'DriftwayBookshelf2.jpg'),('17', 'DriftwayBookshelf3.jpg'),
 ('18', 'BalboaBookshelf2.jpg'),('18', 'BalboaBookshelf3.jpg'),
 ('19', 'MattituckArmchair2.jpg'),('19', 'MattituckArmchair3.jpg'),
 ('20', 'DriftwoodArmchair2.jpg'),('20', 'DriftwoodArmchair3.jpg'),
 ('21', 'CatalinaArmchair2.jpg'),('21', 'CatalinaArmchair3.jpg'),
 ('22', 'HughesBed2.jpg'),('22', 'HughesBed3.jpg'),
 ('23', 'WebsterBed2.jpg'),('23', 'WebsterBed3.jpg'),
 ('24', 'AvalonBed2.jpg'),('24', 'AvalonBed3.jpg'),
 ('25', 'Daybed2.jpg'),('25', 'Daybed3.jpg'),
 ('26', 'WebsterConvertibleCrib2.jpg'),('26', 'WebsterConvertibleCrib3.jpg'),
 ('27', 'HarbourCaneConvertibleCrib2.jpg'),('27', 'HarbourCaneConvertibleCrib3.jpg'),
 ('28', 'Avalon_Daybed2.jpg'),('28', 'Avalon_Daybed3.jpg'),
 ('29', 'PresidioTrundleDaybed2.jpg'),('29', 'PresidioTrundleDaybed3.jpg'),
 ('30', 'BroderickDaybed2.jpg'),('30', 'BroderickDaybed3.jpg'),
 ('31', 'EllingtonSideTable2.jpg'),('31', 'EllingtonSideTable3.jpg'),
 ('32', 'DriftwayWideNightstand2.jpg'),('32', 'DriftwayWideNightstand3.jpg'),
 ('33', 'HunterSideTable2.jpg'),('33', 'HunterSideTable3.jpg'),
 ('34', 'TofinoSofa2.jpg'),('34', 'TofinoSofa3.jpg'),
 ('35', 'PacificaSofa2.jpg'),('35', 'PacificaSofa3.jpg'),
 ('36', 'PacificaLoveseat2.jpg'),('36', 'PacificaLoveseat3.jpg'),
 ('37', 'TofinoSwivelChair2.jpg'),('37', 'TofinoSwivelChair3.jpg'),
 ('38', 'PacificaSwivelChair2.jpg'),('38', 'PacificaSwivelChair3.jpg'),
 ('39', 'CapistranoLoungeChair2.jpg'),('39', 'CapistranoLoungeChair3.jpg'),
 ('40', 'BoonvilleCoffeeTable2.jpg'),('40', 'BoonvilleCoffeeTable3.jpg'),
 ('41', 'TrestleOutdoorCoffeeTable2.jpg'),('41', 'TrestleOutdoorCoffeeTable3.jpg'),
 ('42', 'BamilekeCoffeeTable2.jpg'),('42', 'BamilekeCoffeeTable3.jpg'),
 ('43', 'TideStripeBeachChair2.jpg'),('43', 'TideStripeBeachChair3.jpg'),
 ('44', 'TeakBeachChair2.jpg'),('44', 'TeakBeachChair3.jpg'),
 ('45', 'TeakSlingChair2.jpg'),('45', 'TeakSlingChair3.jpg'),
 ('46','Furn_Beach_House_Dining_Table_Salt_Washed_84in_Extension_Angle_MV_0057_Crop_SH.jpg'),
 ('47','Furn_California_Dining_Table_White_Angle_MV_1501_Crop_SH.jpg'),
 ('48','Furn_Balboa_Bed_Natural_MV_Crop_SH.jpg'),('48','Furn_Balboa_Dining_Table_MV_0137_Crop_SH.jpg'),
 ('49','Furn_Riviera_Armchair_White_Black_NEW_WEAVE_MV_0329_Crop_SH.jpg'),
 ('50','Furn_Sunwashed_Riviera_Dining_Side_Chair_NK_5241_SH.jpg'),('50','Furn_Sunwashed_Riviera_Dining_Arm_Chair_Mist_Detail_NK_5453_BASE.jpg'),
 ('51', 'Furn_Hughes_Arm_Chair_Blue_2252_SM_Crop_SH.jpg'),
 ('52', 'Cushion_Cover_for_Islesboro_Chair.jpg'),
 ('53', 'avalon_dining_chair_perennials_white.jpg'),
 ('54', 'Cushion_Cover_for_Mattituck_Armchair.jpg'),
 ('55', 'Eastgate Sofa _Slipcovered.jpg'),
 ('56', 'Furn_Cutler_Sofa_Washed_Linen_With_White_Taping_MV_0087_Crop_SH.jpg'),
 ('57', 'Furn_Edgewater_Sofa_Angle_MV_0118_Crop_SH.jpg'),
 ('58', 'cart_sth_seas_sm_silo_Crop_SH.jpg'),
 ('59', 'Furn_Scallop_Rattan_Side_Table_Detail_MV_0149_Crop_OL.jpg'),
 ('60', 'Furn_Saint_Germaine_Side_Table_Detail1_MV_Crop_OL.jpg'),
 ('61', 'chr_rttn_hng_angl_silo_NoCrop_BASE.jpg'),
 ('62', 'CH27-02_6.jpg'),('62', 'CH27-02_2.jpg'),
 ('63', 'Furn_Yartmouth_Swivel_Chair_Natural_Per_Basketweave_Chalk_MV_425_Crop_SH.jpg'),
 ('64', 'Furn_Hughes_Four_Poster_Bed_Natural_MJ_Crop_SH.jpg'),
 ('65', 'Furn_Balboa_Bed_Natural_MV_Crop_SH.jpg'),
 ('66', 'Bed_Harbour_Cane_Low_Foot_Board_Natural_MV_0422_Crop_SH.jpg'),
 ('67', 'mDB.jpg'),
 ('68', 'mMRCHSU.jpg'),
 ('69', 'mBENCHSL.jpg'),
 ('70', 'm12323.jpg'),
 ('71', 'mOCVNAL.jpg'),
 ('72', 'mOCVNSF.jpg'),
 ('73', 'm12704.jpg'),
 ('74', 'm13952.jpg'),
 ('75', 'm13243.jpg'),
 ('76', 'Furn_Rockmere_Coffee_Table_White_MV_0779_Crop_SH.jpg'),
 ('77', 'Furn_Blithedale_Outdoor_Coffee_Table_White_TS_0706_Crop_SH.jpg'),
 ('78', 'Furn_Bamileke_Coffee_Table_White_Detail_MV_0024_Crop_SH.jpg'),('78', 'Furn_Bamileke_Coffee_Table_MV_0478_Crop_SH.jpg'),
 ('79', 'Furn_Riviera_Outdoor_Side_Chair_White_MV_0167_Crop_SH.jpg'),
 ('80', 'Furn_Riviera_All_Weather_Arm_Chair_White_Chambray_Angle_MV_0071_Crop_SH.jpg'),('80', 'Furn_Riviera_All_Weather_Arm_Chair_White_Chambray_MV_0066_Crop_SH.jpg'),
 ('81', 'Furn_Outdoor_Riviera_Swivel_Counter_Stool_Dune_MV_0183_Crop_SH.jpg'),('81', 'Furn_Outdoor_Riviera_Swivel_Counter_Stool_Dune_Angle_MV_0191_Crop_SH.jpg'),('81', 'Furn_Outdoor_Riviera_Swivel_Counter_Stool_Dune_Detail_MV_0196_Crop_OL.jpg'),
 ('82','Terrace_Round_Dining_Table1.jpg'),('82','Terrace_Round_Dining_Table2.jpg'),
 ('83','St_Germain_Stone_Dining_Table1.jpg'),('83','St_Germain_Stone_Dining_Table2.jpg'),
 ('84','Downing_Round_Dining_Table1.jpg'),('84','Downing_Round_Dining_Table2.jpg'),
 ('85','Balboa_Side_Chair1.jpg'),('85','Balboa_Side_Chair2.jpg'),
 ('86','Carson_Dining_Chair1.jpg'),('86','Carson_Dining_Chair2.jpg'),
 ('87', 'Portside_Dining_Chair1.jpg'),('87', 'Portside_Dining_Chair2.jpg'),
 ('88', 'Hanging_Rattan_Chair_Cushion1.jpg'),('88', 'Hanging_Rattan_Chair_Cushion2.jpg'),
 ('89', 'Double_Hanging_Rattan_Chair_Cushion1.jpg'),('89', 'Double_Hanging_Rattan_Chair_Cushion2.jpg'),
 ('90', 'Hanging_Rattan_Bench_Cushion1.jpg'),('90', 'Hanging_Rattan_Bench_Cushion2.jpg'),
 ('91', 'Eastgate_Sofa1.jpg'),('91', 'Eastgate_Sofa2.jpg'),
 ('92', 'Chatham_Sofa1.jpg'),('92', 'Chatham_Sofa2.jpg'),
 ('93', 'Cambridge_Sofa1.jpg'),('93', 'Cambridge_Sofa2.jpg'),
 ('94', 'Hunter_Side_Table1.jpg'),('94', 'Hunter_Side_Table2.jpg'),
 ('95', 'Cape_Side_Table1.jpg'),('95', 'Cape_Side_Table2.jpg'),
 ('96', 'Rope_Stool1.jpg'),('96', 'Rope_Stool2.jpg'),
 ('97', 'Black_Rubic_and_Teak_Wall_Display_Shelf.jpg'),
 ('98', 'Industrial_Storage_Shelf_w2_Shutter_Doors.jpg'),
 ('99', 'Elm_Swivel_Chair1.jpg'),('99', 'Elm_Swivel_Chair2.jpg'),
 ('100', 'Elm_Chair1.jpg'),('100', 'Elm_Chair2.jpg'),
 ('101', 'Lakeshore_Chair1.jpg'),('101', 'Lakeshore_Chair2.jpg'),
 ('102', 'Broderick_Bed1.jpg'),('102', 'Broderick_Bed2.jpg'),
 ('103', 'Broderick_Slipcovered_Bed1.jpg'),('103', 'Broderick_Slipcovered_Bed2.jpg'),
 ('104', 'Tall_Broderick_Bed1.jpg'),('104', 'Tall_Broderick_Bed2.jpg'),
 ('105', 'Gingham_Crib_Sheet1.jpg'),('105', 'Gingham_Crib_Sheet2.jpg'),
 ('106', 'Seahaven_Crib_Sheet1.jpg'),('106', 'Seahaven_Crib_Sheet2.jpg'),
 ('107', 'Melville_Crib_Sheet1.jpg'),('107', 'Melville_Crib_Sheet2.jpg'),
 ('108', 'Spruce_Street_Sleeper_Queen1.jpg'),('108', 'Spruce_Street_Sleeper_Queen2.jpg'),
 ('109', 'Grady_Sleeper_King1.jpg'),('109', 'Grady_Sleeper_King2.jpg'),
 ('110', 'Spruce_Street_Sleeper_King1.jpg'),('110', 'Spruce_Street_Sleeper_King2.jpg'),
 ('111', 'Cabot_Console1.jpg'),('111', 'Cabot_Console2.jpg'),
 ('112', 'Driftway_Console1.jpg'),('112', 'Driftway_Console2.jpg'),
 ('113', 'Bar_Island_Console1.jpg'),('113', 'Bar_Island_Console2.jpg'),
 ('114', 'Springwood_Hanging_Daybed1.jpg'),('114', 'Springwood_Hanging_Daybed2.jpg'),
 ('115', 'Pacifica_Bench1.jpg'),('115', 'Pacifica_Bench2.jpg'),
 ('116', 'Sundial_Luxury_Depth_Sofa1.jpg'),('116', 'Sundial_Luxury_Depth_Sofa2.jpg'),
 ('117', 'Capistrano_Hanging_Chair_&_Stand1.jpg'),('117', 'Capistrano_Hanging_Chair_&_Stand2.jpg'),
 ('118', 'Catalina_Rocker1.jpg'),('118', 'Catalina_Rocker2.jpg'),
 ('119', 'Loring_Chair1.jpg'),('119', 'Loring_Chair2.jpg'),
 ('120', 'Seabrook_Outdoor_Ottoman1.jpg'),('120', 'Seabrook_Outdoor_Ottoman2.jpg'),
 ('121', 'Bamileke_Side_Table1.jpg'),('121', 'Bamileke_Side_Table2.jpg'),
 ('122', 'Rockridge_Side_Table1.jpg'),('122', 'Rockridge_Side_Table2.jpg'),
 ('123', 'Lawn_Chaise1.jpg'),('123', 'Lawn_Chaise2.jpg'),
 ('124', 'Salt_Creek_Chaise1.jpg'),('124', 'Salt_Creek_Chaise2.jpg'),
 ('125', 'Crosby_Teak_Chaise_Natural1.jpg'),('125', 'Crosby_Teak_Chaise_Natural2.jpg')

