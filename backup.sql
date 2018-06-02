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
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: app_role; Type: TABLE; Schema: public; Owner: bagus
--

CREATE TABLE public.app_role (
    role_id bigint NOT NULL,
    role_name character varying(30) NOT NULL
);


ALTER TABLE public.app_role OWNER TO bagus;

--
-- Name: app_role_role_id_seq; Type: SEQUENCE; Schema: public; Owner: bagus
--

CREATE SEQUENCE public.app_role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.app_role_role_id_seq OWNER TO bagus;

--
-- Name: app_role_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bagus
--

ALTER SEQUENCE public.app_role_role_id_seq OWNED BY public.app_role.role_id;


--
-- Name: app_user; Type: TABLE; Schema: public; Owner: bagus
--

CREATE TABLE public.app_user (
    user_name character varying(36) NOT NULL,
    encryted_password character varying(128) NOT NULL,
    enabled boolean NOT NULL,
    email text NOT NULL,
    user_id bigint NOT NULL,
    confirmation_token text,
    balance integer DEFAULT 0 NOT NULL,
    datecreated timestamp with time zone
);


ALTER TABLE public.app_user OWNER TO bagus;

--
-- Name: app_user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: bagus
--

CREATE SEQUENCE public.app_user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.app_user_user_id_seq OWNER TO bagus;

--
-- Name: app_user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bagus
--

ALTER SEQUENCE public.app_user_user_id_seq OWNED BY public.app_user.user_id;


--
-- Name: cabang; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cabang (
    id_cabang bigint NOT NULL,
    alamat text NOT NULL,
    status boolean NOT NULL
);


ALTER TABLE public.cabang OWNER TO postgres;

--
-- Name: cabang_id_cabang_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cabang_id_cabang_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cabang_id_cabang_seq OWNER TO postgres;

--
-- Name: cabang_id_cabang_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cabang_id_cabang_seq OWNED BY public.cabang.id_cabang;


--
-- Name: detail_jam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detail_jam (
    id_jam bigint NOT NULL,
    jam_mulai integer NOT NULL,
    jam_selesai integer NOT NULL
);


ALTER TABLE public.detail_jam OWNER TO postgres;

--
-- Name: detail_jam_id_jam_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detail_jam_id_jam_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detail_jam_id_jam_seq OWNER TO postgres;

--
-- Name: detail_jam_id_jam_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detail_jam_id_jam_seq OWNED BY public.detail_jam.id_jam;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    emp_id bigint NOT NULL,
    user_id bigint NOT NULL,
    nama text NOT NULL,
    alamat text NOT NULL,
    gaji integer DEFAULT 0,
    bonus integer DEFAULT 0
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: employee_emp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_emp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_emp_id_seq OWNER TO postgres;

--
-- Name: employee_emp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employee_emp_id_seq OWNED BY public.employee.emp_id;


--
-- Name: jadwal_booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jadwal_booking (
    id_jadwal bigint NOT NULL,
    user_id bigint NOT NULL,
    id_kamar bigint NOT NULL,
    id_jam integer NOT NULL,
    tanggal_booking date,
    tanggal_transaksi time without time zone,
    id_movie bigint,
    status boolean
);


ALTER TABLE public.jadwal_booking OWNER TO postgres;

--
-- Name: jadwal_booking_id_jadwal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jadwal_booking_id_jadwal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jadwal_booking_id_jadwal_seq OWNER TO postgres;

--
-- Name: jadwal_booking_id_jadwal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jadwal_booking_id_jadwal_seq OWNED BY public.jadwal_booking.id_jadwal;


--
-- Name: jadwal_harian_karyawan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jadwal_harian_karyawan (
    id_harian bigint NOT NULL,
    id_jadwal bigint NOT NULL,
    tanggal integer NOT NULL
);


ALTER TABLE public.jadwal_harian_karyawan OWNER TO postgres;

--
-- Name: jadwal_harian_karyawan_id_harian_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jadwal_harian_karyawan_id_harian_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jadwal_harian_karyawan_id_harian_seq OWNER TO postgres;

