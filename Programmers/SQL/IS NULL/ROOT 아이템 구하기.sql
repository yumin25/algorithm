SELECT I.ITEM_ID, I.ITEM_NAME
  FROM ITEM_INFO I 
  JOIN ITEM_TREE T
    ON I.ITEM_ID = T.ITEM_ID
 WHERE T.PARENT_ITEM_ID IS NULL
 ORDER BY I.ITEM_ID
;