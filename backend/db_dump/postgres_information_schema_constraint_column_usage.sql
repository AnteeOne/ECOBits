INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'quests', 'id', 'postgres', 'public', 'quests_pkey');
INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'orders', 'id', 'postgres', 'public', 'orders_pkey');
INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'quests', 'id', 'postgres', 'public', 'users_active_quest_id_fkey');
INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'users', 'id', 'postgres', 'public', 'users_pkey');
INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'achievement', 'id', 'postgres', 'public', 'achievement_pkey');
INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'user_achievements', 'user_id', 'postgres', 'public', 'user_achievements_pkey');
INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'user_achievements', 'achievement_id', 'postgres', 'public', 'user_achievements_pkey');
INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'users', 'id', 'postgres', 'public', 'user_achievements_user_id_fkey');
INSERT INTO information_schema.constraint_column_usage (table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name) VALUES ('postgres', 'public', 'achievement', 'id', 'postgres', 'public', 'user_achievements_achievement_id_fkey');