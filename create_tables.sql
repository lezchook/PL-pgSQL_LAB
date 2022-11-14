create table regents(
	id_regent serial primary key, 
	name text not null, 
	role text not null, 
	biography text not null, 
	birthday date CHECK(BIRTHDAY > '1930-01-01')
);
create table regents_session(
	id_session serial primary key, 
	date_session date CHECK(date_session > '1950-01-01'),
	description text not null
);
create table regent_set(
	id_regent_session integer references regents_session(id_session),
	id_regent integer references regents(id_regent), 
	primary key(id_regent_session, id_regent)
);
create table agents(
	id_agent serial primary key,
	name text not null,
	biography text not null,
	birthday date CHECK(birthday > '1950-01-01'),
	weight integer CHECK(weight < 120),
	id_session integer references regents_session(id_session)
);
create table criminals(
	id_criminal serial primary key,
	name text not null,
	description text not null,
	arrest_date date,
	id_session integer references regents_session(id_session),
	birthday date,
	judgment text
);
create table boss(
	id_boss serial primary key,
	name text not null,
	biography text not null,
	birthday date CHECK(birthday > '1940-01-01'),
	active boolean not null,
	id_session integer references regents_session(id_session)
);
create table signal(
	id_signal serial primary key,
	description text not null,
	signal_date date CHECK(signal_date > '1950-01-01'),
	pross_boss integer references boss(id_boss)
);
create table warehouse_sectors(
	id_sector serial primary key,
	name text not null,
	description text not null
);
create table technical_staff(
	id_technic serial primary key,
	name text not null,
	best_skill text not null,
	biography text not null,
	birthday date CHECK(birthday > '1960-01-01'),
	id_session integer references regents_session(id_session)
);
create table technical_command(
	id_command serial primary key, 
	name text not null
);
create table technical_set(
	id_command integer references technical_command(id_command),
	id_technic integer references technical_staff(id_technic)
);
create table equipment(
	id_item serial primary key,
	name text not null,
	description text not null,
	id_command integer references technical_command(id_command)
);
create table artifact(
	id_artifact serial primary key,
	name text not null,
	description text not null,
	sector integer references warehouse_sectors(id_sector),
	weight integer check(weight > 10)
);
create table mission(
	id_mission serial primary key,
	id_signal integer references signal(id_signal),
	description text not null,
	crimers_is boolean not null,
	crimers_catch boolean not null
);
create table artifact_set(
	id_mission integer references mission(id_mission),
	id_artifact integer references artifact(id_artifact)
);
create table agents_attention(
	id_agent integer references agents(id_agent) on delete cascade,
	id_mission integer references mission(id_mission) on delete cascade,
	location boolean not null
);
create table equipment_set(
	id_mission integer references mission(id_mission),
	id_item integer references equipment(id_item)
);
create table criminal_direct(
	id_mission integer references mission(id_mission),
	id_criminal integer references criminals(id_criminal)
);
create table bad_artifact(
	id serial primary key,
	name text not null,
	description text not null,
	weight integer not null
);