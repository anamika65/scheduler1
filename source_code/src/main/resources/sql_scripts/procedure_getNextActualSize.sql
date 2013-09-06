DELIMITER $$
DROP PROCEDURE IF EXISTS getNextActualSize $$
CREATE PROCEDURE getNextActualSize(
    IN catalogID INT,
	IN projID INT,
	OUT opBlockID INT,
	OUT defaultSize INT,
	OUT actualSize INT
)
BEGIN
	DECLARE recordsCount INT;

/* test if there are any rows to be fetched, so that the handler in the */
/* calling procedure does not exit if there are none */
	select count(*) INTO recordsCount
	from opblocks opb
	where opb.CatalogID = catalogID
	and opb.ProjID = projID
	and opb.DefaultSize > opb.ActualSize
	and opb.OpBlockID = (select min(opb.OpBlockID)
						from opblocks opb
						where opb.CatalogID = catalogID
						and opb.ProjID = projID
						and opb.DefaultSize > opb.ActualSize);
	
	IF recordsCount > 0 THEN
		select opb.OpBlockID, opb.DefaultSize, opb.ActualSize INTO opBlockID, defaultSize, actualSize 
		from opblocks opb
		where opb.CatalogID = catalogID
		and opb.ProjID = projID
		and opb.DefaultSize > opb.ActualSize
		and opb.OpBlockID = (select min(opb.OpBlockID)
							from opblocks opb
							where opb.CatalogID = catalogID
							and opb.ProjID = projID
							and opb.DefaultSize > opb.ActualSize);
	else
		SET opBlockID = 0;
		SET defaultSize = 0;
		SET actualSize = 0;
	END IF;

END $$
DELIMITER ;