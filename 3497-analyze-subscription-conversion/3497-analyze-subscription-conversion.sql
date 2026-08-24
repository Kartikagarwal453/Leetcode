WITH converted_users AS (
    SELECT user_id
    FROM UserActivity
    GROUP BY user_id
    HAVING COUNT(*) FILTER (WHERE activity_type = 'free_trial') > 0
       AND COUNT(*) FILTER (WHERE activity_type = 'paid') > 0
)
SELECT
    u.user_id,
    ROUND(
        AVG(u.activity_duration) FILTER (
            WHERE u.activity_type = 'free_trial'
        ), 2
    ) AS trial_avg_duration,
    ROUND(
        AVG(u.activity_duration) FILTER (
            WHERE u.activity_type = 'paid'
        ), 2
    ) AS paid_avg_duration
FROM UserActivity u
JOIN converted_users c
    ON u.user_id = c.user_id
GROUP BY u.user_id
ORDER BY u.user_id ASC;