--
-- Name: jadwal_harian_karyawan_id_harian_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jadwal_harian_karyawan_id_harian_seq OWNED BY public.jadwal_harian_karyawan.id_harian;


--
-- Name: jadwal_karyawan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jadwal_karyawan (
    id_jadwal bigint NOT NULL,
    bulan integer NOT NULL,
    tahun integer NOT NULL
);


ALTER TABLE public.jadwal_karyawan OWNER TO postgres;

--
-- Name: jadwal_id_jadwal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jadwal_id_jadwal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jadwal_id_jadwal_seq OWNER TO postgres;

--
-- Name: jadwal_id_jadwal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jadwal_id_jadwal_seq OWNED BY public.jadwal_karyawan.id_jadwal;


--
-- Name: kamar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kamar (
    id_kamar bigint NOT NULL,
    id_cabang bigint NOT NULL,
    kapasitas integer NOT NULL,
    jenis_kamar character varying(20) NOT NULL,
    status boolean NOT NULL,
    harga integer
);


ALTER TABLE public.kamar OWNER TO postgres;

--
-- Name: kamar_id_kamar_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.kamar_id_kamar_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.kamar_id_kamar_seq OWNER TO postgres;

--
-- Name: kamar_id_kamar_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.kamar_id_kamar_seq OWNED BY public.kamar.id_kamar;


--
-- Name: movie; Type: TABLE; Schema: public; Owner: bagus
--

CREATE TABLE public.movie (
    moviename character varying(100),
    imdblink text,
    posterlink text,
    movieid bigint NOT NULL,
    release_date date NOT NULL,
    synopsis text,
    status boolean
);


ALTER TABLE public.movie OWNER TO bagus;

--
-- Name: movie_movieid_seq; Type: SEQUENCE; Schema: public; Owner: bagus
--

CREATE SEQUENCE public.movie_movieid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movie_movieid_seq OWNER TO bagus;

--
-- Name: movie_movieid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bagus
--

ALTER SEQUENCE public.movie_movieid_seq OWNED BY public.movie.movieid;


--
-- Name: shift; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shift (
    id_shift bigint NOT NULL,
    id_harian bigint NOT NULL,
    emp_id bigint NOT NULL,
    shift integer NOT NULL
);


ALTER TABLE public.shift OWNER TO postgres;

--
-- Name: shift_id_shift_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.shift_id_shift_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.shift_id_shift_seq OWNER TO postgres;

--
-- Name: shift_id_shift_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.shift_id_shift_seq OWNED BY public.shift.id_shift;


--
-- Name: user_profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_profile (
    profileid bigint NOT NULL,
    userid bigint NOT NULL,
    name text,
    address text,
    telp text,
    datecreated date NOT NULL
);


ALTER TABLE public.user_profile OWNER TO postgres;

--
-- Name: user_profile_profileid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_profile_profileid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_profile_profileid_seq OWNER TO postgres;

--
-- Name: user_profile_profileid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_profile_profileid_seq OWNED BY public.user_profile.profileid;


--
-- Name: user_role; Type: TABLE; Schema: public; Owner: bagus
--

CREATE TABLE public.user_role (
    user_id numeric NOT NULL,
    role_id numeric NOT NULL,
    id bigint NOT NULL
);


ALTER TABLE public.user_role OWNER TO bagus;

--
-- Name: user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: bagus
--

CREATE SEQUENCE public.user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_role_id_seq OWNER TO bagus;

--
-- Name: user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bagus
--

ALTER SEQUENCE public.user_role_id_seq OWNED BY public.user_role.id;


--
-- Name: your_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.your_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.your_seq OWNER TO postgres;

--
-- Name: app_role role_id; Type: DEFAULT; Schema: public; Owner: bagus
--

ALTER TABLE ONLY public.app_role ALTER COLUMN role_id SET DEFAULT nextval('public.app_role_role_id_seq'::regclass);


