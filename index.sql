create index name_index on agents using hash(name);
create index weight_index on agents using btree(weight);
create index name_artifact on artifact using hash(name);
create index name_regents on regents using hash(name);
create index technical_name on technical_staff using hash(name);
create index equipment_name on equipment using hash(name);
create index role_regents on regents using hash(role);