
# **query 1**
```sql
select title, category.category_name, views_in_millions as views
from content
join category
on content.category_id = category.category_id
where release_year = 2023 and views_in_millions > 100.0 and category.category_name = "Series";
```


# **query 2**

```sql
select title, rating*views_in_millions as popularity_score 
from content
where (rating*views_in_millions) > 800
order by popularity_score desc
```