--
-- Name: app_user user_id; Type: DEFAULT; Schema: public; Owner: bagus
--

ALTER TABLE ONLY public.app_user ALTER COLUMN user_id SET DEFAULT nextval('public.app_user_user_id_seq'::regclass);


--
-- Name: cabang id_cabang; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cabang ALTER COLUMN id_cabang SET DEFAULT nextval('public.cabang_id_cabang_seq'::regclass);


--
-- Name: detail_jam id_jam; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_jam ALTER COLUMN id_jam SET DEFAULT nextval('public.detail_jam_id_jam_seq'::regclass);


--
-- Name: employee emp_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN emp_id SET DEFAULT nextval('public.employee_emp_id_seq'::regclass);


--
-- Name: jadwal_booking id_jadwal; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_booking ALTER COLUMN id_jadwal SET DEFAULT nextval('public.jadwal_booking_id_jadwal_seq'::regclass);


--
-- Name: jadwal_harian_karyawan id_harian; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_harian_karyawan ALTER COLUMN id_harian SET DEFAULT nextval('public.jadwal_harian_karyawan_id_harian_seq'::regclass);


--
-- Name: jadwal_karyawan id_jadwal; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_karyawan ALTER COLUMN id_jadwal SET DEFAULT nextval('public.jadwal_id_jadwal_seq'::regclass);


--
-- Name: kamar id_kamar; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kamar ALTER COLUMN id_kamar SET DEFAULT nextval('public.kamar_id_kamar_seq'::regclass);


--
-- Name: movie movieid; Type: DEFAULT; Schema: public; Owner: bagus
--

ALTER TABLE ONLY public.movie ALTER COLUMN movieid SET DEFAULT nextval('public.movie_movieid_seq'::regclass);


--
-- Name: shift id_shift; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shift ALTER COLUMN id_shift SET DEFAULT nextval('public.shift_id_shift_seq'::regclass);


--
-- Name: user_profile profileid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_profile ALTER COLUMN profileid SET DEFAULT nextval('public.user_profile_profileid_seq'::regclass);


--
-- Name: user_role id; Type: DEFAULT; Schema: public; Owner: bagus
--

ALTER TABLE ONLY public.user_role ALTER COLUMN id SET DEFAULT nextval('public.user_role_id_seq'::regclass);


--
-- Data for Name: app_role; Type: TABLE DATA; Schema: public; Owner: bagus
--

COPY public.app_role (role_id, role_name) FROM stdin;
1	ROLE_ADMIN
2	ROLE_USER
3	ROLE_EMPLOYEE
\.


--
-- Data for Name: app_user; Type: TABLE DATA; Schema: public; Owner: bagus
--

