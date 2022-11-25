USE master;
GO

IF DB_ID('luxhouse') IS NOT NULL
  DROP DATABASE luxhouse;
GO

CREATE DATABASE luxhouse;
GO

USE luxhouse;
GO

--Table
CREATE TABLE users (
  id bigint CHECK ([id] > 0) IDENTITY NOT NULL PRIMARY KEY,
  username varchar(50) NOT NULL,
  [password] varchar(MAX) NOT NULL,
  fullname nvarchar(100) NOT NULL,
  gender bit NULL DEFAULT 0,
  email nvarchar(100) NOT NULL,
  dob datetime DEFAULT NULL,
  file_path_img varchar(MAX) NULL,
  avartar nvarchar(500) DEFAULT NULL,
  type_img varchar(50) null,
  phone varchar(15) NOT NULL,
  [address] nvarchar(500) DEFAULT NULL,
  [status] bit DEFAULT 1 NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT username UNIQUE (username),
  CONSTRAINT phone UNIQUE (phone),
  CONSTRAINT email UNIQUE (email)
)

CREATE TABLE roles (
  id int CHECK ([id] > 0) IDENTITY NOT NULL PRIMARY KEY,
  [name] nvarchar(200) NOT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [name] UNIQUE ([name])
)

CREATE TABLE authorities (
  [id] bigint CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  [user_id] bigint CHECK ([user_id] > 0) NOT NULL,
  [role_id] int CHECK ([role_id] > 0) NOT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE()
  CONSTRAINT [FK_Authorities_Users] FOREIGN KEY ([user_id]) REFERENCES users ([id]),
  CONSTRAINT [FK_Authorities_Roles] FOREIGN KEY ([role_id]) REFERENCES roles ([id]),
)

CREATE TABLE categories (
  id int CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  category_code nvarchar(50) NOT NULL,
  category_name nvarchar(100) NOT NULL,
  [image] nvarchar(500) DEFAULT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [category_code] UNIQUE ([category_code])
)

CREATE TABLE category_products (
  id int CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  category_product_code nvarchar(50) NOT NULL,
  category_product_name nvarchar(100) NOT NULL,
  category_id int CHECK (category_id > 0) NOT NULL,
  [image] nvarchar(500) DEFAULT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT category_product_code UNIQUE (category_product_code),
  CONSTRAINT [FK_category_products_categories] FOREIGN KEY (category_id) REFERENCES categories ([id])
)

CREATE TABLE suppliers (
  id int CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  supplier_code nvarchar(50) NOT NULL,
  supplier_name nvarchar(100) NOT NULL,
  decription nvarchar(2000) DEFAULT NULL,
  [image] nvarchar(500) DEFAULT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT supplier_code UNIQUE (supplier_code)
)

CREATE TABLE products (
  id bigint CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  product_code nvarchar(50) NOT NULL,
  product_name nvarchar(100) NOT NULL,
  [image] nvarchar(500) NOT NULL,
  price decimal(18, 4) NOT NULL DEFAULT 0.0000,
  discription nvarchar(4000) DEFAULT NULL,
  quantity int DEFAULT 1 NULL,
  discontinued bit NOT NULL DEFAULT 0,
  is_featured bit NOT NULL DEFAULT 0,
  is_new bit NOT NULL DEFAULT 0,
  status bit NOT NULL DEFAULT 1,
  category_product_id int CHECK (category_product_id > 0) DEFAULT NULL,
  [supplier_id] int CHECK ([supplier_id] > 0) DEFAULT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [FK_products_categoriy_products] FOREIGN KEY (category_product_id) REFERENCES category_products ([id]),
  CONSTRAINT [FK_products_suppliers] FOREIGN KEY ([supplier_id]) REFERENCES suppliers ([id])
)

CREATE TABLE product_images (
  id bigint CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  product_id bigint CHECK (product_id > 0) NOT NULL,
  file_path_img varchar(MAX) NULL,
  [image] nvarchar(500) NOT NULL,
  type_img varchar(50) null,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [FK_product_images_products] FOREIGN KEY (product_id) REFERENCES products ([id])
)

CREATE TABLE cart_product_users (
id bigint CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
quantity Decimal(18,4) default '0.0000' NULL,
product_id bigint CHECK (product_id > 0) NOT NULL,
user_id bigint CHECK (user_id > 0) NOT NULL,
[created_at] datetime NULL DEFAULT GETDATE(),
[updated_at] datetime NULL DEFAULT GETDATE(),
CONSTRAINT [FK_cart_product_users_users] FOREIGN KEY (user_id) REFERENCES users ([id]),
CONSTRAINT [FK_cart_product_users_products] FOREIGN KEY (product_id) REFERENCES products ([id])
)

CREATE TABLE payment_types (
  id int CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  payment_code nvarchar(50) NOT NULL,
  payment_name nvarchar(100) NOT NULL,
  [description] nvarchar(500) DEFAULT NULL,
  [image] nvarchar(500) DEFAULT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT payment_code UNIQUE ([payment_code])
)

CREATE TABLE orders (
  id bigint CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  [user_id] bigint CHECK ([user_id] > 0) NOT NULL,
  order_date datetime NULL,
  total_order decimal(18, 4) NOT NULL DEFAULT 0.0000, 
  shipped_date datetime DEFAULT NULL,
  ship_name nvarchar(50) NOT NULL,
  ship_address nvarchar(500) NOT NULL,
  ship_city nvarchar(150) NOT NULL,
  ship_district nvarchar(150) NOT NULL,
  ship_phuong nvarchar(150) NOT NULL,
  shipping_fee decimal(18, 4) NOT NULL DEFAULT 0.0000,
  [payment_type_id] int CHECK ([payment_type_id] > 0) NOT NULL DEFAULT 0,
  [paid_date] datetime DEFAULT NULL,
  [order_status] nvarchar(50) NOT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [FK_orders_users] FOREIGN KEY ([user_id]) REFERENCES users ([id])
)

CREATE TABLE order_details (
  id bigint CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  order_id bigint CHECK (order_id > 0) NOT NULL,
  [product_id] bigint CHECK ([product_id] > 0) NOT NULL,
  quantity int NOT NULL,
  price decimal(18, 4) NOT NULL DEFAULT 0.0000,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [FK_order_details_orders] FOREIGN KEY (order_id) REFERENCES orders ([id]),
  CONSTRAINT [FK_order_details_products] FOREIGN KEY ([product_id]) REFERENCES products ([id])
)

CREATE TABLE prduct_reviews (
  id bigint CHECK ([id] > 0) NOT NULL IDENTITY PRIMARY KEY,
  [product_id] bigint CHECK ([product_id] > 0) NOT NULL,
  [user_id] bigint CHECK ([user_id] > 0) NOT NULL DEFAULT 0,
  rating float NOT NULL,
  comment nvarchar(500) NOT NULL,
  [created_at] datetime NULL DEFAULT GETDATE(),
  [updated_at] datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [FK_product_reviews_products] FOREIGN KEY ([product_id]) REFERENCES products ([id]),
  CONSTRAINT [FK_product_reviews_users] FOREIGN KEY ([product_id]) REFERENCES users ([id])
)