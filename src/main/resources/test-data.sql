insert into users (id, ntable, name, surname, user_name, password)
values (1, 'user', 'Ivan', 'Shapko', 'ivan_shapko', '123456');



insert into task_item (id, p_item_id, title)
values (1, 1, 'First task');

insert into task_item (id, p_item_id, title)
values (2, 1, 'Second task');

insert into task_item (id, p_item_id, title)
values (3, 1, 'Third task');



insert into task (id, class_number, description, is_private, subject, date_created, p_item_id)
values (1, 6, 'sdfgdfghdfgh', true, 'math', CURRENT_TIMESTAMP, 1);

insert into task (id, class_number, description, is_private, subject, date_created, p_item_id)
values (2, 6, '057809708', true, 'math', CURRENT_TIMESTAMP + interval '1 day', 1);

insert into task (id, class_number, description, is_private, subject, date_created, p_item_id)
values (3, 6, 'ppppppppppppp', true, 'math', CURRENT_TIMESTAMP + interval '2 days', 1);