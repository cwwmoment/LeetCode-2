SELECT *
FROM cinema
WHERE description <> 'boring' and id % 2 = 0
ORDER BY rating DESC

select *
from cinema
where MOD(id, 2) = 1 and description <> 'boring'
order by rating desc
