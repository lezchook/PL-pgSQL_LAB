create index name_index on agents using hash(name);
create index weight_index on agents using btree(weight);
create index name_artifact on artifact using hash(name);
create index weight_artifact on artifact using btree(weight);
create index name_regents on regents using hash(name);
create index technical_name on regents using hash(name);