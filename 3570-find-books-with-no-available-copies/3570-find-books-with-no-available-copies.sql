WITH CurrentBorrows AS(
    SELECT book_id,COUNT(*) AS current_borrowers
    FROM borrowing_records
    WHERE return_date IS NULL
    GROUP BY book_id
)
SELECT l.book_id,l.title,l.author,l.genre,l.publication_year,c.current_borrowers
FROM library_books l
JOIN CurrentBorrows c ON l.book_id=c.book_id
WHERE c.current_borrowers=l.total_copies
ORDER BY c.current_borrowers DESC,l.title ASC;