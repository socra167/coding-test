SELECT p.product_code,
    SUM(p.price * s.sales_amount) `sales`
FROM product p
JOIN offline_sale s
ON p.product_id = s.product_id
GROUP BY s.product_id
ORDER BY 2 DESC,
    p.product_code ASC;