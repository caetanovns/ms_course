CREATE TABLE payments
(
    id                BIGINT(20) NOT NULL AUTO_INCREMENT,
    price             DECIMAL(19, 2) NOT NULL,
    name              VARCHAR(100) DEFAULT NULL,
    number            VARCHAR(19)  DEFAULT NULL,
    expiration        VARCHAR(7)     NOT NULL,
    cvv               VARCHAR(3)   DEFAULT NULL,
    status            VARCHAR(255)   NOT NULL,
    order_id          BIGINT(20) NOT NULL,
    payment_method_id BIGINT(20) NOT NULL,

    PRIMARY KEY (id)
);