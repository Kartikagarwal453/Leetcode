WITH season_sales AS (
    SELECT
        CASE
            WHEN MONTH(s.sale_date) IN (12, 1, 2) THEN 'Winter'
            WHEN MONTH(s.sale_date) IN (3, 4, 5) THEN 'Spring'
            WHEN MONTH(s.sale_date) IN (6, 7, 8) THEN 'Summer'
            WHEN MONTH(s.sale_date) IN (9, 10, 11) THEN 'Fall'
        END AS season,
        p.category,
        s.quantity,
        s.price
    FROM sales s
    JOIN products p
        ON s.product_id = p.product_id
),

category_sales AS (
    SELECT
        season,
        category,
        SUM(quantity) AS total_quantity,
        SUM(quantity * price) AS total_revenue
    FROM season_sales
    GROUP BY season, category
),

ranked AS (
    SELECT
        season,
        category,
        total_quantity,
        total_revenue,
        ROW_NUMBER() OVER (
            PARTITION BY season
            ORDER BY
                total_quantity DESC,
                total_revenue DESC,
                category ASC
        ) AS rn
    FROM category_sales
)

SELECT
    season,
    category,
    total_quantity,
    total_revenue
FROM ranked
WHERE rn = 1
ORDER BY
    CASE season
        WHEN 'Fall' THEN 1
        WHEN 'Spring' THEN 2
        WHEN 'Summer' THEN 3
        WHEN 'Winter' THEN 4
    END;