COPY public.app_user (user_name, encryted_password, enabled, email, user_id, confirmation_token, balance, datecreated) FROM stdin;
qwqwqwq	$2a$10$j67BQ6zKIuaJQOmG.gxU.eC5KoytYaeGPlqoTqPI7DPqN5895q1FK	f	sad@qwq	14	24ffaee0-ee3a-4dbb-8b01-1a88dc559135	0	2018-05-25 11:40:49.549+08
asdssda	$2a$10$O55lw7CnHEE9uVMOkm4RzeKHN7BaZnkRTdBYZFK5TniSvpDgRdF.u	f	a@4	15	40f784ee-4f12-48df-8a1c-7c4b9804b919	0	2018-05-25 11:49:09.43+08
zzzzz	$2a$10$pn.kNUXFregHoiI6HJbdVeOmatnwvTEUMQXP4wNFQTzNGviticZte	f	aweaaw@wqe	16	c95998b8-732d-468b-b852-b6edb0e058b6	0	2018-05-25 12:10:48.326+08
zzzzz1	$2a$10$s0rrELktawmKgFcGRJDPPu6wiuHX6w7cjsNne54iAfJUKCaS28CsK	f	aweaaw@wqe	17	0139cc0c-f5fa-4d1c-a7c4-338416ab0bb2	0	2018-05-25 12:11:59.094+08
sad	$2a$10$PJ3/sN1Xd.82qH.BQhhGiurKaLMzXNLNSz062eKGwfQP7q8t/0B/S	f	sadsad@1	18	2ef43bf3-bfb9-4791-99d2-1b2b90a71c8c	0	2018-05-25 12:12:47.987+08
admin	$2a$10$F3oasoRGpJ.iA3bd6CZOV.FLhh3KdZ53k8S0GSxRTAFQZwgLscxdG	t	prasetyo.raharja12@gmail.com	1	4d18897d-589d-4b80-bbc6-256703af8661	107600	2018-05-06 14:12:37.327+08
a	$2a$10$P1sc5aM0sqcL6tVmIaKJiu/YwnaZdYmgMW6ZybnJ1ZKx0l4rMx2O6	f	a@a	2	8676642b-c512-4e03-a65f-7d2059779346	0	2018-05-16 11:34:10.147+08
natsy	$2a$10$yt5/Py2J7tr5yvvigq/4fufQ/wjRIscIraj9Pc7UTqU.KeRUXrZq.	t	ramadityanurjana@gmail.com	3	552c676f-a900-4d74-b32b-4cb3fc8a6bb1	50000	2018-05-21 09:53:49.746+08
vzn	$2a$10$MkgsOGJKRovwNnufuhvZ4edOmZaAZwo2AHRfFFVDvA7G.2.Y3kjca	f	a@a	4	33b0e881-6bd1-4c43-b7f7-ab3536d11a94	0	2018-05-23 12:00:30.596+08
ax	$2a$10$Z4ulnufqTjfXhPvAKobFdeImUyTd.qnL./D1KXqUlDFey6XdrtsA6	f	a@b	5	19fdd357-d68d-4900-a3a7-4cc935480356	0	2018-05-24 20:49:40.909+08
aazx	$2a$10$esmqfwWWFSu0UHNQj4k9f.ziwu27RMdfDE4xBMOPyMjvw9czot1Ji	f	a@r	6	7a9a0a2c-82a1-4d35-a117-198378a73065	0	2018-05-25 11:22:47.849+08
sadsasad	$2a$10$kMuTk2n3HWW2ZQI.IRD1au4jGn1Wl.I3KRsPa2wi5corv6tvytMQS	f	sadad@o	7	c2def533-772b-4d58-a697-7bc05e964ba9	0	2018-05-25 11:23:48.406+08
sadsasadxa	$2a$10$xmHikLH80L28eHNnDe6GHOFWoiVXmwVBcGj2lcloeMUgY./BekL1G	f	sadad@oxa	8	49190d6a-e8aa-4b10-9622-373b83ef93c1	0	2018-05-25 11:24:07.464+08
qwqwqw	$2a$10$NlIAM1IACiwritmBsnLOwuJB8blxeBzDKbpyT8iLqQof7usiYvM5a	f	aac@qq	9	37a0299f-40aa-4a91-86c1-05a57ceee96b	0	2018-05-25 11:28:29.335+08
qqqqq	$2a$10$2AlH6COVJCITyvSKptGkL.p5a0pgg2NYPYObwq65NxZ.w.9ZLFgRi	f	a@q	10	8dd75184-b39e-4355-8413-04d16981209a	0	2018-05-25 11:29:25.236+08
qweqwe	$2a$10$U/76v/2VGyXi5I9xL/uon.qMMfWRC5lE6AvEEmewAgN94MiDXvYq.	f	sdasa@qqqq	11	07d83e90-aba5-4f68-b4d3-6affa379f69d	0	2018-05-25 11:30:42.549+08
sadsadsda	$2a$10$ZYym.kaU2P4ameDmJHmfqOP9SkvoEUR01glqdIZd5QmG1tkXSxy/q	f	sadasda@qqqsda	12	0e28d04a-fe7d-44dd-bd95-13668d862f6a	0	2018-05-25 11:32:42.466+08
sadsda	$2a$10$NBLnKQ2D6otrjxUeGS744OsQGsp9Z1czKkJp5hMxmkHLKSRX/wF9C	f	sadsda@a	13	470af940-7170-485e-b9d5-b9cdb8eb6a8e	0	2018-05-25 11:33:54.356+08
\.


