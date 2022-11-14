create or replace function get_artifacts_from_agent(id integer) returns table(artifact text) as
$$
begin
    return query select artifact.name from artifact 
    	join artifact_set on artifact.id_artifact=artifact_set.id_artifact
	join mission on mission.id_mission=artifact_set.id_mission
	join agents_attention on agents_attention.id_mission=mission.id_mission
	join agents on agents.id_agent=agents_attention.id_agent where agents.id_agent=id;
end;
$$ language plpgsql;

create or replace function get_equipment_from_mission(id integer) returns table(equipment text) as
$$
begin
    return query select equipment.name from equipment
    	join equipment_set on equipment.id_item=equipment_set.id_item
        join mission on equipment_set.id_mission=mission.id_mission where mission.id_mission=id;

end;
$$ language plpgsql;

create or replace function get_agents_from_mission(id integer) returns table(agent text) as
$$
begin
    return query select agents.name from agents
    	join agents_attention on agents_attention.id_agent=agents.id_agent
        join mission on agents_attention.id_mission=mission.id_mission where mission.id_mission=id;

end;
$$ language plpgsql;

create or replace procedure update_weight(agent_id integer, new_weight integer) as
$$
begin
   update agents set weight=new_weight where id_agent=agent_id;
end;
$$ language plpgsql;

create or replace procedure delete_agents_higher_weight(max_weight integer) as
$$
begin
   delete from agents where weight > max_weight;
end;
$$ language plpgsql;

