SELECT i.animal_id, i.animal_type, i.name
FROM animal_ins i
JOIN animal_outs o
ON i.animal_id = o.animal_id
WHERE i.SEX_UPON_INTAKE != o.SEX_UPON_OUTCOME
ORDER BY i.animal_id ASC;