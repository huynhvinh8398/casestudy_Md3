            CREATE DATABASE case_study3;

            CREATE TABLE products(
             id_product BiGINT   NOT NULL  AUTO_INCREMENT PRIMARY KEY,
             product_name VARCHAR(255) NOT NULL,
             price       DOUBLE NOT NULL,
             quantity    INT  NOT NULL,
             `description`   VARCHAR(100) NOT NULL,
             createAt DATETIME NOT NULL,
             updateAt  DATETIME  NULL DEFAULT NULL,
             img  BLOB NOT NULL
                );

            CREATE TABLE users(
              user_id  BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
              user_name VARCHAR(100) NOT NULL ,
              `password` VARCHAR(100) NOT NULL ,
              full_name VARCHAR(100) NOT NULL,
              phone   VARCHAR(50) not null ,
              email VARCHAR(100) NOT NULL ,
              address VARCHAR(100) NOT NULL

                );

        CREATE TABLE orders(
           id_order  BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
           user_id BIGINT NOT NULL,
           full_name VARCHAR(100) NOT NULL,
           phone  VARCHAR(50) NOT NULL,
           address VARCHAR(100) NOT NULL,
           createdAt DATE,
           FOREIGN KEY (user_id) REFERENCES users(user_id)
                            );

        CREATE TABLE  order_items (
          id_orderItem BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
          id_order BIGINT ,
          id_product  BIGINT,
          product_name  VARCHAR(100) NOT NULL ,
          price DOUBLE NOT NULL,
          quantity INT NOT NULL,
          total DOUBLE  NOT NULL,
          FOREIGN KEY (`id_product`) REFERENCES products(`id_product` ),
          FOREIGN KEY (`id_order`) REFERENCES orders(`id_order`),
          CHECK (`price` >= 0 AND `price`	<= 100000000),
          CHECK (`quantity` >= 0)
                            );

        INSERT INTO users()
        VALUE('123','vinhhuynh','vinh123','Huỳnh Văn Vinh','0123456754','vinh456@gmail.com','Huế','2022-06-19',now()),
        ('434345','taile','tai123','Nguyễn Thiện Tại','0987654323','tai456@gmail.com','Huế','2022-06-19',now());

        iNSERT INTO products()
        VALUE('2343','Số đỏ','500000','100','văn học','2022-06-19',now(),'https://salt.tikicdn.com/ts/product/59/c7/c3/2e8530a5e018caf37c0116866b1ebdba.jpg');

        INSERT INTO orders()
        VALUE('24','123','Huỳnh Văn Vinh','0123456754','Huế',now() );

        INSERT INTO order_items()
        VALUE('433','24','2343','số đỏ',500000,1,500000);

