SELECT i.rest_id as `REST_ID`,
    i.rest_name as `REST_NAME`,
    i.food_type as `FOOD_TYPE`,
    i.favorites AS `FAVORITES`,
    i.address AS `ADDRESS`,
    ROUND(AVG(r.review_score), 2) AS `SCORE`
FROM rest_info i
JOIN rest_review r
ON i.rest_id = r.rest_id
WHERE i.address
LIKE '서울%'
GROUP BY i.rest_id
ORDER BY 6 DESC,
    4 DESC;