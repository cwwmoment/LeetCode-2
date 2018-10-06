DELETE FROM Person WHERE Id NOT IN (
SELECT t.Id FROM (
    SELECT MIN(ID) as ID FROM Person
    GROUP BY Email
    ) t
)
