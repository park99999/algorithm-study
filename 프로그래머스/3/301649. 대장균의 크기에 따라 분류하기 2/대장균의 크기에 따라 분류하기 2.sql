SELECT A.ID,
CASE
    when A.PER <= 0.25 then 'CRITICAL'
    when A.PER <= 0.50 then 'HIGH'
    when A.PER <= 0.75 then 'MEDIUM'
    else 'LOW'
end as COLONY_NAME
from(   
    SELECT ID,
    PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS PER
    FROM ECOLI_DATA
) as A order by A.ID