--
-- Data for Name: cabang; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cabang (id_cabang, alamat, status) FROM stdin;
3	Russia	t
2	Indonesia	t
1	Amerika	f
\.


--
-- Data for Name: detail_jam; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detail_jam (id_jam, jam_mulai, jam_selesai) FROM stdin;
1	9	11
2	12	14
3	15	17
4	18	20
5	21	23
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (emp_id, user_id, nama, alamat, gaji, bonus) FROM stdin;
1	1	Bagus Prasetyo	Jln.Wijaya Kusuma	0	0
\.


--
-- Data for Name: jadwal_booking; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jadwal_booking (id_jadwal, user_id, id_kamar, id_jam, tanggal_booking, tanggal_transaksi, id_movie, status) FROM stdin;
25	3	3	2	2018-05-22	10:07:25.679	14	f
\.


--
-- Data for Name: jadwal_harian_karyawan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jadwal_harian_karyawan (id_harian, id_jadwal, tanggal) FROM stdin;
1	1	1
2	1	2
3	1	3
4	2	1
5	2	2
6	2	3
7	3	1
8	3	2
9	3	3
\.


--
-- Data for Name: jadwal_karyawan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jadwal_karyawan (id_jadwal, bulan, tahun) FROM stdin;
1	1	2018
2	2	2018
3	3	2018
4	1	2017
5	2	2017
6	3	2017
\.


--
-- Data for Name: kamar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.kamar (id_kamar, id_cabang, kapasitas, jenis_kamar, status, harga) FROM stdin;
1	1	30	Premium1	t	100000
3	2	10	Regular1	t	50000
4	2	20	Standar1	t	20000
2	1	20	Standard1	t	20000
5	3	30	Premium1	t	100000
\.


--
-- Data for Name: movie; Type: TABLE DATA; Schema: public; Owner: bagus
--

