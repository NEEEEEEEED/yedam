select * from film_actor where actor_id = 1;
select * from film 
		 where film_id in( select film_id 
						   from film_actor 
						   where actor_id = 1 );
select * 
	from rental
	where staff_id = 1
	and customer_id = 130
    and inventory_id = 367;
    
select first_name, email
  from customer
  where customer_id in (select customer_id 
						from rental
						where return_date is null);
                        
/*그룹함수*/
select payment_date, count(*), sum(amount) 
  from payment
  group by payment_date ;
  
  
/*join*/
select a.first_name
  from film_actor f, actor a, film m
  where f.actor_id = a.actor_id
  and	f.film_id = m.film_id;
