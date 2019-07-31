create table menu_category(
	id integer unsigned auto_increment primary key,
	name varchar(255),	
	status varchar(10),
	key(name),
	key(status)
);

create table menu(
	id integer unsigned auto_increment primary key,
	category_id integer unsigned, 
	name varchar(255),	
	link text,
	target varchar(10), 
	has_children tinyint(1),
	parent_id integer unsigned,
	ordering integer unsigned,
	status varchar(10),
	key(ordering),
	key(status),
	foreign key (category_id) references menu_category(id),
	foreign key (parent_id) references menu(id)
);

