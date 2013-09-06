DELIMITER $$
DROP PROCEDURE IF EXISTS updateOpBlockActualSize $$
CREATE PROCEDURE updateOpBlockActualSize(
	IN startID INT,
	IN endID INT
)
BEGIN

  DECLARE done INT DEFAULT FALSE;
  DECLARE a, vNeededNrOp, vCatalogID, vProjID, vOpNr, vOpBlockID, vDefaultSize, vActualSize INT;
  DECLARE cur1 CURSOR FOR 
		select psc.CatalogID, pr.ProjID, count(*) as opNr
		from operations op, pscodes psc, project pr
		where left(op.OPSC01,5) = psc.PSCode
		and pr.Nickname = op.Op1
		and psc.CatalogID > 0
		and op.OpID >= startID 
		AND op.OpID <= endID
		group by psc.CatalogID, pr.ProjID
		order by 2,1;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN cur1;

  read_loop: LOOP
    FETCH cur1 INTO vCatalogID, vProjID, vOpNr;

    IF done THEN
      LEAVE read_loop;
    END IF;
	
	/* get an opblock that is not completed for CatalogID and ProjectID */
	call getNextActualSize(vCatalogID, vProjID, @opBlockID, @defaultSize, @actualSize);
	select @opBlockID, @defaultSize, @actualSize INTO vOpBlockID, vDefaultSize, vActualSize;

	IF vOpBlockID = 0 THEN
		ITERATE read_loop;
	END IF;

    IF vOpNr < vDefaultSize - vActualSize THEN
		UPDATE opblocks SET ActualSize = ActualSize + vOpNr WHERE OpBlockID = vOpBlockID;
    ELSE
	/* loop until vOpNr is 0*/
		update_loop: LOOP

			IF vOpNr > vDefaultSize - vActualSize THEN
				SET vNeededNrOp = vDefaultSize - vActualSize;
				SET vOpNr = vOpNr - vNeededNrOp;
			else
				SET vNeededNrOp = vOpNr;
				SET vOpNr = 0;
			end if;			
			
			UPDATE opblocks SET ActualSize = ActualSize + vNeededNrOp WHERE OpBlockID = vOpBlockID;
			COMMIT;
			
			IF vOpNr = 0 THEN
			  LEAVE update_loop;
			END IF;


			call getNextActualSize(vCatalogID, vProjID, @opBlockID, @defaultSize, @actualSize);
			select @opBlockID, @defaultSize, @actualSize INTO vOpBlockID, vDefaultSize, vActualSize;

			IF vOpBlockID = 0 THEN
				LEAVE update_loop;
			END IF;

		END LOOP;
	/* end loop until vOpNr is 0*/
    END IF;

  END LOOP;

  CLOSE cur1;

END $$
DELIMITER ;