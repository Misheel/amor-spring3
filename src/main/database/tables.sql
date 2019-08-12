create table menu_category(
	id integer unsigned auto_increment primary key,
	name varchar(255),	
	status varchar(10),
	key(name),
	key(status)
);

create table menu(
	id integer unsigned auto_increment primary key,
	categoryId integer unsigned, 
	name varchar(255),	
	link text,
	target varchar(10), 
	hasChildren tinyint(1),
	parentId integer unsigned,
	ordering integer unsigned,
	status varchar(10),
	key(ordering),
	key(status),
	foreign key (categoryId) references menu_category(id),
	foreign key (parentId) references menu(id)
);

create table static_text(
	id integer unsigned auto_increment primary key,
	name varchar(20),
	text TEXT,		
	key(name)	
);

create table post(
	id integer unsigned auto_increment primary key,
	name varchar(255),	
	content text,
	created datetime, 	
	status varchar(10),
	key(created),
	key(status)
);