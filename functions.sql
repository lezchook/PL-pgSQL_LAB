create or replace function get_artifacts_from_agent(agent_name text) returns table(artifact text) as
$$
begin
    if (select count(*) from agents where agents.name=agent_name) = 0 then
        RAISE EXCEPTION 'Cant find agent with this name';
    elseif (select count(*) from agents where agents.name=agent_name) > 1 then
        RAISE NOTICE 'Attention! There is a person with the same name, please use id';
	return;
    end if;
    return query select artifact.name from artifact 
    	join artifact_set on artifact.id_artifact=artifact_set.id_artifact
	join mission on mission.id_mission=artifact_set.id_mission
	join agents_attention on agents_attention.id_mission=mission.id_mission
	join agents on agents.id_agent=agents_attention.id_agent where agents.name=agent_name;
end;
$$ language plpgsql;

create or replace function get_artifacts_from_agent(id integer) returns table(artifact text) as
$$
begin
    if (select count(*) from agents where agents.id_agent=id) = 0 then
        RAISE NOTICE 'There is no agent with this id';
	return;
    end if;
    return query select artifact.name from artifact 
    	join artifact_set on artifact.id_artifact=artifact_set.id_artifact
	join mission on mission.id_mission=artifact_set.id_mission
	join agents_attention on agents_attention.id_mission=mission.id_mission
	join agents on agents.id_agent=agents_attention.id_agent where agents.id_agent=id;
end;
$$ language plpgsql;

create or replace function get_missions_by_equipment(label text) 
returns table(
	id_mission integer,
	id_signal integer,
	description text,
	crimers_is boolean,
	crimers_catch boolean) as
$$
begin
    if (select count(*) from equipment where equipment.name=label) = 0 then
        RAISE NOTICE 'There is no equipment with this name';
	return;
    elseif (select count(*) from equipment where equipment.name=label) > 1 then
        RAISE NOTICE 'Attention! There is a equipment with the same name, please use id';
	return;
    end if;
    return query select mission.id_mission, mission.id_signal, 
	mission.description, mission.crimers_is, mission.crimers_catch
	from mission
	join equipment_set on equipment_set.id_mission=mission.id_mission 
    	join equipment on equipment.id_item=equipment_set.id_item where equipment.name=label;
end;
$$ language plpgsql;

create or replace function get_missions_by_equipment(id_equipment integer) 
returns table(
	id_mission integer,
	id_signal integer,
	description text,
	crimers_is boolean,
	crimers_catch boolean) as
$$
begin
    if (select count(*) from equipment where equipment.id_item=id_equipment) = 0 then
        RAISE NOTICE 'There is no equipment with this id';
	return;
    end if;
    return query select mission.id_mission, mission.id_signal, 
	mission.description, mission.crimers_is, mission.crimers_catch
	from mission
	join equipment_set on equipment_set.id_mission=mission.id_mission 
    	join equipment on equipment.id_item=equipment_set.id_item where equipment.id_item=id_equipment;
end;
$$ language plpgsql;


create or replace function get_equipment_from_mission(id integer) returns table(equipment text) as
$$
begin
    if (select count(*) from mission where mission.id_mission=id) = 0 then
        RAISE NOTICE 'There is no mission with this id';
	return;
    end if;
    return query select equipment.name from equipment
    	join equipment_set on equipment.id_item=equipment_set.id_item
        join mission on equipment_set.id_mission=mission.id_mission where mission.id_mission=id;

end;
$$ language plpgsql;

create or replace function get_agents_from_mission(id integer) returns table(agent text) as
$$
begin
    if (select count(*) from mission where mission.id_mission=id) = 0 then
        RAISE NOTICE 'There is no mission with this id';
	return;
    end if;
    return query select agents.name from agents
    	join agents_attention on agents_attention.id_agent=agents.id_agent
        join mission on agents_attention.id_mission=mission.id_mission where mission.id_mission=id;

end;
$$ language plpgsql;

create or replace procedure update_weight(agent_id integer, new_weight integer) as
$$
begin
   update agents set weight=new_weight where id_agent=agent_id;
   RAISE NOTICE 'Agents weight was updated';
end;
$$ language plpgsql;

create or replace procedure delete_agents_higher_weight(max_weight integer) as
$$
begin
   delete from agents where weight > max_weight;
   RAISE NOTICE 'Agent was deleted';
end;
$$ language plpgsql;
