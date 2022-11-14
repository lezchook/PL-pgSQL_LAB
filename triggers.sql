create or replace function validate_artifact()
returns trigger
as $$
begin
    if new.weight < 10 then
	insert into bad_artifact(name, description, weight) values(new.name, new.description, new.weight);
	RAISE NOTICE 'Artifact destroyed';
	return null;
    end if;
    return new;
end;
$$ language plpgsql;

create trigger artifact_validate
    before insert on artifact
    for each row
    execute procedure validate_artifact();

create or replace function validate_criminal()
returns trigger
as $$
begin
    if extract(year from age(current_date, new.birthday)) :: int < 18 then
	new.judgment = 'Juvenile acquitted';
	RAISE NOTICE 'Juvenile acquitted';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger criminal_validate
    before insert on criminals
    for each row
    execute procedure validate_criminal();

create or replace function validate_agent()
returns trigger
as $$
DECLARE
   agent_weight integer;
begin
   select weight into agent_weight from agents where id_agent=new.id_agent;
    if agent_weight > 100 then
	new.location = false;
	RAISE NOTICE 'Agent with a large weight remains in storage';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger agent_validate
    before insert on agents_attention
    for each row
    execute procedure validate_agent();

