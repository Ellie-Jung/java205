INSERT INTO `project`.`test`
(`memo`)
VALUES
('test memo2');

UPDATE `project`.`test`
SET
`memo` = "edit memo"
WHERE `idx` =2;
