# 1 --------------------------------------------------------------------------
with cte_interval as ( 
	   select b.id as id_session, a.name,  b.start_time,  a.duration,
              DATE_ADD(b.start_time, INTERVAL a.duration MINUTE) end_time
	 	 from film a left join session b  on a.id = b.film_id
        order by   b.start_time
        )
 select int1.id_session, int1.name, int1.start_time, int1.duration, int1.end_time,
        int2.id_session, int2.name, int2.start_time, int2.duration, int2.end_time
   from cte_interval  int1 inner join cte_interval  int2
        on  int1.id_session < int2.id_session 
        and int1.start_time < int2.end_time and int1.end_time > int2.start_time; 

# 2 -----------------------------------------------------------------------------------
select  name, start_time, duration, start_film2, break_time
  from (
        select  int1.id_session, int1.name, int1.start_time, int1.duration, int1.end_time,
                int2.id_session as s2, int2.name as name2, int2.start_time as start_film2, int2.duration as dur2, int2.end_time as end2,
                date_sub(int1.start_time, interval int2.end_time minute) break_time
          from (  select b.id as id_session, a.name,  b.start_time,  a.duration,
                         DATE_ADD(b.start_time, INTERVAL a.duration MINUTE) end_time
					from film a  left join session b  on a.id = b.film_id 
               ) int1 inner join
               ( select  b.id as id_session, a.name,  b.start_time,  a.duration,
                         DATE_ADD(b.start_time, INTERVAL a.duration MINUTE) end_time
		            from film a left join session b on a.id = b.film_id
                ) int2   on  int1.id_session < int2.id_session
                         and  int1.start_time < int2.end_time 
                         and int1.end_time < int2.start_time
     )
     order by break_time desc;
     
#  ----------------------------------------------------------------------------------------------------------------
     select f.name, null totals, ss.start_time,  sum(tt.summa) summa, sum(tt.tickets) tickets,  null avg_tickets
  from session ss left join 
       (select a.id price_id, a.session_id, sum(a.price) summa, count(b.number) tickets
          from price a inner join ticket b on a.id = b.price_id
       group by a.session_id ) tt on ss.id = tt.session_id   
      inner join film f on ss.film_id = f.id 
group by f.id, ss.id
union
select f.name, "Итого", null,  sum(tt.summa) summa, sum(tt.tickets) tick,  avg(tt.tickets) av
  from session ss left join 
         (select a.id price_id, a.session_id, sum(a.price) summa, count(b.number) tickets
           from price a inner join ticket b  on a.id = b.price_id
       group by a.session_id ) tt on ss.id = tt.session_id   
       inner join film f on ss.film_id = f.id 
group by f.id  
union
select "Всего",  null, null, sum(a.price) summa, count(b.number) tickets, null
  from price a inner join ticket b  on a.id = b.price_id;  
     
        