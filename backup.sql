--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3 (Ubuntu 10.3-1.pgdg16.04+1)
-- Dumped by pg_dump version 10.3 (Ubuntu 10.3-1.pgdg16.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: app_role; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.app_role (
    role_id bigint NOT NULL,
    role_name character varying(30) NOT NULL
);


--
-- Name: app_role_role_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.app_role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: app_role_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.app_role_role_id_seq OWNED BY public.app_role.role_id;


--
-- Name: app_user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.app_user (
    user_name character varying(36) NOT NULL,
    encryted_password character varying(128) NOT NULL,
    enabled boolean NOT NULL,
    email text NOT NULL,
    user_id bigint NOT NULL,
    confirmation_token text,
    balance integer DEFAULT 0 NOT NULL
);


--
-- Name: app_user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.app_user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: app_user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.app_user_user_id_seq OWNED BY public.app_user.user_id;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.employee (
    emp_id bigint NOT NULL,
    user_id bigint NOT NULL,
    nama text NOT NULL,
    alamat text NOT NULL,
    gaji integer NOT NULL,
    bonus integer NOT NULL
);


--
-- Name: employee_emp_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.employee_emp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: employee_emp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.employee_emp_id_seq OWNED BY public.employee.emp_id;


--
-- Name: movie; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.movie (
    movieid bigint NOT NULL,
    moviename character varying(100),
    imdblink character varying(100),
    posterlink character varying(200)
);


--
-- Name: movie_movieid_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.movie_movieid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: movie_movieid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.movie_movieid_seq OWNED BY public.movie.movieid;


--
-- Name: user_role; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.user_role (
    user_id numeric NOT NULL,
    role_id numeric NOT NULL,
    id bigint NOT NULL
);


--
-- Name: user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.user_role_id_seq OWNED BY public.user_role.id;


--
-- Name: your_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.your_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: app_role role_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.app_role ALTER COLUMN role_id SET DEFAULT nextval('public.app_role_role_id_seq'::regclass);


--
-- Name: app_user user_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.app_user ALTER COLUMN user_id SET DEFAULT nextval('public.app_user_user_id_seq'::regclass);


--
-- Name: employee emp_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.employee ALTER COLUMN emp_id SET DEFAULT nextval('public.employee_emp_id_seq'::regclass);


--
-- Name: movie movieid; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.movie ALTER COLUMN movieid SET DEFAULT nextval('public.movie_movieid_seq'::regclass);


--
-- Name: user_role id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_role ALTER COLUMN id SET DEFAULT nextval('public.user_role_id_seq'::regclass);


--
-- Data for Name: app_role; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.app_role (role_id, role_name) FROM stdin;
1	ROLE_ADMIN
2	ROLE_USER
3	ROLE_EMPLOYEE
\.


--
-- Data for Name: app_user; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.app_user (user_name, encryted_password, enabled, email, user_id, confirmation_token, balance) FROM stdin;
angga	$2a$10$6GGQRA9.zlRetUOlh0cNY.IKGjpi8bL73ZseCpBhHf9neniMgroDW	t	anggakp9a@gmail.com	35	d0f10eb4-7803-46f5-99c8-9870ae55d3d0	0
guzp	$2a$10$6htavwhEAXAvCvr4eZSEtujHGKjveUUgvC6YLihMImh1rXR45JA96	f	asu@gmail	36	41c6699b-daa6-4a75-be82-b4cbfd03ea8a	0
zui	$2a$10$5M.52FtQLZYuMWGZqOVrD.yHyrYfPJIUjWiQoeW7Bbr6WCvB1b662	t	prasetyo.raharja12@gmail.com	38	66c3d761-6735-4fcb-86c0-ed0a4f01bd33	0
nila	$2a$10$EkSf.KWyT7KgloHrh.hEW.npeFDnA10UZidYJj9x5ITS7mAeoMeC.	t	artanila15@gmail.com	40	b3b2cd0c-8241-4054-b826-2f38dd6f5720	0
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.employee (emp_id, user_id, nama, alamat, gaji, bonus) FROM stdin;
\.


--
-- Data for Name: movie; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.movie (movieid, moviename, imdblink, posterlink) FROM stdin;
1	Black Panther	https://www.imdb.com/title/tt1825683/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BMTg1MTY2MjYzNV5BMl5BanBnXkFtZTgwMTc4NTMwNDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg
\.


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.user_role (user_id, role_id, id) FROM stdin;
5	1	1
5	2	2
35	2	4
38	2	6
38	1	7
38	1	22
40	2	23
40	1	24
35	1	25
38	3	26
\.


--
-- Name: app_role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.app_role_role_id_seq', 2, true);


--
-- Name: app_user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.app_user_user_id_seq', 40, true);


--
-- Name: employee_emp_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.employee_emp_id_seq', 1, false);


--
-- Name: movie_movieid_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.movie_movieid_seq', 1, true);


--
-- Name: user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.user_role_id_seq', 26, true);


--
-- Name: your_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.your_seq', 1, false);


--
-- Name: app_user app_user_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (user_id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (emp_id);


--
-- Name: movie idx_16401_primary; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT idx_16401_primary PRIMARY KEY (movieid);


--
-- Name: app_role pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.app_role
    ADD CONSTRAINT pk PRIMARY KEY (role_id);


--
-- Name: user_role pk_1; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT pk_1 PRIMARY KEY (id);


--
-- Name: idx_16395_app_user_uk; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX idx_16395_app_user_uk ON public.app_user USING btree (user_name);


--
-- Name: idx_16407_user_role_fk1; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_16407_user_role_fk1 ON public.user_role USING btree (user_id);


--
-- Name: idx_16407_user_role_fk2; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX idx_16407_user_role_fk2 ON public.user_role USING btree (role_id);


--
-- Name: employee fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk FOREIGN KEY (user_id) REFERENCES public.app_user(user_id);


--
-- PostgreSQL database dump complete
--