COPY public.movie (moviename, imdblink, posterlink, movieid, release_date, synopsis, status) FROM stdin;
The Amazing Spider-Man 2	https://www.imdb.com/title/tt1872181/?ref_=nv_sr_7	https://ia.media-imdb.com/images/M/MV5BOTA5NDYxNTg0OV5BMl5BanBnXkFtZTgwODE5NzU1MTE@._V1_SY1000_SX675_AL_.jpg	24	2014-12-04	\N	f
Critical Eleven	https://www.imdb.com/title/tt6426714/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BMjNhNDI0YWEtNDlhNi00ZGFmLThjZDgtZDFmMTk0Y2E5NzQ1XkEyXkFqcGdeQXVyMjgzNTIxNDE@._V1_SY1000_CR0,0,799,1000_AL_.jpg	26	2017-10-05	\N	f
Avengers: Infinity War	https://www.imdb.com/title/tt4154756/	https://ia.media-imdb.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SY1000_CR0,0,674,1000_AL_.jpg	1	2018-04-26	\N	t
Black Panther	https://www.imdb.com/title/tt1825683/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BMTg1MTY2MjYzNV5BMl5BanBnXkFtZTgwMTc4NTMwNDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg	3	2018-02-13	\N	t
Pacific Rim: Uprising	https://www.imdb.com/title/tt2557478/?ref_=inth_ov_tt	https://ia.media-imdb.com/images/M/MV5BMjI3Nzg0MTM5NF5BMl5BanBnXkFtZTgwOTE2MTgwNTM@._V1_.jpg	4	2018-03-23	\N	t
Mata Batin	https://www.imdb.com/title/tt6506146/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BNGI3MTYzM2QtZjcyNi00N2QxLWI0MDctYzhmYjhkOWQyZmUyXkEyXkFqcGdeQXVyMzYzOTYxNzM@._V1_SY1000_CR0,0,683,1000_AL_.jpg	27	2017-11-30	\N	f
Brawl in Cell Block 99	https://www.imdb.com/title/tt5657856/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BMzQ4MjEyNjg4Nl5BMl5BanBnXkFtZTgwOTY1NDEzMzI@._V1_SY1000_CR0,0,674,1000_AL_.jpg	25	2017-01-02	\N	f
The Amazing Spider-Man	https://www.imdb.com/title/tt0948470/?ref_=nv_sr_6	https://ia.media-imdb.com/images/M/MV5BMjMyOTM4MDMxNV5BMl5BanBnXkFtZTcwNjIyNzExOA@@._V1_SY1000_CR0,0,674,1000_AL_.jpg	23	2012-02-07	\N	f
Spider-Man	https://www.imdb.com/title/tt0145487/?ref_=nv_sr_4	https://ia.media-imdb.com/images/M/MV5BZDEyN2NhMjgtMjdhNi00MmNlLWE5YTgtZGE4MzNjMTRlMGEwXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_.jpg	22	2002-06-12	\N	f
Thor: Ragnarok	https://www.imdb.com/title/tt3501632/?ref_=tt_rec_tt	https://ia.media-imdb.com/images/M/MV5BMjMyNDkzMzI1OF5BMl5BanBnXkFtZTgwODcxODg5MjI@._V1_SY1000_CR0,0,674,1000_AL_.jpg	2	2017-10-24	\N	t
Fifty Shades of Grey	https://www.imdb.com/title/tt2322441/?ref_=nv_sr_2	https://ia.media-imdb.com/images/M/MV5BMjE1MTM4NDAzOF5BMl5BanBnXkFtZTgwNTMwNjI0MzE@._V1_SY1000_CR0,0,631,1000_AL_.jpg	19	2015-02-13	\N	f
Fifty Shades Darker	https://www.imdb.com/title/tt4465564/?ref_=nv_sr_3	https://ia.media-imdb.com/images/M/MV5BMTQ5NTk0Njg2N15BMl5BanBnXkFtZTgwNzk5Nzk3MDI@._V1_SY1000_CR0,0,631,1000_AL_.jpg	20	2017-02-10	\N	f
Transformers: The Last Knight	https://www.imdb.com/title/tt3371366/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BMTk3OTI3MDk4N15BMl5BanBnXkFtZTgwNDg2ODIyMjI@._V1_.jpg	21	2017-06-22	\N	f
Coco	https://www.imdb.com/title/tt2380307/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=e31d89dd-322d-4646-8962-327b42fe94b1&pf_rd_r=4PBDZEVJDPP5QXEE6GX1&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_62	https://ia.media-imdb.com/images/M/MV5BYjQ5NjM0Y2YtNjZkNC00ZDhkLWJjMWItN2QyNzFkMDE3ZjAxXkEyXkFqcGdeQXVyODIxMzk5NjA@._V1_SY1000_CR0,0,699,1000_AL_.jpg	6	2017-01-10	\N	t
Deadpool 2	https://www.imdb.com/title/tt5463162/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2413b25e-e3f6-4229-9efd-599bb9ab1f97&pf_rd_r=EAMBAHTDR75DEFGAYMVK&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_t0	https://ia.media-imdb.com/images/M/MV5BMjI3Njg3MzAxNF5BMl5BanBnXkFtZTgwNjI2OTY0NTM@._V1_SY1000_CR0,0,674,1000_AL_.jpg	14	2018-05-15	\N	t
Jumanji: Welcome to the Jungle	https://www.imdb.com/title/tt2283362/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BODQ0NDhjYWItYTMxZi00NTk2LWIzNDEtOWZiYWYxZjc2MTgxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,674,1000_AL_.jpg	15	2017-12-20	\N	t
Captain America : The First Avenger	https://www.imdb.com/title/tt0458339/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BMTYzOTc2NzU3N15BMl5BanBnXkFtZTcwNjY3MDE3NQ@@._V1_SY1000_CR0,0,640,1000_AL_.jpg	16	2011-07-29	\N	t
Avengers: Age of Ultron	https://www.imdb.com/title/tt2395427/?ref_=nv_sr_8	https://ia.media-imdb.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SY1000_SX675_AL_.jpg	17	2015-04-23	\N	t
The Incridible Hulk	https://www.imdb.com/title/tt0800080/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BMTUyNzk3MjA1OF5BMl5BanBnXkFtZTcwMTE1Njg2MQ@@._V1_SY1000_CR0,0,674,1000_AL_.jpg	18	2008-06-13	\N	t
 The Doll 2 	https://www.imdb.com/title/tt6409782/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BMGFhZjY1YWItNjdiOC00ZDFmLWJlNGYtYjU4NDdiYTA1YTMyXkEyXkFqcGdeQXVyMzYzOTYxNzM@._V1_SY1000_CR0,0,750,1000_AL_.jpg	28	2017-07-20	\N	f
