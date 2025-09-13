select parent.ID, count(child.ID) as CHILD_COUNT
from ECOLI_DATA as parent
left join ECOLI_DATA as child
on parent.ID = child.PARENT_ID
group by parent.ID