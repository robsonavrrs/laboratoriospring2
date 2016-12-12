CREATE TABLE zuul_routes (
    id int(11) NOT NULL AUTO_INCREMENT,
    path VARCHAR(256),
    service_id VARCHAR(256),
    url VARCHAR(1000),
    strip_prefix boolean,
    retryable boolean,
    PRIMARY KEY(id)
);
INSERT INTO ZUUL_ROUTES(PATH, SERVICE_ID, STRIP_PREFIX) VALUES('/service1/**','SERVICE1',true);