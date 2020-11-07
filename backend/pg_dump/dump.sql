--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: achievement; Type: TABLE; Schema: public; Owner: anteeone
--

CREATE TABLE public.achievement (
    id integer NOT NULL,
    title character varying(300),
    description text
);


ALTER TABLE public.achievement OWNER TO anteeone;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: anteeone
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    title character varying(200),
    description text,
    bitsprice integer
);


ALTER TABLE public.orders OWNER TO anteeone;

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: anteeone
--

CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO anteeone;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: anteeone
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- Name: quests; Type: TABLE; Schema: public; Owner: anteeone
--

CREATE TABLE public.quests (
    id integer NOT NULL,
    title character varying(200),
    description text,
    bitsreward integer
);


ALTER TABLE public.quests OWNER TO anteeone;

--
-- Name: quests_id_seq; Type: SEQUENCE; Schema: public; Owner: anteeone
--

CREATE SEQUENCE public.quests_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.quests_id_seq OWNER TO anteeone;

--
-- Name: quests_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: anteeone
--

ALTER SEQUENCE public.quests_id_seq OWNED BY public.quests.id;


--
-- Name: user_achievements; Type: TABLE; Schema: public; Owner: anteeone
--

CREATE TABLE public.user_achievements (
    user_id integer NOT NULL,
    achievement_id integer NOT NULL
);


ALTER TABLE public.user_achievements OWNER TO anteeone;

--
-- Name: users; Type: TABLE; Schema: public; Owner: anteeone
--

CREATE TABLE public.users (
    username character varying(200),
    email character varying(200),
    password character varying(200),
    bitscount integer,
    role character varying,
    session_id text,
    active_quest_id integer,
    completed_quests_count integer DEFAULT 0,
    id integer NOT NULL
);


ALTER TABLE public.users OWNER TO anteeone;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: anteeone
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO anteeone;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: anteeone
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- Name: quests id; Type: DEFAULT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.quests ALTER COLUMN id SET DEFAULT nextval('public.quests_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: achievement; Type: TABLE DATA; Schema: public; Owner: anteeone
--

COPY public.achievement (id, title, description) FROM stdin;
1	Master 1	Master 1
2	Master 2	Master 2
3	Faster 1	Faster 2
4	Stronger 1	Stronger 1
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: anteeone
--

COPY public.orders (id, title, description, bitsprice) FROM stdin;
5	T-shirt	Cool t-shirt with our logo c:	360
6	Mask	Just mask with our logo.Just hardcore 0.0	250
9	Glasses 	Nice glasses for sunny days :D	199
10	Sticker	Sticker for yout laptop with our logo	49
11	Sweatshirt	Cool sweatshirt for coldly winter days	1999
12	Pin	Cool pin with our logo :)	39
\.


--
-- Data for Name: quests; Type: TABLE DATA; Schema: public; Owner: anteeone
--

COPY public.quests (id, title, description, bitsreward) FROM stdin;
7	Suspendisse non dolor	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus malesuada condimentum nunc, vehicula tincidunt urna porttitor et. Cras at velit quis diam molestie condimentum non eget elit. Aenean dignissim magna porttitor nulla eleifend, non consectetur turpis vulputate. Suspendisse non dolor vel nisi ullamcorper condimentum	34
8	Lorem ipsum dolor sit amet	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus malesuada condimentum nunc, vehicula tincidunt urna porttitor et. Cras at velit quis diam molestie condimentum non eget elit. Aenean dignissim magna porttitor nulla eleifend, non consectetur turpis vulputate. Suspendisse non dolor vel nisi ullamcorper condimentum	342
17	Feed students in student's dorm on Pushkina street	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus malesuada condimentum nunc, vehicula tincidunt urna porttitor et. Cras at velit quis diam molestie condimentum non eget elit. Aenean dignissim magna porttitor nulla eleifend, non consectetur turpis vulputate. Suspendisse non dolor vel nisi ullamcorper condimentum	100
18	Phasellus malesuada condimentum	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus malesuada condimentum nunc, vehicula tincidunt urna porttitor et. Cras at velit quis diam molestie condimentum non eget elit. Aenean dignissim magna porttitor nulla eleifend, non consectetur turpis vulputate. Suspendisse non dolor vel nisi ullamcorper condimentum	399
19	Malesuada condimentum	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus malesuada condimentum nunc, vehicula tincidunt urna porttitor et. Cras at velit quis diam molestie condimentum non eget elit. Aenean dignissim magna porttitor nulla eleifend, non consectetur turpis vulputate. Suspendisse non dolor vel nisi ullamcorper condimentum	999
20	Create new site for our company :)	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus malesuada condimentum nunc, vehicula tincidunt urna porttitor et. Cras at velit quis diam molestie condimentum non eget elit. Aenean dignissim magna porttitor nulla eleifend, non consectetur turpis vulputate. Suspendisse non dolor vel nisi ullamcorper condimentum	1999
\.


--
-- Data for Name: user_achievements; Type: TABLE DATA; Schema: public; Owner: anteeone
--

COPY public.user_achievements (user_id, achievement_id) FROM stdin;
2	2
2	3
1	2
1	3
1	1
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: anteeone
--

COPY public.users (username, email, password, bitscount, role, session_id, active_quest_id, completed_quests_count, id) FROM stdin;
FirstUser	firstuser@mail.ru	134014587-968139131	151	volunteer	778713365134014587v%2jl8!@$*i$2^h!8mo@ziom2(@ace$-t-3%oo)zj4z66g+oc$	17	0	2
admin	admin@admin.ru	92668751-968139131	2342	admin	-41007332592668751v%2jl8!@$*i$2^h!8mo@ziom2(@ace$-t-3%oo)zj4z66g+oc$	8	0	1
\.


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: anteeone
--

SELECT pg_catalog.setval('public.orders_id_seq', 12, true);


--
-- Name: quests_id_seq; Type: SEQUENCE SET; Schema: public; Owner: anteeone
--

SELECT pg_catalog.setval('public.quests_id_seq', 20, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: anteeone
--

SELECT pg_catalog.setval('public.users_id_seq', 2, true);


--
-- Name: achievement achievement_pkey; Type: CONSTRAINT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.achievement
    ADD CONSTRAINT achievement_pkey PRIMARY KEY (id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: quests quests_pkey; Type: CONSTRAINT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.quests
    ADD CONSTRAINT quests_pkey PRIMARY KEY (id);


--
-- Name: user_achievements user_achievements_pkey; Type: CONSTRAINT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.user_achievements
    ADD CONSTRAINT user_achievements_pkey PRIMARY KEY (user_id, achievement_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: user_achievements user_achievements_achievement_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.user_achievements
    ADD CONSTRAINT user_achievements_achievement_id_fkey FOREIGN KEY (achievement_id) REFERENCES public.achievement(id) ON DELETE RESTRICT;


--
-- Name: user_achievements user_achievements_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.user_achievements
    ADD CONSTRAINT user_achievements_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE RESTRICT;


--
-- Name: users users_active_quest_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: anteeone
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_active_quest_id_fkey FOREIGN KEY (active_quest_id) REFERENCES public.quests(id);


--
-- PostgreSQL database dump complete
--

