SELECT gen3.id
FROM ecoli_data gen1
JOIN ecoli_data gen2
ON gen1.id = gen2.parent_id
JOIN ecoli_data gen3
ON gen2.id = gen3.parent_id
WHERE gen1.parent_id IS NULL
ORDER BY gen3.id ASC;