Jailangkung	https://www.imdb.com/title/tt7076668/?ref_=nv_sr_1	https://ia.media-imdb.com/images/M/MV5BYTE0MTg0ZmMtMjYwMC00NWNiLWIwN2EtMzJjYWFkMzliMmJmXkEyXkFqcGdeQXVyMzMzNjk0NTc@._V1_SY1000_CR0,0,700,1000_AL_.jpg	29	2017-06-25	\N	f
Danur: I Can See Ghosts	https://www.imdb.com/title/tt6496236/?ref_=nv_sr_2	https://ia.media-imdb.com/images/M/MV5BYWNlODg3YTMtMTQxNC00NGFkLTk1MGQtMDhiYWU3ZjVjYjM2XkEyXkFqcGdeQXVyMzMzNjk0NTc@._V1_SY1000_SX680_AL_.jpg	30	2017-03-30	\N	f
\.


--
-- Data for Name: shift; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shift (id_shift, id_harian, emp_id, shift) FROM stdin;
\.


--
-- Data for Name: user_profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_profile (profileid, userid, name, address, telp, datecreated) FROM stdin;
\.


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: bagus
--

COPY public.user_role (user_id, role_id, id) FROM stdin;
1	2	1
1	1	2
1	3	3
2	3	4
3	2	5
3	2	6
3	2	7
\.


--
-- Name: app_role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bagus
--

SELECT pg_catalog.setval('public.app_role_role_id_seq', 2, true);


--
-- Name: app_user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bagus
--

SELECT pg_catalog.setval('public.app_user_user_id_seq', 18, true);


--
-- Name: cabang_id_cabang_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cabang_id_cabang_seq', 5, true);


--
-- Name: detail_jam_id_jam_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detail_jam_id_jam_seq', 1, false);


--
-- Name: employee_emp_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_emp_id_seq', 1, true);


--
-- Name: jadwal_booking_id_jadwal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jadwal_booking_id_jadwal_seq', 25, true);


--
-- Name: jadwal_harian_karyawan_id_harian_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jadwal_harian_karyawan_id_harian_seq', 1, false);


--
-- Name: jadwal_id_jadwal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jadwal_id_jadwal_seq', 1, false);


--
-- Name: kamar_id_kamar_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.kamar_id_kamar_seq', 5, true);


--
-- Name: movie_movieid_seq; Type: SEQUENCE SET; Schema: public; Owner: bagus
--

SELECT pg_catalog.setval('public.movie_movieid_seq', 30, true);


--
-- Name: shift_id_shift_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.shift_id_shift_seq', 1, false);


--
-- Name: user_profile_profileid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_profile_profileid_seq', 1, false);


--
-- Name: user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bagus
--

SELECT pg_catalog.setval('public.user_role_id_seq', 7, true);


--
-- Name: your_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.your_seq', 1, false);


--
-- Name: app_user app_user_pkey; Type: CONSTRAINT; Schema: public; Owner: bagus
--

ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (user_id);


--
-- Name: cabang cabang_alamat_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cabang
    ADD CONSTRAINT cabang_alamat_key UNIQUE (alamat);


