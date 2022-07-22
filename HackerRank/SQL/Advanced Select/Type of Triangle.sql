SELECT
CASE
    WHEN A=B AND A=C THEN "Equilateral"
    WHEN C>=A+B THEN "Not A Triangle"
    WHEN A!=B AND A!=C AND B!=C THEN "Scalene"
    ELSE "Isosceles"
END
FROM TRIANGLES;