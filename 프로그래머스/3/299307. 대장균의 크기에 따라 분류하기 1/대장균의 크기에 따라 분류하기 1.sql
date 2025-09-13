SELECT a.ID,
CASE
    when a.SIZE_OF_COLONY <= 100 THEN 'LOW'
    when a.SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
    ELSE 'HIGH'
END AS SIZE
from ECOLI_DATA as a order by a.ID asc