--
-- Name: cabang cabang_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cabang
    ADD CONSTRAINT cabang_pkey PRIMARY KEY (id_cabang);


--
-- Name: detail_jam detail_jam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_jam
    ADD CONSTRAINT detail_jam_pkey PRIMARY KEY (id_jam);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (emp_id);


--
-- Name: jadwal_booking jadwal_booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_booking
    ADD CONSTRAINT jadwal_booking_pkey PRIMARY KEY (id_jadwal);


--
-- Name: jadwal_harian_karyawan jadwal_harian_karyawan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_harian_karyawan
    ADD CONSTRAINT jadwal_harian_karyawan_pkey PRIMARY KEY (id_harian);


--
-- Name: jadwal_karyawan jadwal_karyawan_bulan_tahun_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_karyawan
    ADD CONSTRAINT jadwal_karyawan_bulan_tahun_key UNIQUE (bulan, tahun);


--
-- Name: jadwal_karyawan jadwal_karyawan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_karyawan
    ADD CONSTRAINT jadwal_karyawan_pkey PRIMARY KEY (id_jadwal);


--
-- Name: kamar kamar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kamar
    ADD CONSTRAINT kamar_pkey PRIMARY KEY (id_kamar);


--
-- Name: movie movie_pkey; Type: CONSTRAINT; Schema: public; Owner: bagus
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (movieid);


--
-- Name: app_role pk; Type: CONSTRAINT; Schema: public; Owner: bagus
--

ALTER TABLE ONLY public.app_role
    ADD CONSTRAINT pk PRIMARY KEY (role_id);


--
-- Name: user_role pk_1; Type: CONSTRAINT; Schema: public; Owner: bagus
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT pk_1 PRIMARY KEY (id);


--
-- Name: shift shift_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shift
    ADD CONSTRAINT shift_pkey PRIMARY KEY (id_shift);


--
-- Name: idx_16395_app_user_uk; Type: INDEX; Schema: public; Owner: bagus
--

CREATE UNIQUE INDEX idx_16395_app_user_uk ON public.app_user USING btree (user_name);


--
-- Name: idx_16407_user_role_fk1; Type: INDEX; Schema: public; Owner: bagus
--

CREATE INDEX idx_16407_user_role_fk1 ON public.user_role USING btree (user_id);


--
-- Name: idx_16407_user_role_fk2; Type: INDEX; Schema: public; Owner: bagus
--

CREATE INDEX idx_16407_user_role_fk2 ON public.user_role USING btree (role_id);


--
-- Name: employee fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk FOREIGN KEY (user_id) REFERENCES public.app_user(user_id);


--
-- Name: jadwal_booking jadwal_booking_id_jam_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_booking
    ADD CONSTRAINT jadwal_booking_id_jam_fkey FOREIGN KEY (id_jam) REFERENCES public.detail_jam(id_jam);


--
-- Name: jadwal_booking jadwal_booking_id_kamar_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_booking
    ADD CONSTRAINT jadwal_booking_id_kamar_fkey FOREIGN KEY (id_kamar) REFERENCES public.kamar(id_kamar);


--
-- Name: jadwal_booking jadwal_booking_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_booking
    ADD CONSTRAINT jadwal_booking_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.app_user(user_id);


--
-- Name: jadwal_harian_karyawan jadwal_harian_karyawan_id_jadwal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jadwal_harian_karyawan
    ADD CONSTRAINT jadwal_harian_karyawan_id_jadwal_fkey FOREIGN KEY (id_jadwal) REFERENCES public.jadwal_karyawan(id_jadwal);


--
-- Name: kamar kamar_id_cabang_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kamar
    ADD CONSTRAINT kamar_id_cabang_fkey FOREIGN KEY (id_cabang) REFERENCES public.cabang(id_cabang);


--
-- Name: shift shift_id_harian_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shift
    ADD CONSTRAINT shift_id_harian_fkey FOREIGN KEY (id_harian) REFERENCES public.jadwal_harian_karyawan(id_harian);


--
-- PostgreSQL database dump complete
--

