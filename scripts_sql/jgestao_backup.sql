--
-- PostgreSQL database dump
--

-- Started on 2014-11-08 13:34:22

SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 1780 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';


--
-- TOC entry 467 (class 2612 OID 16386)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 154 (class 1259 OID 34606)
-- Dependencies: 5
-- Name: Agenda; Type: TABLE; Schema: public; Owner: horaciob; Tablespace: 
--

CREATE TABLE "Agenda" (
    id integer NOT NULL,
    descricao character varying(100) NOT NULL,
    data_inicio date,
    data_fim date NOT NULL,
    dia_todo boolean NOT NULL,
    tipo_agenda character varying NOT NULL,
    lista_emails character varying(200),
    tipo_notificacao character varying(1)
);


ALTER TABLE public."Agenda" OWNER TO horaciob;

--
-- TOC entry 153 (class 1259 OID 34604)
-- Dependencies: 5 154
-- Name: Agenda_id_seq; Type: SEQUENCE; Schema: public; Owner: horaciob
--

CREATE SEQUENCE "Agenda_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public."Agenda_id_seq" OWNER TO horaciob;

--
-- TOC entry 1782 (class 0 OID 0)
-- Dependencies: 153
-- Name: Agenda_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: horaciob
--

ALTER SEQUENCE "Agenda_id_seq" OWNED BY "Agenda".id;


--
-- TOC entry 1783 (class 0 OID 0)
-- Dependencies: 153
-- Name: Agenda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: horaciob
--

SELECT pg_catalog.setval('"Agenda_id_seq"', 1, false);


--
-- TOC entry 156 (class 1259 OID 34616)
-- Dependencies: 5
-- Name: agenda; Type: TABLE; Schema: public; Owner: horaciob; Tablespace: 
--

CREATE TABLE agenda (
    id bigint NOT NULL,
    data_fim timestamp without time zone,
    data_inicio timestamp without time zone,
    descricao character varying(255),
    dia_todo boolean,
    lista_emails character varying(255),
    tipo_agenda character varying(255),
    tipo_notificacao character varying(255)
);


ALTER TABLE public.agenda OWNER TO horaciob;

--
-- TOC entry 155 (class 1259 OID 34614)
-- Dependencies: 156 5
-- Name: agenda_id_seq; Type: SEQUENCE; Schema: public; Owner: horaciob
--

CREATE SEQUENCE agenda_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.agenda_id_seq OWNER TO horaciob;

--
-- TOC entry 1784 (class 0 OID 0)
-- Dependencies: 155
-- Name: agenda_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: horaciob
--

ALTER SEQUENCE agenda_id_seq OWNED BY agenda.id;


--
-- TOC entry 1785 (class 0 OID 0)
-- Dependencies: 155
-- Name: agenda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: horaciob
--

SELECT pg_catalog.setval('agenda_id_seq', 16, true);


--
-- TOC entry 152 (class 1259 OID 18155)
-- Dependencies: 5
-- Name: arquivo; Type: TABLE; Schema: public; Owner: horaciob; Tablespace: 
--

CREATE TABLE arquivo (
    id integer NOT NULL,
    descricao character varying(50) NOT NULL,
    tipo_arquivo character varying(30) NOT NULL,
    tabela character varying(30) NOT NULL,
    status character(1),
    id_referencia integer NOT NULL,
    caminho_arquivo character varying(200),
    conteudo bytea
);


ALTER TABLE public.arquivo OWNER TO horaciob;

--
-- TOC entry 151 (class 1259 OID 18153)
-- Dependencies: 152 5
-- Name: arquivo_id_seq; Type: SEQUENCE; Schema: public; Owner: horaciob
--

CREATE SEQUENCE arquivo_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.arquivo_id_seq OWNER TO horaciob;

--
-- TOC entry 1786 (class 0 OID 0)
-- Dependencies: 151
-- Name: arquivo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: horaciob
--

ALTER SEQUENCE arquivo_id_seq OWNED BY arquivo.id;


--
-- TOC entry 1787 (class 0 OID 0)
-- Dependencies: 151
-- Name: arquivo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: horaciob
--

SELECT pg_catalog.setval('arquivo_id_seq', 17, true);


--
-- TOC entry 118 (class 1259 OID 17864)
-- Dependencies: 5
-- Name: auditoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE auditoria (
    id integer NOT NULL,
    periodo_inicial date,
    periodo_final date,
    tipo_documento character varying,
    numero_documento character varying,
    numero_auditoria character varying,
    data_documento date,
    id_irregularidade integer NOT NULL,
    observacao character varying,
    id_legislacao integer NOT NULL,
    status character(1)
);


ALTER TABLE public.auditoria OWNER TO postgres;

--
-- TOC entry 119 (class 1259 OID 17869)
-- Dependencies: 118 5
-- Name: auditoria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE auditoria_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.auditoria_id_seq OWNER TO postgres;

--
-- TOC entry 1789 (class 0 OID 0)
-- Dependencies: 119
-- Name: auditoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE auditoria_id_seq OWNED BY auditoria.id;


--
-- TOC entry 1790 (class 0 OID 0)
-- Dependencies: 119
-- Name: auditoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('auditoria_id_seq', 39, true);


--
-- TOC entry 120 (class 1259 OID 17871)
-- Dependencies: 5
-- Name: codigo_irregularidade; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE codigo_irregularidade (
    id integer NOT NULL,
    codigo character varying,
    descricao character varying,
    status character(1)
);


ALTER TABLE public.codigo_irregularidade OWNER TO postgres;

--
-- TOC entry 121 (class 1259 OID 17876)
-- Dependencies: 5 120
-- Name: codigo_irregularidade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE codigo_irregularidade_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.codigo_irregularidade_id_seq OWNER TO postgres;

--
-- TOC entry 1793 (class 0 OID 0)
-- Dependencies: 121
-- Name: codigo_irregularidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE codigo_irregularidade_id_seq OWNED BY codigo_irregularidade.id;


--
-- TOC entry 1794 (class 0 OID 0)
-- Dependencies: 121
-- Name: codigo_irregularidade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('codigo_irregularidade_id_seq', 24, true);


--
-- TOC entry 122 (class 1259 OID 17878)
-- Dependencies: 5
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE departamento (
    id integer NOT NULL,
    descricao character varying,
    id_unidade_orcamentaria integer NOT NULL,
    status character(1)
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- TOC entry 123 (class 1259 OID 17883)
-- Dependencies: 122 5
-- Name: departamento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE departamento_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.departamento_id_seq OWNER TO postgres;

--
-- TOC entry 1797 (class 0 OID 0)
-- Dependencies: 123
-- Name: departamento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE departamento_id_seq OWNED BY departamento.id;


--
-- TOC entry 1798 (class 0 OID 0)
-- Dependencies: 123
-- Name: departamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('departamento_id_seq', 4, true);


--
-- TOC entry 124 (class 1259 OID 17885)
-- Dependencies: 5
-- Name: empresa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE empresa (
    id integer NOT NULL,
    razao_social character varying,
    cnpj character varying,
    tipo_sistema integer,
    contato character varying,
    telefone character varying,
    celular character varying,
    status character(1)
);


ALTER TABLE public.empresa OWNER TO postgres;

--
-- TOC entry 125 (class 1259 OID 17890)
-- Dependencies: 124 5
-- Name: empresa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE empresa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.empresa_id_seq OWNER TO postgres;

--
-- TOC entry 1801 (class 0 OID 0)
-- Dependencies: 125
-- Name: empresa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE empresa_id_seq OWNED BY empresa.id;


--
-- TOC entry 1802 (class 0 OID 0)
-- Dependencies: 125
-- Name: empresa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('empresa_id_seq', 1, false);


--
-- TOC entry 148 (class 1259 OID 18133)
-- Dependencies: 5
-- Name: empresa_usuaria; Type: TABLE; Schema: public; Owner: horaciob; Tablespace: 
--

CREATE TABLE empresa_usuaria (
    id integer NOT NULL,
    celular character varying(255),
    cnpj character varying(255),
    contato character varying(255),
    razao_social character varying(255),
    telefone character varying(255),
    tiposistema bytea,
    status character(1)
);


ALTER TABLE public.empresa_usuaria OWNER TO horaciob;

--
-- TOC entry 126 (class 1259 OID 17892)
-- Dependencies: 5
-- Name: entidade; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE entidade (
    id integer NOT NULL,
    tipo character varying(1),
    nome character varying,
    endereco character varying,
    cidade character varying,
    estado character varying(2),
    email character varying,
    site character varying,
    brasao bytea,
    status character(1)
);


ALTER TABLE public.entidade OWNER TO postgres;

--
-- TOC entry 127 (class 1259 OID 17897)
-- Dependencies: 5 126
-- Name: entidade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE entidade_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.entidade_id_seq OWNER TO postgres;

--
-- TOC entry 1805 (class 0 OID 0)
-- Dependencies: 127
-- Name: entidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE entidade_id_seq OWNED BY entidade.id;


--
-- TOC entry 1806 (class 0 OID 0)
-- Dependencies: 127
-- Name: entidade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('entidade_id_seq', 1, true);


--
-- TOC entry 150 (class 1259 OID 18149)
-- Dependencies: 5
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: horaciob
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO horaciob;

--
-- TOC entry 1808 (class 0 OID 0)
-- Dependencies: 150
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: horaciob
--

SELECT pg_catalog.setval('hibernate_sequence', 1, false);


--
-- TOC entry 128 (class 1259 OID 17899)
-- Dependencies: 5
-- Name: imagem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE imagem (
    id integer NOT NULL,
    tipo_imagem character varying NOT NULL,
    arquivo bytea NOT NULL,
    id_referencia integer NOT NULL,
    descricao character varying NOT NULL,
    tabela character varying,
    status character(1)
);


ALTER TABLE public.imagem OWNER TO postgres;

--
-- TOC entry 129 (class 1259 OID 17904)
-- Dependencies: 128 5
-- Name: imagem_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE imagem_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.imagem_id_seq OWNER TO postgres;

--
-- TOC entry 1810 (class 0 OID 0)
-- Dependencies: 129
-- Name: imagem_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE imagem_id_seq OWNED BY imagem.id;


--
-- TOC entry 1811 (class 0 OID 0)
-- Dependencies: 129
-- Name: imagem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('imagem_id_seq', 1, true);


--
-- TOC entry 130 (class 1259 OID 17906)
-- Dependencies: 5
-- Name: irregularidades; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE irregularidades (
    id integer NOT NULL,
    tipo_documento character varying,
    numero character varying,
    descricao character varying,
    codigo character varying(2) NOT NULL,
    status character(1)
);


ALTER TABLE public.irregularidades OWNER TO postgres;

--
-- TOC entry 131 (class 1259 OID 17911)
-- Dependencies: 130 5
-- Name: irregularidades_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE irregularidades_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.irregularidades_id_seq OWNER TO postgres;

--
-- TOC entry 1814 (class 0 OID 0)
-- Dependencies: 131
-- Name: irregularidades_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE irregularidades_id_seq OWNED BY irregularidades.id;


--
-- TOC entry 1815 (class 0 OID 0)
-- Dependencies: 131
-- Name: irregularidades_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('irregularidades_id_seq', 21, true);


--
-- TOC entry 132 (class 1259 OID 17913)
-- Dependencies: 5
-- Name: legislacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE legislacao (
    id integer NOT NULL,
    tipo_legislacao integer,
    numero character varying(10),
    data date,
    referencia character varying,
    texto character varying,
    status_legislacao character varying,
    status character(1),
    legislacao_vinculada integer
);


ALTER TABLE public.legislacao OWNER TO postgres;

--
-- TOC entry 133 (class 1259 OID 17918)
-- Dependencies: 132 5
-- Name: legislacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE legislacao_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.legislacao_id_seq OWNER TO postgres;

--
-- TOC entry 1818 (class 0 OID 0)
-- Dependencies: 133
-- Name: legislacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE legislacao_id_seq OWNED BY legislacao.id;


--
-- TOC entry 1819 (class 0 OID 0)
-- Dependencies: 133
-- Name: legislacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('legislacao_id_seq', 4, true);


--
-- TOC entry 134 (class 1259 OID 17920)
-- Dependencies: 5
-- Name: normas_procedimentos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE normas_procedimentos (
    id integer NOT NULL,
    numero character varying(10),
    data_elaboracao date,
    referencia character varying,
    areas_interesse character varying,
    texto character varying,
    legislacao integer,
    data_publicacao date,
    tipo character varying,
    ano character varying(4),
    id_departamento integer,
    status character(1)
);


ALTER TABLE public.normas_procedimentos OWNER TO postgres;

--
-- TOC entry 1821 (class 0 OID 0)
-- Dependencies: 134
-- Name: COLUMN normas_procedimentos.id_departamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN normas_procedimentos.id_departamento IS '�rea de atua��o';


--
-- TOC entry 135 (class 1259 OID 17925)
-- Dependencies: 134 5
-- Name: normas_procedimentos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE normas_procedimentos_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.normas_procedimentos_id_seq OWNER TO postgres;

--
-- TOC entry 1823 (class 0 OID 0)
-- Dependencies: 135
-- Name: normas_procedimentos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE normas_procedimentos_id_seq OWNED BY normas_procedimentos.id;


--
-- TOC entry 1824 (class 0 OID 0)
-- Dependencies: 135
-- Name: normas_procedimentos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('normas_procedimentos_id_seq', 6, true);


--
-- TOC entry 144 (class 1259 OID 18015)
-- Dependencies: 5
-- Name: orgao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orgao (
    id integer NOT NULL,
    codigo character varying(2) NOT NULL,
    descricao character varying,
    status character(1)
);


ALTER TABLE public.orgao OWNER TO postgres;

--
-- TOC entry 145 (class 1259 OID 18017)
-- Dependencies: 5 144
-- Name: orgao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE orgao_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.orgao_id_seq OWNER TO postgres;

--
-- TOC entry 1827 (class 0 OID 0)
-- Dependencies: 145
-- Name: orgao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE orgao_id_seq OWNED BY orgao.id;


--
-- TOC entry 1828 (class 0 OID 0)
-- Dependencies: 145
-- Name: orgao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('orgao_id_seq', 12, true);


--
-- TOC entry 136 (class 1259 OID 17927)
-- Dependencies: 5
-- Name: tipo_legislacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_legislacao (
    id integer NOT NULL,
    codigo character varying(5),
    descricao character varying(50),
    status character(1)
);


ALTER TABLE public.tipo_legislacao OWNER TO postgres;

--
-- TOC entry 137 (class 1259 OID 17929)
-- Dependencies: 136 5
-- Name: tipo_legislacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_legislacao_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tipo_legislacao_id_seq OWNER TO postgres;

--
-- TOC entry 1831 (class 0 OID 0)
-- Dependencies: 137
-- Name: tipo_legislacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_legislacao_id_seq OWNED BY tipo_legislacao.id;


--
-- TOC entry 1832 (class 0 OID 0)
-- Dependencies: 137
-- Name: tipo_legislacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_legislacao_id_seq', 33, true);


--
-- TOC entry 138 (class 1259 OID 17931)
-- Dependencies: 5
-- Name: tipo_sistema; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_sistema (
    id integer NOT NULL,
    sigla_tipo_sistema character varying,
    descricao character varying,
    nome_sistema character varying,
    status character(1)
);


ALTER TABLE public.tipo_sistema OWNER TO postgres;

--
-- TOC entry 139 (class 1259 OID 17936)
-- Dependencies: 5 138
-- Name: tipo_sistema_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_sistema_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tipo_sistema_id_seq OWNER TO postgres;

--
-- TOC entry 1835 (class 0 OID 0)
-- Dependencies: 139
-- Name: tipo_sistema_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_sistema_id_seq OWNED BY tipo_sistema.id;


--
-- TOC entry 1836 (class 0 OID 0)
-- Dependencies: 139
-- Name: tipo_sistema_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_sistema_id_seq', 1, false);


--
-- TOC entry 147 (class 1259 OID 18030)
-- Dependencies: 5
-- Name: unidade; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE unidade (
    id integer NOT NULL,
    codigo character varying(2),
    descricao character varying,
    id_orgao integer NOT NULL,
    status character(1)
);


ALTER TABLE public.unidade OWNER TO postgres;

--
-- TOC entry 146 (class 1259 OID 18028)
-- Dependencies: 147 5
-- Name: unidade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE unidade_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.unidade_id_seq OWNER TO postgres;

--
-- TOC entry 1839 (class 0 OID 0)
-- Dependencies: 146
-- Name: unidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE unidade_id_seq OWNED BY unidade.id;


--
-- TOC entry 1840 (class 0 OID 0)
-- Dependencies: 146
-- Name: unidade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('unidade_id_seq', 3, true);


--
-- TOC entry 140 (class 1259 OID 17938)
-- Dependencies: 5
-- Name: unidade_orcamentaria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE unidade_orcamentaria (
    id integer NOT NULL,
    codigo character(6),
    descricao character varying(50),
    id_unidade integer NOT NULL,
    status character(1)
);


ALTER TABLE public.unidade_orcamentaria OWNER TO postgres;

--
-- TOC entry 141 (class 1259 OID 17940)
-- Dependencies: 5 140
-- Name: unidade_orcamentaria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE unidade_orcamentaria_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.unidade_orcamentaria_id_seq OWNER TO postgres;

--
-- TOC entry 1843 (class 0 OID 0)
-- Dependencies: 141
-- Name: unidade_orcamentaria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE unidade_orcamentaria_id_seq OWNED BY unidade_orcamentaria.id;


--
-- TOC entry 1844 (class 0 OID 0)
-- Dependencies: 141
-- Name: unidade_orcamentaria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('unidade_orcamentaria_id_seq', 8, true);


--
-- TOC entry 142 (class 1259 OID 17942)
-- Dependencies: 5
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id integer NOT NULL,
    nome character varying NOT NULL,
    cpf character varying,
    identidade character varying,
    nome_mae character varying,
    senha character varying,
    data_nascimento date,
    "login" character varying,
    email character varying,
    nivel character varying,
    empresa character varying,
    cargo_ou_funcao character varying,
    status character(1)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 149 (class 1259 OID 18140)
-- Dependencies: 5
-- Name: usuario_empresa; Type: TABLE; Schema: public; Owner: horaciob; Tablespace: 
--

CREATE TABLE usuario_empresa (
    id integer NOT NULL,
    empresa_id integer,
    usuario_id bigint,
    status character(1)
);


ALTER TABLE public.usuario_empresa OWNER TO horaciob;

--
-- TOC entry 143 (class 1259 OID 17947)
-- Dependencies: 142 5
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 1847 (class 0 OID 0)
-- Dependencies: 143
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_seq OWNED BY usuario.id;


--
-- TOC entry 1848 (class 0 OID 0)
-- Dependencies: 143
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_seq', 3, true);


--
-- TOC entry 1706 (class 2604 OID 34608)
-- Dependencies: 154 153 154
-- Name: id; Type: DEFAULT; Schema: public; Owner: horaciob
--

ALTER TABLE "Agenda" ALTER COLUMN id SET DEFAULT nextval('"Agenda_id_seq"'::regclass);


--
-- TOC entry 1707 (class 2604 OID 34618)
-- Dependencies: 155 156 156
-- Name: id; Type: DEFAULT; Schema: public; Owner: horaciob
--

ALTER TABLE agenda ALTER COLUMN id SET DEFAULT nextval('agenda_id_seq'::regclass);


--
-- TOC entry 1705 (class 2604 OID 18157)
-- Dependencies: 151 152 152
-- Name: id; Type: DEFAULT; Schema: public; Owner: horaciob
--

ALTER TABLE arquivo ALTER COLUMN id SET DEFAULT nextval('arquivo_id_seq'::regclass);


--
-- TOC entry 1690 (class 2604 OID 17949)
-- Dependencies: 119 118
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE auditoria ALTER COLUMN id SET DEFAULT nextval('auditoria_id_seq'::regclass);


--
-- TOC entry 1691 (class 2604 OID 17950)
-- Dependencies: 121 120
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE codigo_irregularidade ALTER COLUMN id SET DEFAULT nextval('codigo_irregularidade_id_seq'::regclass);


--
-- TOC entry 1692 (class 2604 OID 17951)
-- Dependencies: 123 122
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE departamento ALTER COLUMN id SET DEFAULT nextval('departamento_id_seq'::regclass);


--
-- TOC entry 1693 (class 2604 OID 17952)
-- Dependencies: 125 124
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE empresa ALTER COLUMN id SET DEFAULT nextval('empresa_id_seq'::regclass);


--
-- TOC entry 1694 (class 2604 OID 17953)
-- Dependencies: 127 126
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE entidade ALTER COLUMN id SET DEFAULT nextval('entidade_id_seq'::regclass);


--
-- TOC entry 1695 (class 2604 OID 17954)
-- Dependencies: 129 128
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE imagem ALTER COLUMN id SET DEFAULT nextval('imagem_id_seq'::regclass);


--
-- TOC entry 1696 (class 2604 OID 17955)
-- Dependencies: 131 130
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE irregularidades ALTER COLUMN id SET DEFAULT nextval('irregularidades_id_seq'::regclass);


--
-- TOC entry 1697 (class 2604 OID 17956)
-- Dependencies: 133 132
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE legislacao ALTER COLUMN id SET DEFAULT nextval('legislacao_id_seq'::regclass);


--
-- TOC entry 1698 (class 2604 OID 17957)
-- Dependencies: 135 134
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE normas_procedimentos ALTER COLUMN id SET DEFAULT nextval('normas_procedimentos_id_seq'::regclass);


--
-- TOC entry 1703 (class 2604 OID 18019)
-- Dependencies: 145 144
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE orgao ALTER COLUMN id SET DEFAULT nextval('orgao_id_seq'::regclass);


--
-- TOC entry 1699 (class 2604 OID 17958)
-- Dependencies: 137 136
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tipo_legislacao ALTER COLUMN id SET DEFAULT nextval('tipo_legislacao_id_seq'::regclass);


--
-- TOC entry 1700 (class 2604 OID 17959)
-- Dependencies: 139 138
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tipo_sistema ALTER COLUMN id SET DEFAULT nextval('tipo_sistema_id_seq'::regclass);


--
-- TOC entry 1704 (class 2604 OID 18032)
-- Dependencies: 146 147 147
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE unidade ALTER COLUMN id SET DEFAULT nextval('unidade_id_seq'::regclass);


--
-- TOC entry 1701 (class 2604 OID 17960)
-- Dependencies: 141 140
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE unidade_orcamentaria ALTER COLUMN id SET DEFAULT nextval('unidade_orcamentaria_id_seq'::regclass);


--
-- TOC entry 1702 (class 2604 OID 17961)
-- Dependencies: 143 142
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq'::regclass);


--
-- TOC entry 1775 (class 0 OID 34606)
-- Dependencies: 154
-- Data for Name: Agenda; Type: TABLE DATA; Schema: public; Owner: horaciob
--

COPY "Agenda" (id, descricao, data_inicio, data_fim, dia_todo, tipo_agenda, lista_emails, tipo_notificacao) FROM stdin;
\.


--
-- TOC entry 1776 (class 0 OID 34616)
-- Dependencies: 156
-- Data for Name: agenda; Type: TABLE DATA; Schema: public; Owner: horaciob
--

COPY agenda (id, data_fim, data_inicio, descricao, dia_todo, lista_emails, tipo_agenda, tipo_notificacao) FROM stdin;
2	2014-11-01 01:00:00	2014-11-01 01:00:00	teste 3	f	\N	\N	\N
3	2014-11-01 01:00:00	2014-11-01 01:00:00	teste 31	f	\N	\N	\N
1	2014-11-01 01:00:00	2014-11-01 01:00:00	teste 2	f	\N	\N	\N
4	2014-11-01 01:00:00	2014-11-01 01:00:00	teste 1	f	\N	\N	\N
6	2014-11-08 01:00:00	2014-11-08 01:00:00	tomar café	f	\N	\N	\N
7	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
8	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
9	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
10	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
11	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
12	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
13	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
14	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
15	2014-11-01 01:00:00	2014-11-01 01:00:00	teste	f	\N	\N	\N
5	2014-11-01 01:00:00	2014-11-01 01:00:00	teste 513	f	\N	\N	\N
16	2014-10-29 01:00:00	2014-10-29 01:00:00	teste	f	\N	\N	\N
\.


--
-- TOC entry 1774 (class 0 OID 18155)
-- Dependencies: 152
-- Data for Name: arquivo; Type: TABLE DATA; Schema: public; Owner: horaciob
--

COPY arquivo (id, descricao, tipo_arquivo, tabela, status, id_referencia, caminho_arquivo, conteudo) FROM stdin;
2	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	1	\N	\N
3	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	1	\N	\N
4	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	8	\N	\N
5	teste 1.pdf	application/pdf	auditoria	\N	8	\N	\N
6	teste 1.pdf	application/pdf	auditoria	\N	8	\N	\N
7	teste 1.pdf	application/pdf	auditoria	\N	8	\N	\N
8	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	8	\N	\N
9	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	8	C:\\ProjetosJsf2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\jgestao\\arquivos\\auditoria\\primefaces_users_guide_4_0_edtn2.pdf	\N
10	teste 1.pdf	application/pdf	auditoria	\N	8	C:\\ProjetosJsf2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\jgestao\\arquivos\\auditoria\\teste 1.pdf	\N
11	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	8	C:\\ProjetosJsf2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\jgestao\\arquivos\\auditoria\\primefaces_users_guide_4_0_edtn2.pdf	\N
12	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	8	C:\\ProjetosJsf2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\jgestao\\arquivos\\auditoria\\primefaces_users_guide_4_0_edtn2.pdf	\N
13	teste 1.pdf	application/pdf	auditoria	\N	8	C:\\ProjetosJsf2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\jgestao\\arquivos\\auditoria\\id_8_teste 1.pdf	\N
14	teste 1.pdf	application/pdf	auditoria	\N	7	C:\\home\\horaciob\\auditoriaid_7_teste 1.pdf	\N
15	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	7	C:\\home\\horaciob\\auditoria/id_7_primefaces_users_guide_4_0_edtn2.pdf	\N
16	teste 1.pdf	application/pdf	auditoria	\N	7	C:\\home\\horaciob\\auditoria/id_7_teste 1.pdf	\N
17	primefaces_users_guide_4_0_edtn2.pdf	application/pdf	auditoria	\N	7	C:\\home\\horaciob\\auditoria/id_7_primefaces_users_guide_4_0_edtn2.pdf	\N
\.


--
-- TOC entry 1757 (class 0 OID 17864)
-- Dependencies: 118
-- Data for Name: auditoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY auditoria (id, periodo_inicial, periodo_final, tipo_documento, numero_documento, numero_auditoria, data_documento, id_irregularidade, observacao, id_legislacao, status) FROM stdin;
10	2014-06-02	2014-06-19	PL	11111	22222	2014-06-10	3	teste tesete teste	2	\N
9	2014-05-31	2014-06-18	PCD	23344	134566	2014-06-03	3	teste teste teste	2	\N
7	2014-05-01	2014-05-25	CV	123345	00001	2014-05-25	3	teste assdsddsdsdsdsdadsdsdsdsd	2	\N
11	0014-07-01	0014-07-01	NE	111111	11111	2014-07-01	3	teste teste teste teste	2	\N
8	2014-01-29	2014-05-27	NSE	141063	111111	2014-05-29	8	teste 20140622	2	\N
\.


--
-- TOC entry 1758 (class 0 OID 17871)
-- Dependencies: 120
-- Data for Name: codigo_irregularidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY codigo_irregularidade (id, codigo, descricao, status) FROM stdin;
2	02	Despesas sem comprovante legal	\N
3	03	Comprovantes rasurados	\N
4	04	Documentos faltando assinatura	\N
5	05	Despesas classificadas incorretamente	\N
6	06	Hist�rico incompleto	\N
7	07	Falta indica��o de processo de compra	\N
8	08	Nota fiscal ou comprovante vencido	\N
9	09	Despesas c/ viagem s/ autoriza��o legal	\N
10	10	Falta liquida��o na nota fiscal	\N
11	11	Quita��o anterior ao documento fiscal	\N
12	12	Nome fornecedor diverge entre NE e NF	\N
13	13	Valor do comprovante diverge da NE	\N
14	14	Verificar a incid�ncia de descontos	\N
15	15	Natureza opera��o diverge do tipo de NF	\N
16	16	Despesa com publicidade s/comprovante	\N
19	19	CNPJ do empenho diverge do CNPJ	\N
20	20	Despesas sem comprovante de quita��o	\N
21	21	Tipo de empenho incorreto	\N
22	22	Nota de empenho rasurada	\N
23	23	Empenho com data irregular	\N
24	24	Despesa irregular	\N
18	18	Campo Data sem preenchimento	\N
17	(17	Despesa não afeta ao município	\N
1	01	Despesas sem prévio-empenho	\N
\.


--
-- TOC entry 1759 (class 0 OID 17878)
-- Dependencies: 122
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY departamento (id, descricao, id_unidade_orcamentaria, status) FROM stdin;
3	teste de departamento	6	\N
1	Casa amarela	5	\N
2	teste teste 	5	\N
4	Posto de cadastramento II	6	\N
\.


--
-- TOC entry 1760 (class 0 OID 17885)
-- Dependencies: 124
-- Data for Name: empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY empresa (id, razao_social, cnpj, tipo_sistema, contato, telefone, celular, status) FROM stdin;
\.


--
-- TOC entry 1772 (class 0 OID 18133)
-- Dependencies: 148
-- Data for Name: empresa_usuaria; Type: TABLE DATA; Schema: public; Owner: horaciob
--

COPY empresa_usuaria (id, celular, cnpj, contato, razao_social, telefone, tiposistema, status) FROM stdin;
\.


--
-- TOC entry 1761 (class 0 OID 17892)
-- Dependencies: 126
-- Data for Name: entidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY entidade (id, tipo, nome, endereco, cidade, estado, email, site, brasao, status) FROM stdin;
1	1	Prefeitura Municipal de Contagem 	Rua principal, 122	Contagem	MG			\N	\N
\.


--
-- TOC entry 1762 (class 0 OID 17899)
-- Dependencies: 128
-- Data for Name: imagem; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY imagem (id, tipo_imagem, arquivo, id_referencia, descricao, tabela, status) FROM stdin;
1	brasao	\\377\\330\\377\\340\\000\\020JFIF\\000\\001\\001\\001\\000`\\000`\\000\\000\\377\\333\\000C\\000\\002\\001\\001\\002\\001\\001\\002\\002\\002\\002\\002\\002\\002\\002\\003\\005\\003\\003\\003\\003\\003\\006\\004\\004\\003\\005\\007\\006\\007\\007\\007\\006\\007\\007\\010\\011\\013\\011\\010\\010\\012\\010\\007\\007\\012\\015\\012\\012\\013\\014\\014\\014\\014\\007\\011\\016\\017\\015\\014\\016\\013\\014\\014\\014\\377\\333\\000C\\001\\002\\002\\002\\003\\003\\003\\006\\003\\003\\006\\014\\010\\007\\010\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\014\\377\\300\\000\\021\\010\\000A\\0001\\003\\001"\\000\\002\\021\\001\\003\\021\\001\\377\\304\\000\\037\\000\\000\\001\\005\\001\\001\\001\\001\\001\\001\\000\\000\\000\\000\\000\\000\\000\\000\\001\\002\\003\\004\\005\\006\\007\\010\\011\\012\\013\\377\\304\\000\\265\\020\\000\\002\\001\\003\\003\\002\\004\\003\\005\\005\\004\\004\\000\\000\\001}\\001\\002\\003\\000\\004\\021\\005\\022!1A\\006\\023Qa\\007"q\\0242\\201\\221\\241\\010#B\\261\\301\\025R\\321\\360$3br\\202\\011\\012\\026\\027\\030\\031\\032%&'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz\\203\\204\\205\\206\\207\\210\\211\\212\\222\\223\\224\\225\\226\\227\\230\\231\\232\\242\\243\\244\\245\\246\\247\\250\\251\\252\\262\\263\\264\\265\\266\\267\\270\\271\\272\\302\\303\\304\\305\\306\\307\\310\\311\\312\\322\\323\\324\\325\\326\\327\\330\\331\\332\\341\\342\\343\\344\\345\\346\\347\\350\\351\\352\\361\\362\\363\\364\\365\\366\\367\\370\\371\\372\\377\\304\\000\\037\\001\\000\\003\\001\\001\\001\\001\\001\\001\\001\\001\\001\\000\\000\\000\\000\\000\\000\\001\\002\\003\\004\\005\\006\\007\\010\\011\\012\\013\\377\\304\\000\\265\\021\\000\\002\\001\\002\\004\\004\\003\\004\\007\\005\\004\\004\\000\\001\\002w\\000\\001\\002\\003\\021\\004\\005!1\\006\\022AQ\\007aq\\023"2\\201\\010\\024B\\221\\241\\261\\301\\011#3R\\360\\025br\\321\\012\\026$4\\341%\\361\\027\\030\\031\\032&'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz\\202\\203\\204\\205\\206\\207\\210\\211\\212\\222\\223\\224\\225\\226\\227\\230\\231\\232\\242\\243\\244\\245\\246\\247\\250\\251\\252\\262\\263\\264\\265\\266\\267\\270\\271\\272\\302\\303\\304\\305\\306\\307\\310\\311\\312\\322\\323\\324\\325\\326\\327\\330\\331\\332\\342\\343\\344\\345\\346\\347\\350\\351\\352\\362\\363\\364\\365\\366\\367\\370\\371\\372\\377\\332\\000\\014\\003\\001\\000\\002\\021\\003\\021\\000?\\000\\375\\3707*.\\2048\\223yB\\371\\330\\333p\\010\\037{\\030\\317=3\\232\\371\\307\\366\\327\\377\\000\\202\\250|,\\375\\205\\265o\\354_\\025]\\3527~(\\227O\\032\\234ZM\\245\\271\\015\\3449\\221!\\225\\346\\223lI\\023\\317\\031\\207v\\342U\\211f\\001\\022GO\\244\\253\\362\\223\\376\\012\\351\\342\\255c\\343\\217\\304\\233\\277\\007\\370\\367D\\321\\264M\\023\\301\\027\\237\\332\\032|\\260\\335\\315\\025\\316\\243\\2472K3\\306\\367\\033\\227b\\335\\245\\234r\\307u\\032!\\266\\270\\260\\236\\006\\336\\201\\356\\323\\347x\\237=\\247\\224\\340\\236*\\243\\353e\\356\\267w\\333M\\257\\262m\\245{&\\365;0\\024!V\\274aR\\374\\267W\\265\\257k\\353k\\264\\233\\362\\270\\337\\370(\\327\\355\\005\\251\\376\\324\\177\\262\\367\\303?\\215\\036\\032\\360\\347\\304\\015\\026]k\\307w\\236\\005\\267\\320\\254uk\\201.\\261\\246\\242\\336\\315\\023O\\034H\\032\\322\\341\\257\\364\\333e!>m\\301U%f\\373-\\304\\\\\\037\\374\\023G]\\270\\370_\\361\\007\\342'\\2154\\333\\017\\022\\313\\244|\\037\\360E\\316\\271\\341\\355*\\177\\021\\317g\\247\\353\\3014\\035"y\\243\\270\\272>d3\\250{\\311\\302\\035\\233`\\037g\\312\\201\\034A<s\\306\\276\\0137\\237\\016n\\2745\\341\\233-sV\\261\\263\\260\\276\\264\\322m\\364\\230\\344\\274\\227K\\235,\\036\\301\\026\\331\\355\\026R\\326\\223[]\\264G\\315\\214o\\212\\007\\213\\314\\215\\242\\0273\\346|\\014\\360\\037\\210<%\\341s\\246\\370\\237G\\361\\277\\205\\226yuX-n\\257\\254/\\255\\037O\\212k{5\\021B\\263\\010 Hd\\222K\\311\\2266\\223l\\263\\254\\342m\\211p\\035?\\025\\251\\307\\264\\252fT\\363YsZ1\\345p\\275\\233\\227+\\274\\324o\\313\\244\\226\\232j\\236\\373\\037YO\\207\\251\\274\\236\\2463\\333EN5#\\005\\0159\\234d\\244\\334\\267\\275\\243d\\235\\223W\\226\\352\\332\\376\\253\\376\\307\\337\\360Y\\357\\204\\237\\266\\017\\216-<#a\\037\\211|9\\343]Bib\\266\\321u-6I&\\224G\\34733<\\002D\\207jB\\305\\374\\343\\030V\\014\\001m\\271\\257\\256+\\361C\\366\\003\\361>\\253\\373:|b\\271\\324~\\016\\350Z\\006\\253\\255\\370\\302\\352\\035:\\035\\016\\362\\352MF=>+\\231\\241w\\264[\\250\\336%Y<\\210#\\221\\202\\254\\206\\336+L\\272nK\\245\\203\\366\\271s\\216k\\366\\036\\020\\342%\\234`\\335\\177\\265\\027f\\271Z\\263\\336\\327\\331\\2734\\375\\326\\325\\232>[1\\303\\322\\243Y\\306\\215\\334z^\\327\\371\\245{\\013E\\024W\\325\\234\\0071\\252\\374Y\\3234\\245\\234\\225\\270\\231\\255\\367\\357TP\\244\\204$\\022\\013\\225\\007\\220@\\301\\311\\307\\002\\2761\\377\\000\\202\\200|g\\360t\\177\\264G\\207\\204\\336\\036\\360%\\366\\276\\272F\\234\\3267\\232\\224\\3276z\\323\\254\\332\\205\\304O\\032\\030&\\212S\\025\\277\\226f\\303nU2;n\\2141z\\365\\177\\026~\\320?\\017\\376\\031\\370\\372/\\016x\\363\\306\\336\\025\\360v\\257\\177\\017\\332\\355-u\\313\\364\\262\\226\\342\\006wO\\343*\\230\\014\\254\\006x\\3118\\312\\340\\017\\315\\237\\370/%\\252h?\\265O\\204\\322\\033\\355B8\\317\\204m\\344\\266\\220ZI/\\232\\005\\375\\351Y\\011U.;`\\253!%w\\003\\214c\\\\\\3129}\\034<\\2366\\234kCE(K\\341i\\367\\374\\355\\327\\256\\207\\306fy\\236o<<\\277\\262)J\\255T\\343h\\323\\213\\234\\367\\\\\\336\\354c)|7o\\335\\333]7>\\225\\360O\\355\\027\\342\\377\\000\\035x\\027E\\326\\364\\333\\373\\277\\017Zkz}\\276\\241\\035\\224\\360<\\263\\333\\211cY\\002H/<\\331\\025\\200`\\010'\\250\\355X\\237\\023?l_\\021|"\\026K\\254\\353\\227\\372\\241\\324\\245H\\322\\332\\033\\010\\342P\\245\\325\\014\\222M\\012\\304\\321F\\013\\214\\266\\360r@\\000\\236\\237\\002j\\237\\360R?\\212rxN\\035\\006\\005\\262k\\322\\214%\\361\\027\\330'[\\251\\027#\\001\\263\\031A&\\011\\033\\226\\020\\304\\014\\206\\014\\013\\266^\\217\\340_\\213~:\\322\\364\\233\\335G\\376\\026\\227\\210t\\331vj\\026d\\332jSZyr\\205}\\361\\356V,\\256\\244\\035\\304\\374\\301\\271\\316M|\\2167\\201|.\\304A\\313*\\341\\372\\025*\\331>e\\207\\203\\263\\323t\\257\\256\\372\\355\\331\\263\\344\\363~#\\343|\\271\\323\\376\\320x\\212\\021\\250\\355\\027:-uW^\\364c\\252O_\\221\\372\\223\\373"|e\\320\\274}\\373H\\370#\\304o\\340\\257\\010\\334\\335\\337^]\\351\\213\\342K\\250n\\357o\\364\\2604\\273\\311\\330\\332]\\317s:.\\341\\027\\224\\376I\\000\\211\\035\\011\\014\\031\\007\\335\\226?\\024\\364\\273\\375w\\3541\\310yM\\313)\\030Fl\\220W\\236Gl\\023\\301\\311\\307J\\3741\\377\\000\\202d|\\025\\361'\\204\\277\\340\\240_\\015\\265\\015c\\303>0\\266\\200I\\254'\\235\\250\\332\\336,d\\266\\203\\251\\374\\271\\230m\\313\\000@\\356}\\372\\037\\324\\317\\213\\337\\264\\007\\201\\377\\000g\\237\\014K\\251\\370\\363\\\\\\260\\360\\206\\226\\220K=\\335\\355\\365\\302F\\256\\000f\\371\\001%\\344\\223j\\266\\025T\\271\\332\\304d\\216~\\307.\\300\\340\\241\\206T\\360\\330o\\252\\302\\012\\312\\011r\\245my\\224ZV^KC\\324\\341~+\\306\\342\\360\\037Z\\307I\\271s;\\271\\307\\225\\273[\\242\\322\\332\\357\\353\\330\\372\\232\\212\\374\\363\\377\\000\\207\\302\\336\\377\\000\\321\\257\\376\\325\\337\\370n\\345\\377\\000\\343\\364Tr\\303\\371\\2773\\357\\376\\266\\377\\000\\225\\237<\\177\\301\\303\\237\\260\\327\\304_\\033\\374w\\260\\370\\257\\244\\334\\351\\272\\237\\207g\\261\\323\\364;\\0373PKi\\364\\033\\250\\215\\323\\260q3G\\022Z\\260gw\\230\\314\\244y\\256\\010]\\250\\355\\362\\247\\306K\\311\\276)\\370'\\340~\\215\\242\\353\\272\\017\\210\\365\\015\\033\\3023\\3507WV\\222\\177\\242Y=\\276\\257\\252\\310\\260);\\020\\204\\267{|9h\\242dd\\223tq\\020G\\356\\325\\306\\221\\250\\303w\\254_\\313uh\\221\\335_\\264\\177\\277\\005\\025#\\363U$\\\\\\340\\362\\241X\\251\\307$\\014\\374\\2705\\371\\357\\377\\000\\005l\\375\\207\\255\\264M\\012O\\214\\237\\015|%\\246iZ\\227\\206L\\247\\306\\026\\326zb\\315\\003\\333\\314du\\325e\\200\\217)\\345\\202V\\221\\245\\223g\\314\\263\\211e\\335\\025\\257\\036'\\020\\344\\211\\341gV>\\364o\\027%\\256\\312Qr\\265\\265\\332\\347\\265\\341N5\\345\\234]\\375\\241\\203~\\316\\265ju\\241\\007&\\255\\355eFq\\243\\254\\275\\324\\235NT\\371\\237*\\275\\356\\225\\317\\203>!~\\314z\\377\\000\\302\\335\\034\\337\\\\\\353zD\\223\\226O\\364K\\275B\\321\\036\\340\\035.\\333Q%\\025&2\\002\\242\\356\\336\\022"\\216O\\365\\261N\\021\\255\\245K\\226\\367\\337\\203\\267\\376*\\360G\\366G\\214\\265\\011|a\\343/\\013\\350~\\022\\320\\254\\264\\315\\023O\\232\\336\\306\\307H\\231\\264\\2137`\\226\\342\\343u\\355\\323\\213\\231\\017\\231:\\200C\\244P\\356\\230C\\033\\374\\331\\342\\177\\212\\272\\337\\215a\\264\\212\\375<0\\311l\\320\\276`\\360\\345\\245\\274\\222l\\322\\342\\323\\216]\\0240\\336"\\027l\\001\\000^1\\225B\\256#\\037]|%\\370\\000\\337\\024>\\035\\350k\\253k\\036,\\262\\360\\345\\327\\207<1{\\035\\235\\225\\342[\\332^O\\026\\225n\\011#af\\331$6\\322n<\\357\\215@8R\\265\\277\\207q\\241^\\276"\\236J\\334f\\324-+6\\224\\227<\\227:{\\303KIi{\\3315.V\\276\\213\\307\\271q\\215\\014\\247\\003.?\\214o\\355*\\250\\244\\351\\266\\340\\343EK\\225\\323n\\322m\\365}.\\325\\257\\177J\\375\\232\\240\\361?\\355\\005\\361;J\\360\\266\\253\\252\\370\\207\\300^&\\3275k\\353\\315*\\366\\316H\\026o\\017\\331\\334\\350z\\257\\366t\\266\\362[JL\\245Z\\331\\336E\\225\\225\\336O=J\\210Z1^\\025\\361\\353\\340w\\307_\\330C\\366\\366\\360\\026\\255\\361%\\177\\341z\\351\\232\\236\\273g\\244\\351z\\267\\211\\255\\306\\263i\\253\\333Mp\\025lQ\\356\\326O\\261\\3356K\\355R^&b\\350f\\214I\\237\\262\\277b?\\331\\330\\330|A\\326|Ww\\177qq\\243[\\\\\\033\\013\\033\\351b\\371\\344\\272\\373)\\265[(\\213;\\253\\244Q\\311\\251<\\305\\0224\\373F\\244\\025\\002\\230\\344\\215>\\244\\361V\\216\\267\\367\\011q\\316\\247\\366)\\022\\342\\002\\366\\353/\\2214{\\231$A\\202VPH\\301\\354B\\221\\316\\354\\375nw\\206\\253\\217\\251NX\\207\\311R1JJ\\374\\336\\362\\325\\253\\253F[\\332\\351/E\\261\\374\\377\\000\\201\\313\\351,,]6\\327\\275\\317\\026\\257\\037wM\\034\\033\\331\\333K\\335\\331\\255Zn\\376\\361Es_m\\327\\177\\272\\177\\357\\320\\242\\274\\177b\\373\\257\\274\\375#\\353+\\263\\373\\217\\226\\377\\000lmc\\307\\237\\011<K\\343]\\177W\\326\\236\\035\\017\\304:R\\350\\236\\037M&\\337\\310\\215\\344\\377\\000IdQ-\\304\\316\\226:\\236fU\\027eR\\330\\255\\272<\\301\\302\\254V\\375_\\354\\373\\373]\\315\\3617\\366\\026\\327\\274ka\\244\\350\\272\\037\\304\\337\\016\\370\\177P\\271\\326\\274:\\025\\247\\026Z\\245\\252\\334 cn\\035n>\\311<\\260\\031`\\022\\030\\345\\222\\011c'c\\222\\027\\362\\373\\366\\342\\377\\000\\202x~\\327\\237\\265\\007\\355{\\361\\023\\307\\327\\036\\011\\361\\375\\346\\227\\247\\370\\233V\\266\\360\\305\\336\\223\\257\\351v\\367\\226\\332\\\\\\023\\262YIj\\3277\\251$H\\360\\010\\344H\\355\\343_\\336\\006f\\375\\353\\310_\\332\\374\\031\\373\\005\\374t\\370+\\340\\355\\033\\304\\2768\\323u\\211\\265\\313q\\037\\211\\027S\\360\\365\\214Z\\275\\307\\207\\210\\225\\344}\\036\\356;\\002\\272\\213\\270\\335\\0217\\032dw\\206\\343`G\\012m \\271\\270\\374\\363\\021\\016 \\302b\\361\\025pM\\327\\243R\\317\\222R\\214eNV\\345\\375\\323qQqi)r\\315\\277z\\355K\\336h\\307.\\314!\\212\\257:5p\\362\\246\\351\\3556\\275\\331+\\371\\331\\335\\377\\000v\\352\\333\\264\\354\\214\\017\\213\\337\\005\\177fO\\214\\336$\\324\\365h|;\\342\\357\\004\\226\\226C\\036\\241\\360\\336\\376\\327P\\3205g\\022,{\\343\\266\\270]\\261\\227\\334\\035b\\2638\\330w\\023\\226\\033\\375\\033\\341\\367\\213~\\022x\\003\\303\\232o\\207\\240\\037\\024<m\\377\\000\\010\\274\\026\\332\\022Z\\264\\372~\\227\\246\\310"\\266o&I\\356m$\\222\\340\\206\\216\\332LI\\003\\030\\244\\220,!K\\312\\221\\264:\\267\\354g\\361c\\307>\\033\\217\\305\\276\\022\\320\\254\\274e\\243x\\302\\302\\327[\\264\\324-\\2574\\353\\371\\257\\345\\224\\244\\320j1\\235^8Lr4L%\\2369a\\304\\322\\274\\212\\340\\305\\266%\\354\\376#~\\302\\037\\021\\365\\257\\210\\2763\\217N\\360E\\236\\217\\341k\\335V\\351m.`]\\016\\330\\246\\237\\366\\202\\321\\255\\277\\220\\320\\315k\\033B\\270%dY\\016\\363#\\023+>?=\\301q\\007\\035\\345\\270j\\257\\007E\\252\\262q\\213\\227\\261\\264\\345\\0337\\317/f\\375\\235\\325\\235\\322\\274o(\\373\\313T\\276\\3279\\305\\254\\342\\225\\0146mU\\326\\247F\\356\\232\\234\\271\\224\\033\\262j<\\327ih\\276Kc\\352\\217\\202\\177\\037\\2745?\\301-Z\\357[\\177\\005\\350\\336\\023\\322\\265'\\320\\264\\230\\364R\\016\\237s\\022ZD\\346\\326\\327o\\374|I\\034\\206\\342\\015\\260\\242\\226kv\\0024`\\312>p\\375\\227\\376"\\374I\\375\\246\\274S\\340\\277\\030\\351\\301\\364Mn+\\373\\353\\313\\337\\007\\026q\\243\\350zm\\336\\365\\205\\265)ab\\227w\\026\\360\\213q\\024k!\\335r/\\260\\027\\017\\366/\\215\\277\\340\\240_\\024W\\366b\\320\\264M7J\\361v\\203\\361#\\304\\027\\023M\\241\\352\\237\\331A\\274K\\245h\\366\\316\\251,Zd\\3279\\214-\\313\\246\\303\\006\\232ch\\315\\255\\265\\323\\024O8\\027\\371\\237@\\361'\\307/\\370(\\026\\255k\\360\\226\\306\\367_\\327l|D\\262\\310\\276\\032\\260hm\\355\\256\\026eX%\\274\\324\\026\\336\\000\\222ZA\\2760n\\356\\367\\264x\\201"\\224\\276\\310\\344\\372\\354\\015^&\\305,-\\014mYP\\215>G6\\271=\\255yE}\\270\\250\\312\\024\\3417\\357N0\\367\\227\\302\\244\\223g\\300g<E\\226`qK\\010\\251\\272\\225\\245\\360\\244\\264W\\332\\315\\276g\\327T\\232I6\\354\\177L\\376b\\377\\000y\\177:+\\317\\177\\341\\221>\\023\\377\\000\\3210\\370w\\377\\000\\204\\345\\237\\377\\000\\033\\242\\277Q=\\203\\276\\037x\\321?\\334\\037\\207\\363\\242\\212kaDH\\272\\037\\367\\233\\377\\000B5\\340_\\360V\\017\\371E\\257\\355)\\377\\000d\\253\\305?\\372h\\272\\242\\212\\306?\\020\\246x<\\377\\000\\362\\201\\215k\\376\\3017\\337\\372t\\222\\274\\203\\376\\015g\\377\\000\\2225\\361\\227\\376\\306;O\\375\\020\\364QV\\276/\\221\\243\\331|\\377\\000\\366\\323\\365j\\212(\\252$\\377\\331	1	Brasão oficial	Entidade	\N
\.


--
-- TOC entry 1763 (class 0 OID 17906)
-- Dependencies: 130
-- Data for Name: irregularidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY irregularidades (id, tipo_documento, numero, descricao, codigo, status) FROM stdin;
11	PCD	45	teste	2	\N
3	NE	12345	teste teste	2	\N
8	NSE	00006	teste teste 	2	\N
\.


--
-- TOC entry 1764 (class 0 OID 17913)
-- Dependencies: 132
-- Data for Name: legislacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY legislacao (id, tipo_legislacao, numero, data, referencia, texto, status_legislacao, status, legislacao_vinculada) FROM stdin;
2	32	3456	1963-12-04	teste teste teste teste teste teste teste teste teste teste 	<table frame="VOID" cellspacing="0" cols="1" rules="NONE" border="0">\r\n\t<colgroup><col width="3219"></colgroup>\r\n\t<tbody>\r\n\t\t<tr>\r\n\t\t\t<td width="3219" height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="25" align="JUSTIFY"><font face="Calibri" size="4">Contrato de Prestação de Serviços </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="JUSTIFY"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="36" align="JUSTIFY">Que entre si fazem GDAX Empreendimentos em telecomunicações LTDA, inscrita no CNPJ sob o n° 10.686.633/0001-59, com sede nesta cidade, na Rua: Dos Goitacazes, 216, Centro – Belo Horizonte, doravante denominada, abreviadamente CONTRATANTE, e  BsWeb  Consultoria Comercial e Desenvolvimento de Sistemas Ltda , inscrita no CNPJ sob o nº 11.097.464/0001-84, com sede na cidade de Contagem no estado de  Minas Gerais, na Rua Via Lactea 195, no  Bairro Jardim Riacho das Pedras, doravante denominada, abreviadamente, CONTRATADA.</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA PRIMEIRA – DO OBJETO</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">O presente contrato tem por objeto regular as condições mediante as quais a CONTRATADA prestará à CONTRATANTE os serviços discriminados na cláusula segunda a seguir, com fornecimento de mão-de-obra.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA SEGUNDA – DA PRESTAÇÃO DOS SERVIÇOS</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">A prestação de serviços da CONTRATADA compreende o desenvolvimento  de Aplicativo responsável por comunicação através do protocolo SIP desenvolvido em Java, cujos fontes  serão de propriedade da CONTRATANTE e módulos correlatos, doravante denominado, abreviadamente, APLICATIVO JAVA,  com fornecimento de mão-de-obra.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">Escopo e Requisitos do APLICATIVO JAVA: </td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="21" align="LEFT">Aplicativo a ser disponibilizado no portal GDAX (), com layout a ser desenvolvimento pela  área de MKT da mesma, com restrição de acesso por tipo de usuário (gestão de acessos feita pelo portal) que será capaz de:</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">• Assim que “acionado” o aplicativo deverá logar, com o mesmo usuário que fez login no portal, na central VOIP da GDAX (PABX com URL LOCAL para os acessos de dentro da GDAX e com URL EXTERNA – IP FIXO, para os acessos de fora da GDAX).</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">• É importante garantir, por motivos de performance, que TODOS logins feitos de DENTRO da rede interna da GDAX, usem SOMENTE a URL local para acessar o servidor VOIP GDAX. NUNCA pode usar ao acesso externo por questões de limite de link de dados.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">• Ao logar, deverá ficar em modulo “stand by” com o ramal do usuário “ativo” e disponível para receber ligações. </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">• Uma vez “ativo” deverá ficar “oculto” na tela, disponível somente para visualização mediante escolha do usuário.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">• Se uma chamada “tocar” no ramal, deverá aparecer sinalização na tela para que seja atendida a chamada.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">• Se o usuário acionar a exibição do aplicativo, deverá aparecer o “modulo” com as opções que o usuário pode usar ou não. Estas opções deverão ser definidas em um menu GESTAO MODULO GDAX CALL a ser instalada dentro da área de administração do portal GDAX.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">• O usuário, com base nas permissões, poderá:</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"> Discar para os números do webvendas ou para um numero desejado</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"> Gravar a ligação</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"> Transferir a chamada</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"> Rediscar</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"> Puxar uma ligação do mesmo grupo de ramais</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"> Acionar Botão MUTE (para ficar com a ligação muda, sem desligar)</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"> Ter Controle de VOLUME da ligação (que na verdade é o controle de volume da caixa de som)</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">Cronograma da parte Java da solução:</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Análise / Especificação / Definição de protótipo visual: 30 hs</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Desenvolvimento: 150 hs </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Implantação / Testes: 30 hs</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Manutenção / Suporte: 30 hs</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">TOTAL: 240 HS </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="17" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">PARÁGRAFO PRIMEIRO – A CONTRATADA, para a execução dos serviços ora contratados, utilizará recursos de mão-de-obra próprios, sendo de sua exclusiva responsabilidade todas as despesas com o seu pessoal, inclusive todos os encargos trabalhistas, previdenciários e securitários.</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">PARÁGRAFO SEGUNDO – A prestação dos serviços ora contratados será feita no horário de 18:00hs às 22:00hs, de segunda à sábado, na sede da CONTRATADA, sendo que sempre que necessário, haverá um deslocamento para a sede da CONTRATANTE para que se efetue testes de compatibilidade com equipamentos e sistemas.</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">PARÁGRAFO TERCEIRO – A critério da CONTRATADA, os serviços poderão ser executados além do horário estabelecido no parágrafo segundo supra, sem que isso acarrete para a CONTRATANTE obrigação de pagamento de qualquer remuneração além da estipulada na cláusula oitava deste contrato. </td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">CLÁUSULA TERCEIRA – DAS OBRIGAÇÕES DA CONTRATANTE</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Constituem obrigações da CONTRATANTE, dentre outras previstas neste contrato:</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Permitir o acesso dos equipamentos e prepostos da CONTRATADA, devidamente identificados, ao local onde serão realizados e testados os serviços objeto deste contrato, prestando-lhes todos os esclarecimentos necessários; Garantir o desenvolvimento das partes do aplicativo que cabem a sua equipe, dentro do cronograma, para que a entrega do aplicativo não atrase, o que poderia prejudicar o cumprimento dos prazos por parte da CONTRATADA.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Pagar pontualmente a remuneração da CONTRATADA;</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri"><br></font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA QUARTA – DAS OBRIGAÇÕES DA CONTRATADA</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Constituem obrigações da CONTRATADA, dentre outras previstas neste contrato:</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">cumprir rigorosamente os prazos previstos para a execução dos serviços, implementando as funções estabelecidas pela CONTRATANTE;</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Atender todas as despesas com o pessoal de sua contratação utilizado na prestação dos serviços ora contratados, inclusive os encargos trabalhistas, previdenciários e securitários;</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Prestar à CONTRATANTE quaisquer informações e esclarecimentos que se fizerem necessários para o acompanhamento da evolução dos serviços ora contratados;</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Cumprir,  todas as leis e posturas federais, estaduais e municipais;</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Revisar ou corrigir, de forma pronta e imediata, sem qualquer ônus para a CONTRATANTE, todas as falhas, deficiências, imperfeições ou defeitos apresentados no Aplicativo dentro do período de 3 meses de garantia, contados a partir da entrega do aplicativo;</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA QUINTA – DA CONFIDENCIALIDADE E SIGILO</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">As partes, por seus dirigentes, prepostos ou empregados, comprometem-se, mesmo após o término do presente contrato, a manter completa confidencialidade e sigilo sobre quaisquer dados ou informações obtidas em razão do presente contrato, reconhecendo que não poderão ser divulgados ou fornecidos a terceiros, salvo com expressa autorização, por escrito, da outra parte.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">PARÁGRAFO ÚNICO – As partes serão responsáveis, civil e criminalmente, por quaisquer danos causados uma a outra e/ou terceiros em virtude da quebra da confidencialidade e sigilo a que estão obrigadas.</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA SÉXTA – DA PROPRIEDADE INTELECTUAL</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="21" align="LEFT">Os estudos, projetos, relatórios e demais dados desenvolvidos pela CONTRATADA em razão dos serviços ora contratados, ainda que inacabados, serão de propriedade exclusiva da CONTRATANTE, que poderá registrá-los nos órgãos competentes e utilizá-los ou cedê-los sem qualquer restrição ou custo adicional. Também se enquadra nesta situação todo código fonte aberto, que deverá ser fornecido à CONTRATANTE pela CONTRATADA  mais a documentação sobre o mesmo e parâmetros.</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA SÉTIMA – DA REMUNERAÇÃO DA CONTRATADA</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="21" align="LEFT"><font face="Times New Roman">Pelos serviços ora contratados, a CONTRATANTE pagará à CONTRATADA,  o valor de R$ 15.000,00 (Quinze Mil Reais).     </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">Forma de pagamento:  </td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">30% na assinatura </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">30% na entrega e aceite da GDAX</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">40% após 30 dias da entrega</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT"><font face="Times New Roman" size="3">Pagamento das parcelas será feito mediante entrega de Nota Fiscal.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">PARÁGRAFO PRIMEIRO – O valor estipulado para a remuneração da CONTRATADA inclui todos e quaisquer impostos, taxas e/ou encargos fiscais, sociais, previdenciários e securitários, sendo que se houver alteração na legislação fiscal que importe em alteração dos valores hoje vigentes, as partes poderão negociar a revisão do valor ajustado, para mais ou para menos.</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA NONA  DA COMUNICAÇÃO ENTRE AS PARTES   </font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">A  comunicação entre as partes será feita por carta, entregue contra recibo ou pelo correio com aviso de recepção na sede das mesmas, ou através de e-mail e telefones.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA DÉCIMA  – DA VIGÊNCIA DO CONTRATO E PRAZO PARA ENTREGA DO APLICATIVO</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT"><font face="Times New Roman" size="3">O presente contrato vigerá, a partir desta data, até a entrega do aplicativo, cujo prazo será de 45 (quarenta e cinco dias) corridos para a entrega do APLICATIVO, para testes, a partir da assinatura. Após a entrega, a CONTRATADA terá um prazo de mais 15 (Quinze) dias para realizar correções ou ajustes que se fizerem necessários, sem nenhuma punição legal. </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="21" align="LEFT"><font size="3">A CONTRATANTE terá também direito a 20 horas técnicas de “melhorias” (não é suporte corretivo) a serem usadas nos 90 dias após a entrega, já incluídas no valor deste contrato.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT"><font face="Calibri" size="3">Após a finalização total da entrega, o valor hora para melhorias solicitadas pela CONTRATANTE e prestadas pela CONTRATADA, será de 80 (Oitenta) reais, até 90 (noventa) dias de entrega final do APLICATIVO.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA DÉCIMA PRIMEIRA – DAS MODIFICAÇÕES OU ALTERAÇÕES</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Todas as modificações ou alterações no presente contrato deverão ser feitas por escrito, sendo de nenhum efeito as combinações verbais. </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA DÉCIMA SEGUNDA – DAS PENALIDADES</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">O inadimplemento de quaisquer das cláusulas ou condições do presente contrato, bem como na hipótese de qualquer das partes se tornar insolvente, sem prejuízo das perdas e danos e demais cominações previstas em lei e neste instrumento, dará direito à parte prejudicada de considerar o presente rescindido de pleno direito, independentemente de qualquer notificação, interpelação ou aviso, judicial ou extrajudicial.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="20" align="LEFT">Em caso de não cumprimento do prazo limite de 60 dias citado no contrato para a entrega do APLICATIVO JAVA, a CONTRATADA deverá pagar multa de 100,00 reais por dia de atraso na entrega e a partir do 30º dia de atraso, devolução do valor pago até então, corrigido pelo IGPM, ou seja,  a  devolução do valor integral pago corrigido.</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Esta clausula se anula caso a CLÁUSULA TERCEIRA não seja cumprida pela CONTRATANTE.</font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA DÉCIMA TERCEIRA – DO CASO FORTUITO OU FORÇA MAIOR</font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Nenhuma das partes será responsável perante a outra por qualquer falha ou atraso no cumprimento das obrigações constantes do presente contrato, causados por casos fortuitos ou força maior. </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><b><font face="Calibri">CLÁUSULA DÉCIMA QUARTA – DO FORO </font></b></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Fica eleito o foro central da Comarca da Capital do Estado de Minas Gerais, com renúncia expressa de qualquer outro, por mais privilegiado que seja, para dirimir quaisquer dúvidas decorrentes do presente contrato, sendo o ajuste aqui feito obrigatório para as partes, seus herdeiros ou sucessores. </font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="17" align="LEFT"><font face="Calibri" size="1"><br></font></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td height="19" align="LEFT"><font face="Calibri">Assim, por estarem justas e contratadas, firmam as partes o presente em 02 (duas)  vias de igual teor e forma para um só fim de direito, o que fazem diante das testemunhas também ao final assinadas. <br><br>testehb</font></td>\r\n\t\t</tr>\r\n\t</tbody>\r\n</table>	\N	\N	\N
\.


--
-- TOC entry 1765 (class 0 OID 17920)
-- Dependencies: 134
-- Data for Name: normas_procedimentos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY normas_procedimentos (id, numero, data_elaboracao, referencia, areas_interesse, texto, legislacao, data_publicacao, tipo, ano, id_departamento, status) FROM stdin;
6	23456	2014-06-26	teste	teste	<p class="western" style="text-align: center; margin-bottom: 0cm;"><font color="#333333"> \r\n                                  <font face="Arial, sans-serif"><b>PREFEITURA\r\nMUNICIPAL DE MODELO </b></font></font>\r\n</p>\r\n<p style="margin-top: 0.18cm; margin-bottom: 0.18cm; widows: 2; orphans: 2" align="CENTER" lang="pt-BR">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>MANUAL\r\nDE NORMAS E PROCEDIMENTOS PARA CONTROLE PATRIMONIAL </b></font></font></font>\r\n</p>\r\n<p style="margin-top: 0.18cm; margin-bottom: 0.18cm; widows: 2; orphans: 2" align="CENTER" lang="pt-BR">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>TÍTULO\r\nI </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>CAPÍTULO\r\nI </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES DAS CHEFIAS </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n1º É de inteira responsabilidade da Chefia de cada Unidade a carga\r\npatrimonial que estiver vinculada a essa. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n2º O Chefe de cada Unidade poderá designar expressamente servidores\r\nque responderão pela guarda de bens patrimoniais, sendo que a\r\natribuição conferida a esse não eximirá a chefia de\r\nresponsabilidade, caso venham a ocorrer problemas com relação a\r\nbens de sua carga patrimonial. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n3º É de inteira responsabilidade da chefia de cada unidade\r\npatrimonial o acompanhamento da vigência da garantia de bens\r\nadquiridos ou consertados. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n4º O Chefe da unidade deverá comunicar ao Setor de Patrimônio, de\r\nforma escrita, irregularidades ocorridas com bens de sua\r\nresponsabilidade, tais como as abaixo descritas, descrevendo as\r\ncircunstâncias como ocorreram. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>I\r\n- FURTO OU ROUBO - </b></font></font></font><font color="#000000"><font face="Arial, sans-serif"><font size="2">anexo\r\ncertidão policial. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>II\r\n- PERDA, EXTRAVIO OU DESAPARECIMENTO. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>III\r\n- QUEDA DA IDENTIFICAÇÃO - plaqueta. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>IV\r\n- REFORMA DO BEM, TAIS COMO PINTURA, ALTERAÇÃO DE CARACTERÍSTICAS,\r\nETC. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>V\r\n- OUTRAS QUE CONSIDERAR IMPORTANTE. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n5º Comunicar a transferência de bens a outra unidade patrimonial da\r\nInstituição com o consentimento desta. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n6º Informar ao Setor de Patrimônio, anexando documentação\r\ncomprobatória, sobre empréstimos ou doações de bens patrimoniais\r\nrecebidos de outras entidades ou pessoas físicas. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n7º Quando for exonerado ou pedir exoneração do cargo, solicitar ao\r\nSetor de Patrimônio relação de bens patrimoniais lotados em sua\r\ncarga, objetivando a transferência de responsabilidade. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n8º Colocar à disposição do Setor de Patrimônio bens que não\r\nestão sendo utilizados em sua unidade, objetivando providências com\r\nrelação a redistribuição dos mesmos. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>CAPÍTULO\r\nII </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES DO SETOR DE PATRIMÔNIO </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n9º É de inteira responsabilidade da Secretaria de Administração e\r\nFazenda, através do Setor de Patrimônio, a administração de todos\r\nos bens patrimoniais desta Instituição, tais como recebimento e\r\nincorporação de bens por doação, por compra, por comodato, por\r\naluguel ou por inventários, controle efetivo dos bens dentro da\r\nInstituição, transferências internas e baixas. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 10º Averiguações\r\nvisando à localização dos bens não encontrados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 11º Registros,\r\nacompanhamentos, fiscalização, arquivo e controle de documentos,\r\nrelatórios, etc., que envolvam irregularidades com bens\r\npatrimoniais, visando a não-superposição de medidas\r\nadministrativas. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 12º Recolocação\r\nde plaqueta, quando for o caso. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 13º Alterações de\r\nregistros patrimoniais, quando for o caso. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 14º Encaminhamento\r\nde processo, objetivando a abertura de sindicância para os casos\r\nnão-resolvidos. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO II </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>DAS BAIXAS </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 15º Anualmente será\r\nnomeada uma Comissão de Baixa e Avaliação pelo Prefeito, com no\r\nmínimo três membros, que ficará encarregada de proceder à baixa\r\nde todos os bens que forem a esta encaminhados pelas Secretarias. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>Art. 16º </b></font></font><font face="Arial, sans-serif"><font size="2">São\r\npassíveis de baixa: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>I - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">que\r\nforem considerados inservíveis, inadequados ou anti-econômicos. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>II - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">perdidos,\r\nextraviados, desaparecidos, furtados ou roubados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>III - Bens\r\nPatrimoniais </b></font></font><font face="Arial, sans-serif"><font size="2">a\r\nserem utilizados na compra de outros. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>IV - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">a serem\r\ntrocados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>V - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">a serem\r\ndoados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>Art. 17º </b></font></font><font face="Arial, sans-serif"><font size="2">Deverão\r\nser encaminhados à Comissão de Baixa e Avaliação: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Os bens patrimoniais\r\nconsiderados, a critério da unidade, como inservíveis, inadequados\r\nou antieconômicos deverão ser encaminhados para baixa através de\r\nofício endereçado à Secretaria Municipal de Administração,\r\nassinado pelo Chefe da unidade, constando as características do BEM,\r\nnúmero de tombamento e o motivo da baixa. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Equipamento a ser\r\ndada baixa deverá ser encaminhado à Secretaria Municipal de\r\nAdministração e Fazenda e em caso de impossibilidade de\r\ndeslocamento do mesmo, indicar o local onde se encontra para que seja\r\nfeita a inspeção necessária. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - A Comissão de\r\nBaixa e Avaliação, em caso de não haver condições técnicas de\r\navaliação e decisão, tomará parecer técnico junto aos órgãos\r\ncompetentes sobre o real estado do bem e a impossibilidade ou\r\ninviabilidade de recuperação do mesmo. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">IV - Após analisada a\r\nsolicitação, esta será encaminhada à Comissão de Baixa, que\r\nexecutará a inspeção final e lavrará a Ata de Baixa do Bem,\r\npossibilitando à Setor de Patrimônio proceder ao Termo de Baixa. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">V - Após a baixa, o\r\nSetor de Patrimônio determinará os seguintes destinos aos bens: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">a) ALIENAÇÃO </font></font>\r\n</p>\r\n<p style="margin-bottom: 0cm; widows: 2; orphans: 2" lang="pt-BR"><font color="#000000"><font face="Arial, sans-serif"><font size="2">b)\r\nEncaminhamento ao Setor de Manutenção de Equipamentos para\r\naproveitamento de peças. </font></font></font>\r\n</p>\r\n<p style="margin-bottom: 0cm; widows: 2; orphans: 2" lang="pt-BR"><font color="#000000"><font face="Arial, sans-serif"><font size="2">c)\r\nGuarda em local próprio, quando se tratar de Bem de valor histórico.\r\n</font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 18º Bem Patrimonial\r\nque não tiver permitida sua baixa, ou seja, que esteja em condições\r\nde uso, deverá permanecer sob a guarda da Administração, que se\r\nencarregará, após verificar o planejamento, de divulgar junto às\r\ndemais unidades a existência do mesmo. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 19º Os Bens\r\nPatrimoniais perdidos, extraviados, desaparecidos, furtados ou\r\nroubados poderão ser baixados através dos seguintes procedimentos: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 1º Comunicação\r\nescrita à Secretaria Municipal de Administração e Fazenda,\r\nassinada pelo Chefe da unidade, constando as características do BEM,\r\nnúmero da Plaqueta e as circunstâncias do fato, sendo, em caso de\r\nroubo ou furto, anexado o Registro Policial. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 2º Relatório do\r\nSetor de Patrimônio, com Parecer final do Prefeito, encaminhado à\r\nSMAF, que fará os encaminhamentos necessários. Todos os relatórios,\r\nbem como os demais documentos, ficarão arquivados na SMAF. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 3º Os relatórios do\r\nSetor de Patrimônio deverão concluir por: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Baixa do BEM, quando\r\nnão caracterizada a culpa por parte de responsável(s). </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Sugerir nomeação\r\nde Comissão de Inquérito quando houver indícios de imprudência,\r\nnegligência ou imperícia por parte dos responsáveis. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - Outras. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 4º Caracterizada a\r\nnecessidade de nomeação da Comissão de Inquérito, esta deverá\r\nconcluir pela: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Baixa do BEM, quando\r\no processo de investigação não evidenciar a culpabilidade e\r\nidentificação de responsáveis. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Indicação dos\r\nresponsáveis pelo fato, ficando estes sujeitos, quando cabível, ao\r\nressarcimento à Instituição em um dos casos abaixo: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">a) Indenização em\r\ndinheiro, compatível ao preço de mercado do BEM. Quando se tratar\r\nde BEM de origem estrangeira, o ressarcimento será feito pela taxa\r\nde câmbio na efetiva data. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">b) Reposição do BEM por\r\noutro com as mesmas características. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">c) Outras. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 20º Nos casos de\r\nperda, extravio ou desaparecimento, cuja baixa for autorizada pela\r\nSMAF ou Comissão de Inquérito, esta somente será efetivada no\r\nSistema informatizado, depois de feito ampla pesquisa na tentativa de\r\nlocalização do BEM. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 21º Todos os bens a\r\nserem baixados, oriundos de Inquéritos ou Sindicância, não serão\r\nsubmetidos à Comissão de Baixa, uma vez que a baixa já terá sido\r\nautorizada pela autoridade competente. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 22º Os bens de\r\nterceiros em que o órgão financiador esteja extinto e não exista\r\num substituto, poderão ser baixados, quando necessário. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO III </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>DOS INVENTÁRIOS </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 23º Pelo menos uma\r\nvez em cada exercício, deverá ser feito em cada secretaria um\r\nlevantamento de Bens Patrimoniais, objetivando fazer um levantamento\r\nfísico e analítico, no sentido de controlar e preservar o\r\npatrimônio e, em cumprimento à legislação vigente. Para isso, o\r\nSetor de Patrimônio emitirá um Relatório atualizado da Carga\r\nPatrimonial de cada Setor com seus respectivos Responsáveis e serão\r\nconferidos os seguintes tópicos: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Bens não\r\nencontrados; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Bens encontrados\r\nfora da unidade à qual estão vinculados; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - Bens encontrados\r\nsem plaqueta (informar localização); </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">IV - Bens que se\r\nencontram fora da Instituição; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">V - Bens inservíveis,\r\nsupérfluos, obsoletos, ociosos ou imprestáveis (informar\r\nlocalização); </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">VI - Bens encontrados que\r\ntiveram baixa autorizada por Comissão de sindicância ou Inquérito.\r\n</font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 24º O relatório\r\ndeverá ser entregue ao Responsável pelo Setor de Patrimônio até o\r\núltimo dia útil do prazo estabelecido, devendo contemplar todos os\r\nbens que se encontram ou que deveriam se encontrar no local sob sua\r\nresponsabilidade. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 25º Após análise\r\ndo relatório o Setor de Patrimônio, tomará as providências no\r\nsentido de solucionar as irregularidades apontadas. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 26º Todos os bens\r\nlocalizados através deste levantamento ou de levantamentos\r\nperiódicos pelas secretarias, que não estejam incorporados ao\r\nPatrimônio, feita a busca e não localizada a sua origem, serão\r\nautomaticamente incorporados ao patrimônio da Instituição, na\r\ncarga da unidade onde estão localizados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO IV </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>CONSIDERAÇÕES GERAIS\r\n</b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Ar. 27º Todos os\r\ndetentores de bens de sua propriedade que estejam dentro da\r\nInstituição deverão informar de forma escrita à sua Secretaria da\r\nexistência dos mesmos. E esta arquivará este informe junto ao\r\nRelatório de Carga Patrimonial. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 28º Os serviços de\r\npessoa física ou jurídica, contratados e que caracterizem a\r\nconfecção de BEM Patrimonial, terão seu fruto incorporado ao\r\nPatrimônio Público e sua documentação anexada ao Processo de\r\nIncorporação. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 29º Todos os bens\r\nadquiridos pela Instituição serão expressos num Termo de\r\nResponsabilidade, que será anualmente atualizado e assinado pelo\r\nresponsável. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 30º Nenhum Bem\r\ndeverá ser consertado sem o conhecimento prévio do Setor de\r\nPatrimônio, o qual cabe fazer o encaminhamento à manutenção. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 31º Nenhum BEM, na\r\nvigência do Período de garantia, poderá ser consertado\r\ninternamente ou por empresa que não seja aquela que vendeu ou\r\nconsertou o bem anteriormente. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 32º Todas as\r\ntransferências de bens serão solicitadas, de forma escrita, à\r\nSMAF, através do Setor de Patrimônio, o qual procederá às\r\nmudanças necessárias. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 33º Sempre que\r\nterminada uma obra civil que implique aumento do Patrimônio da\r\nInstituição, a Comissão de Baixa e Avaliação avaliará o imóvel\r\npara posterior incorporação aos bens imóveis da Instituição. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-bottom: 0cm"><br>\r\n</p>\r\n	2	\N	NCI	2014	3	\N
3	001	2014-05-25	teste	test		2	\N	NCI	2011	1	\N
5	232323	2014-06-23	referencia teste	area teste	<p class="western" style="text-align: center; margin-bottom: 0cm;"><font color="#333333"> \r\n                                  <font face="Arial, sans-serif"><b>PREFEITURA\r\nMUNICIPAL DE MODELO </b></font></font>\r\n</p>\r\n<p style="margin-top: 0.18cm; margin-bottom: 0.18cm; widows: 2; orphans: 2" align="CENTER" lang="pt-BR">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>MANUAL\r\nDE NORMAS E PROCEDIMENTOS PARA CONTROLE PATRIMONIAL </b></font></font></font>\r\n</p>\r\n<p style="margin-top: 0.18cm; margin-bottom: 0.18cm; widows: 2; orphans: 2" align="CENTER" lang="pt-BR">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>TÍTULO\r\nI </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>CAPÍTULO\r\nI </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES DAS CHEFIAS </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n1º É de inteira responsabilidade da Chefia de cada Unidade a carga\r\npatrimonial que estiver vinculada a essa. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n2º O Chefe de cada Unidade poderá designar expressamente servidores\r\nque responderão pela guarda de bens patrimoniais, sendo que a\r\natribuição conferida a esse não eximirá a chefia de\r\nresponsabilidade, caso venham a ocorrer problemas com relação a\r\nbens de sua carga patrimonial. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n3º É de inteira responsabilidade da chefia de cada unidade\r\npatrimonial o acompanhamento da vigência da garantia de bens\r\nadquiridos ou consertados. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n4º O Chefe da unidade deverá comunicar ao Setor de Patrimônio, de\r\nforma escrita, irregularidades ocorridas com bens de sua\r\nresponsabilidade, tais como as abaixo descritas, descrevendo as\r\ncircunstâncias como ocorreram. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>I\r\n- FURTO OU ROUBO - </b></font></font></font><font color="#000000"><font face="Arial, sans-serif"><font size="2">anexo\r\ncertidão policial. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>II\r\n- PERDA, EXTRAVIO OU DESAPARECIMENTO. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>III\r\n- QUEDA DA IDENTIFICAÇÃO - plaqueta. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>IV\r\n- REFORMA DO BEM, TAIS COMO PINTURA, ALTERAÇÃO DE CARACTERÍSTICAS,\r\nETC. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>V\r\n- OUTRAS QUE CONSIDERAR IMPORTANTE. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n5º Comunicar a transferência de bens a outra unidade patrimonial da\r\nInstituição com o consentimento desta. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n6º Informar ao Setor de Patrimônio, anexando documentação\r\ncomprobatória, sobre empréstimos ou doações de bens patrimoniais\r\nrecebidos de outras entidades ou pessoas físicas. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n7º Quando for exonerado ou pedir exoneração do cargo, solicitar ao\r\nSetor de Patrimônio relação de bens patrimoniais lotados em sua\r\ncarga, objetivando a transferência de responsabilidade. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n8º Colocar à disposição do Setor de Patrimônio bens que não\r\nestão sendo utilizados em sua unidade, objetivando providências com\r\nrelação a redistribuição dos mesmos. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>CAPÍTULO\r\nII </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES DO SETOR DE PATRIMÔNIO </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n9º É de inteira responsabilidade da Secretaria de Administração e\r\nFazenda, através do Setor de Patrimônio, a administração de todos\r\nos bens patrimoniais desta Instituição, tais como recebimento e\r\nincorporação de bens por doação, por compra, por comodato, por\r\naluguel ou por inventários, controle efetivo dos bens dentro da\r\nInstituição, transferências internas e baixas. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 10º Averiguações\r\nvisando à localização dos bens não encontrados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 11º Registros,\r\nacompanhamentos, fiscalização, arquivo e controle de documentos,\r\nrelatórios, etc., que envolvam irregularidades com bens\r\npatrimoniais, visando a não-superposição de medidas\r\nadministrativas. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 12º Recolocação\r\nde plaqueta, quando for o caso. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 13º Alterações de\r\nregistros patrimoniais, quando for o caso. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 14º Encaminhamento\r\nde processo, objetivando a abertura de sindicância para os casos\r\nnão-resolvidos. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO II </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>DAS BAIXAS </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 15º Anualmente será\r\nnomeada uma Comissão de Baixa e Avaliação pelo Prefeito, com no\r\nmínimo três membros, que ficará encarregada de proceder à baixa\r\nde todos os bens que forem a esta encaminhados pelas Secretarias. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>Art. 16º </b></font></font><font face="Arial, sans-serif"><font size="2">São\r\npassíveis de baixa: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>I - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">que\r\nforem considerados inservíveis, inadequados ou anti-econômicos. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>II - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">perdidos,\r\nextraviados, desaparecidos, furtados ou roubados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>III - Bens\r\nPatrimoniais </b></font></font><font face="Arial, sans-serif"><font size="2">a\r\nserem utilizados na compra de outros. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>IV - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">a serem\r\ntrocados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>V - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">a serem\r\ndoados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>Art. 17º </b></font></font><font face="Arial, sans-serif"><font size="2">Deverão\r\nser encaminhados à Comissão de Baixa e Avaliação: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Os bens patrimoniais\r\nconsiderados, a critério da unidade, como inservíveis, inadequados\r\nou antieconômicos deverão ser encaminhados para baixa através de\r\nofício endereçado à Secretaria Municipal de Administração,\r\nassinado pelo Chefe da unidade, constando as características do BEM,\r\nnúmero de tombamento e o motivo da baixa. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Equipamento a ser\r\ndada baixa deverá ser encaminhado à Secretaria Municipal de\r\nAdministração e Fazenda e em caso de impossibilidade de\r\ndeslocamento do mesmo, indicar o local onde se encontra para que seja\r\nfeita a inspeção necessária. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - A Comissão de\r\nBaixa e Avaliação, em caso de não haver condições técnicas de\r\navaliação e decisão, tomará parecer técnico junto aos órgãos\r\ncompetentes sobre o real estado do bem e a impossibilidade ou\r\ninviabilidade de recuperação do mesmo. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">IV - Após analisada a\r\nsolicitação, esta será encaminhada à Comissão de Baixa, que\r\nexecutará a inspeção final e lavrará a Ata de Baixa do Bem,\r\npossibilitando à Setor de Patrimônio proceder ao Termo de Baixa. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">V - Após a baixa, o\r\nSetor de Patrimônio determinará os seguintes destinos aos bens: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">a) ALIENAÇÃO </font></font>\r\n</p>\r\n<p style="margin-bottom: 0cm; widows: 2; orphans: 2" lang="pt-BR"><font color="#000000"><font face="Arial, sans-serif"><font size="2">b)\r\nEncaminhamento ao Setor de Manutenção de Equipamentos para\r\naproveitamento de peças. </font></font></font>\r\n</p>\r\n<p style="margin-bottom: 0cm; widows: 2; orphans: 2" lang="pt-BR"><font color="#000000"><font face="Arial, sans-serif"><font size="2">c)\r\nGuarda em local próprio, quando se tratar de Bem de valor histórico.\r\n</font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 18º Bem Patrimonial\r\nque não tiver permitida sua baixa, ou seja, que esteja em condições\r\nde uso, deverá permanecer sob a guarda da Administração, que se\r\nencarregará, após verificar o planejamento, de divulgar junto às\r\ndemais unidades a existência do mesmo. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 19º Os Bens\r\nPatrimoniais perdidos, extraviados, desaparecidos, furtados ou\r\nroubados poderão ser baixados através dos seguintes procedimentos: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 1º Comunicação\r\nescrita à Secretaria Municipal de Administração e Fazenda,\r\nassinada pelo Chefe da unidade, constando as características do BEM,\r\nnúmero da Plaqueta e as circunstâncias do fato, sendo, em caso de\r\nroubo ou furto, anexado o Registro Policial. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 2º Relatório do\r\nSetor de Patrimônio, com Parecer final do Prefeito, encaminhado à\r\nSMAF, que fará os encaminhamentos necessários. Todos os relatórios,\r\nbem como os demais documentos, ficarão arquivados na SMAF. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 3º Os relatórios do\r\nSetor de Patrimônio deverão concluir por: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Baixa do BEM, quando\r\nnão caracterizada a culpa por parte de responsável(s). </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Sugerir nomeação\r\nde Comissão de Inquérito quando houver indícios de imprudência,\r\nnegligência ou imperícia por parte dos responsáveis. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - Outras. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 4º Caracterizada a\r\nnecessidade de nomeação da Comissão de Inquérito, esta deverá\r\nconcluir pela: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Baixa do BEM, quando\r\no processo de investigação não evidenciar a culpabilidade e\r\nidentificação de responsáveis. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Indicação dos\r\nresponsáveis pelo fato, ficando estes sujeitos, quando cabível, ao\r\nressarcimento à Instituição em um dos casos abaixo: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">a) Indenização em\r\ndinheiro, compatível ao preço de mercado do BEM. Quando se tratar\r\nde BEM de origem estrangeira, o ressarcimento será feito pela taxa\r\nde câmbio na efetiva data. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">b) Reposição do BEM por\r\noutro com as mesmas características. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">c) Outras. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 20º Nos casos de\r\nperda, extravio ou desaparecimento, cuja baixa for autorizada pela\r\nSMAF ou Comissão de Inquérito, esta somente será efetivada no\r\nSistema informatizado, depois de feito ampla pesquisa na tentativa de\r\nlocalização do BEM. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 21º Todos os bens a\r\nserem baixados, oriundos de Inquéritos ou Sindicância, não serão\r\nsubmetidos à Comissão de Baixa, uma vez que a baixa já terá sido\r\nautorizada pela autoridade competente. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 22º Os bens de\r\nterceiros em que o órgão financiador esteja extinto e não exista\r\num substituto, poderão ser baixados, quando necessário. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO III </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>DOS INVENTÁRIOS </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 23º Pelo menos uma\r\nvez em cada exercício, deverá ser feito em cada secretaria um\r\nlevantamento de Bens Patrimoniais, objetivando fazer um levantamento\r\nfísico e analítico, no sentido de controlar e preservar o\r\npatrimônio e, em cumprimento à legislação vigente. Para isso, o\r\nSetor de Patrimônio emitirá um Relatório atualizado da Carga\r\nPatrimonial de cada Setor com seus respectivos Responsáveis e serão\r\nconferidos os seguintes tópicos: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Bens não\r\nencontrados; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Bens encontrados\r\nfora da unidade à qual estão vinculados; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - Bens encontrados\r\nsem plaqueta (informar localização); </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">IV - Bens que se\r\nencontram fora da Instituição; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">V - Bens inservíveis,\r\nsupérfluos, obsoletos, ociosos ou imprestáveis (informar\r\nlocalização); </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">VI - Bens encontrados que\r\ntiveram baixa autorizada por Comissão de sindicância ou Inquérito.\r\n</font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 24º O relatório\r\ndeverá ser entregue ao Responsável pelo Setor de Patrimônio até o\r\núltimo dia útil do prazo estabelecido, devendo contemplar todos os\r\nbens que se encontram ou que deveriam se encontrar no local sob sua\r\nresponsabilidade. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 25º Após análise\r\ndo relatório o Setor de Patrimônio, tomará as providências no\r\nsentido de solucionar as irregularidades apontadas. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 26º Todos os bens\r\nlocalizados através deste levantamento ou de levantamentos\r\nperiódicos pelas secretarias, que não estejam incorporados ao\r\nPatrimônio, feita a busca e não localizada a sua origem, serão\r\nautomaticamente incorporados ao patrimônio da Instituição, na\r\ncarga da unidade onde estão localizados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO IV </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>CONSIDERAÇÕES GERAIS\r\n</b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Ar. 27º Todos os\r\ndetentores de bens de sua propriedade que estejam dentro da\r\nInstituição deverão informar de forma escrita à sua Secretaria da\r\nexistência dos mesmos. E esta arquivará este informe junto ao\r\nRelatório de Carga Patrimonial. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 28º Os serviços de\r\npessoa física ou jurídica, contratados e que caracterizem a\r\nconfecção de BEM Patrimonial, terão seu fruto incorporado ao\r\nPatrimônio Público e sua documentação anexada ao Processo de\r\nIncorporação. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 29º Todos os bens\r\nadquiridos pela Instituição serão expressos num Termo de\r\nResponsabilidade, que será anualmente atualizado e assinado pelo\r\nresponsável. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 30º Nenhum Bem\r\ndeverá ser consertado sem o conhecimento prévio do Setor de\r\nPatrimônio, o qual cabe fazer o encaminhamento à manutenção. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 31º Nenhum BEM, na\r\nvigência do Período de garantia, poderá ser consertado\r\ninternamente ou por empresa que não seja aquela que vendeu ou\r\nconsertou o bem anteriormente. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 32º Todas as\r\ntransferências de bens serão solicitadas, de forma escrita, à\r\nSMAF, através do Setor de Patrimônio, o qual procederá às\r\nmudanças necessárias. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 33º Sempre que\r\nterminada uma obra civil que implique aumento do Patrimônio da\r\nInstituição, a Comissão de Baixa e Avaliação avaliará o imóvel\r\npara posterior incorporação aos bens imóveis da Instituição. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-bottom: 0cm"><br>\r\n</p>\r\n	2	\N	IN	2014	3	\N
2	0001	2014-05-22	referencia	area de interesse	<ol><li>\r\n<p class="western" style="text-align: center; margin-bottom: 0cm;"><font color="#333333"> \r\n                                  <font face="Arial, sans-serif"><b>PREFEITURA\r\nMUNICIPAL DE MODELO </b></font></font>\r\n</p>\r\n<p style="margin-top: 0.18cm; margin-bottom: 0.18cm; widows: 2; orphans: 2" align="CENTER" lang="pt-BR">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>MANUAL\r\nDE NORMAS E PROCEDIMENTOS PARA CONTROLE PATRIMONIAL </b></font></font></font>\r\n</p>\r\n<p style="margin-top: 0.18cm; margin-bottom: 0.18cm; widows: 2; orphans: 2" align="CENTER" lang="pt-BR">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>TÍTULO\r\nI </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>CAPÍTULO\r\nI </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES DAS CHEFIAS </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n1º É de inteira responsabilidade da Chefia de cada Unidade a carga\r\npatrimonial que estiver vinculada a essa. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n2º O Chefe de cada Unidade poderá designar expressamente servidores\r\nque responderão pela guarda de bens patrimoniais, sendo que a\r\natribuição conferida a esse não eximirá a chefia de\r\nresponsabilidade, caso venham a ocorrer problemas com relação a\r\nbens de sua carga patrimonial. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n3º É de inteira responsabilidade da chefia de cada unidade\r\npatrimonial o acompanhamento da vigência da garantia de bens\r\nadquiridos ou consertados. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n4º O Chefe da unidade deverá comunicar ao Setor de Patrimônio, de\r\nforma escrita, irregularidades ocorridas com bens de sua\r\nresponsabilidade, tais como as abaixo descritas, descrevendo as\r\ncircunstâncias como ocorreram. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>I\r\n- FURTO OU ROUBO - </b></font></font></font><font color="#000000"><font face="Arial, sans-serif"><font size="2">anexo\r\ncertidão policial. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>II\r\n- PERDA, EXTRAVIO OU DESAPARECIMENTO. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>III\r\n- QUEDA DA IDENTIFICAÇÃO - plaqueta. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>IV\r\n- REFORMA DO BEM, TAIS COMO PINTURA, ALTERAÇÃO DE CARACTERÍSTICAS,\r\nETC. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>V\r\n- OUTRAS QUE CONSIDERAR IMPORTANTE. </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n5º Comunicar a transferência de bens a outra unidade patrimonial da\r\nInstituição com o consentimento desta. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n6º Informar ao Setor de Patrimônio, anexando documentação\r\ncomprobatória, sobre empréstimos ou doações de bens patrimoniais\r\nrecebidos de outras entidades ou pessoas físicas. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n7º Quando for exonerado ou pedir exoneração do cargo, solicitar ao\r\nSetor de Patrimônio relação de bens patrimoniais lotados em sua\r\ncarga, objetivando a transferência de responsabilidade. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n8º Colocar à disposição do Setor de Patrimônio bens que não\r\nestão sendo utilizados em sua unidade, objetivando providências com\r\nrelação a redistribuição dos mesmos. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>CAPÍTULO\r\nII </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2"><b>DAS\r\nRESPONSABILIDADES DO SETOR DE PATRIMÔNIO </b></font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font color="#000000"><font face="Arial, sans-serif"><font size="2">Art.\r\n9º É de inteira responsabilidade da Secretaria de Administração e\r\nFazenda, através do Setor de Patrimônio, a administração de todos\r\nos bens patrimoniais desta Instituição, tais como recebimento e\r\nincorporação de bens por doação, por compra, por comodato, por\r\naluguel ou por inventários, controle efetivo dos bens dentro da\r\nInstituição, transferências internas e baixas. </font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 10º Averiguações\r\nvisando à localização dos bens não encontrados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 11º Registros,\r\nacompanhamentos, fiscalização, arquivo e controle de documentos,\r\nrelatórios, etc., que envolvam irregularidades com bens\r\npatrimoniais, visando a não-superposição de medidas\r\nadministrativas. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 12º Recolocação\r\nde plaqueta, quando for o caso. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 13º Alterações de\r\nregistros patrimoniais, quando for o caso. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 14º Encaminhamento\r\nde processo, objetivando a abertura de sindicância para os casos\r\nnão-resolvidos. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO II </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>DAS BAIXAS </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 15º Anualmente será\r\nnomeada uma Comissão de Baixa e Avaliação pelo Prefeito, com no\r\nmínimo três membros, que ficará encarregada de proceder à baixa\r\nde todos os bens que forem a esta encaminhados pelas Secretarias. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>Art. 16º </b></font></font><font face="Arial, sans-serif"><font size="2">São\r\npassíveis de baixa: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>I - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">que\r\nforem considerados inservíveis, inadequados ou anti-econômicos. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>II - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">perdidos,\r\nextraviados, desaparecidos, furtados ou roubados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>III - Bens\r\nPatrimoniais </b></font></font><font face="Arial, sans-serif"><font size="2">a\r\nserem utilizados na compra de outros. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>IV - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">a serem\r\ntrocados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>V - Bens patrimoniais\r\n</b></font></font><font face="Arial, sans-serif"><font size="2">a serem\r\ndoados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2"><b>Art. 17º </b></font></font><font face="Arial, sans-serif"><font size="2">Deverão\r\nser encaminhados à Comissão de Baixa e Avaliação: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Os bens patrimoniais\r\nconsiderados, a critério da unidade, como inservíveis, inadequados\r\nou antieconômicos deverão ser encaminhados para baixa através de\r\nofício endereçado à Secretaria Municipal de Administração,\r\nassinado pelo Chefe da unidade, constando as características do BEM,\r\nnúmero de tombamento e o motivo da baixa. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Equipamento a ser\r\ndada baixa deverá ser encaminhado à Secretaria Municipal de\r\nAdministração e Fazenda e em caso de impossibilidade de\r\ndeslocamento do mesmo, indicar o local onde se encontra para que seja\r\nfeita a inspeção necessária. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - A Comissão de\r\nBaixa e Avaliação, em caso de não haver condições técnicas de\r\navaliação e decisão, tomará parecer técnico junto aos órgãos\r\ncompetentes sobre o real estado do bem e a impossibilidade ou\r\ninviabilidade de recuperação do mesmo. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">IV - Após analisada a\r\nsolicitação, esta será encaminhada à Comissão de Baixa, que\r\nexecutará a inspeção final e lavrará a Ata de Baixa do Bem,\r\npossibilitando à Setor de Patrimônio proceder ao Termo de Baixa. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">V - Após a baixa, o\r\nSetor de Patrimônio determinará os seguintes destinos aos bens: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">a) ALIENAÇÃO </font></font>\r\n</p>\r\n<p style="margin-bottom: 0cm; widows: 2; orphans: 2" lang="pt-BR"><font color="#000000"><font face="Arial, sans-serif"><font size="2">b)\r\nEncaminhamento ao Setor de Manutenção de Equipamentos para\r\naproveitamento de peças. </font></font></font>\r\n</p>\r\n<p style="margin-bottom: 0cm; widows: 2; orphans: 2" lang="pt-BR"><font color="#000000"><font face="Arial, sans-serif"><font size="2">c)\r\nGuarda em local próprio, quando se tratar de Bem de valor histórico.\r\n</font></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 18º Bem Patrimonial\r\nque não tiver permitida sua baixa, ou seja, que esteja em condições\r\nde uso, deverá permanecer sob a guarda da Administração, que se\r\nencarregará, após verificar o planejamento, de divulgar junto às\r\ndemais unidades a existência do mesmo. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 19º Os Bens\r\nPatrimoniais perdidos, extraviados, desaparecidos, furtados ou\r\nroubados poderão ser baixados através dos seguintes procedimentos: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 1º Comunicação\r\nescrita à Secretaria Municipal de Administração e Fazenda,\r\nassinada pelo Chefe da unidade, constando as características do BEM,\r\nnúmero da Plaqueta e as circunstâncias do fato, sendo, em caso de\r\nroubo ou furto, anexado o Registro Policial. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 2º Relatório do\r\nSetor de Patrimônio, com Parecer final do Prefeito, encaminhado à\r\nSMAF, que fará os encaminhamentos necessários. Todos os relatórios,\r\nbem como os demais documentos, ficarão arquivados na SMAF. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 3º Os relatórios do\r\nSetor de Patrimônio deverão concluir por: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Baixa do BEM, quando\r\nnão caracterizada a culpa por parte de responsável(s). </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Sugerir nomeação\r\nde Comissão de Inquérito quando houver indícios de imprudência,\r\nnegligência ou imperícia por parte dos responsáveis. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - Outras. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">§ 4º Caracterizada a\r\nnecessidade de nomeação da Comissão de Inquérito, esta deverá\r\nconcluir pela: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Baixa do BEM, quando\r\no processo de investigação não evidenciar a culpabilidade e\r\nidentificação de responsáveis. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Indicação dos\r\nresponsáveis pelo fato, ficando estes sujeitos, quando cabível, ao\r\nressarcimento à Instituição em um dos casos abaixo: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">a) Indenização em\r\ndinheiro, compatível ao preço de mercado do BEM. Quando se tratar\r\nde BEM de origem estrangeira, o ressarcimento será feito pela taxa\r\nde câmbio na efetiva data. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">b) Reposição do BEM por\r\noutro com as mesmas características. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">c) Outras. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 20º Nos casos de\r\nperda, extravio ou desaparecimento, cuja baixa for autorizada pela\r\nSMAF ou Comissão de Inquérito, esta somente será efetivada no\r\nSistema informatizado, depois de feito ampla pesquisa na tentativa de\r\nlocalização do BEM. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 21º Todos os bens a\r\nserem baixados, oriundos de Inquéritos ou Sindicância, não serão\r\nsubmetidos à Comissão de Baixa, uma vez que a baixa já terá sido\r\nautorizada pela autoridade competente. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 22º Os bens de\r\nterceiros em que o órgão financiador esteja extinto e não exista\r\num substituto, poderão ser baixados, quando necessário. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO III </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>DOS INVENTÁRIOS </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 23º Pelo menos uma\r\nvez em cada exercício, deverá ser feito em cada secretaria um\r\nlevantamento de Bens Patrimoniais, objetivando fazer um levantamento\r\nfísico e analítico, no sentido de controlar e preservar o\r\npatrimônio e, em cumprimento à legislação vigente. Para isso, o\r\nSetor de Patrimônio emitirá um Relatório atualizado da Carga\r\nPatrimonial de cada Setor com seus respectivos Responsáveis e serão\r\nconferidos os seguintes tópicos: </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">I - Bens não\r\nencontrados; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">II - Bens encontrados\r\nfora da unidade à qual estão vinculados; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">III - Bens encontrados\r\nsem plaqueta (informar localização); </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">IV - Bens que se\r\nencontram fora da Instituição; </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">V - Bens inservíveis,\r\nsupérfluos, obsoletos, ociosos ou imprestáveis (informar\r\nlocalização); </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">VI - Bens encontrados que\r\ntiveram baixa autorizada por Comissão de sindicância ou Inquérito.\r\n</font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 24º O relatório\r\ndeverá ser entregue ao Responsável pelo Setor de Patrimônio até o\r\núltimo dia útil do prazo estabelecido, devendo contemplar todos os\r\nbens que se encontram ou que deveriam se encontrar no local sob sua\r\nresponsabilidade. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 25º Após análise\r\ndo relatório o Setor de Patrimônio, tomará as providências no\r\nsentido de solucionar as irregularidades apontadas. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 26º Todos os bens\r\nlocalizados através deste levantamento ou de levantamentos\r\nperiódicos pelas secretarias, que não estejam incorporados ao\r\nPatrimônio, feita a busca e não localizada a sua origem, serão\r\nautomaticamente incorporados ao patrimônio da Instituição, na\r\ncarga da unidade onde estão localizados. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>TÍTULO IV </b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<font face="Arial, sans-serif"><font size="2"><b>CONSIDERAÇÕES GERAIS\r\n</b></font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Ar. 27º Todos os\r\ndetentores de bens de sua propriedade que estejam dentro da\r\nInstituição deverão informar de forma escrita à sua Secretaria da\r\nexistência dos mesmos. E esta arquivará este informe junto ao\r\nRelatório de Carga Patrimonial. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 28º Os serviços de\r\npessoa física ou jurídica, contratados e que caracterizem a\r\nconfecção de BEM Patrimonial, terão seu fruto incorporado ao\r\nPatrimônio Público e sua documentação anexada ao Processo de\r\nIncorporação. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 29º Todos os bens\r\nadquiridos pela Instituição serão expressos num Termo de\r\nResponsabilidade, que será anualmente atualizado e assinado pelo\r\nresponsável. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 30º Nenhum Bem\r\ndeverá ser consertado sem o conhecimento prévio do Setor de\r\nPatrimônio, o qual cabe fazer o encaminhamento à manutenção. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 31º Nenhum BEM, na\r\nvigência do Período de garantia, poderá ser consertado\r\ninternamente ou por empresa que não seja aquela que vendeu ou\r\nconsertou o bem anteriormente. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 32º Todas as\r\ntransferências de bens serão solicitadas, de forma escrita, à\r\nSMAF, através do Setor de Patrimônio, o qual procederá às\r\nmudanças necessárias. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="JUSTIFY">\r\n<font face="Arial, sans-serif"><font size="2">Art. 33º Sempre que\r\nterminada uma obra civil que implique aumento do Patrimônio da\r\nInstituição, a Comissão de Baixa e Avaliação avaliará o imóvel\r\npara posterior incorporação aos bens imóveis da Instituição. </font></font>\r\n</p>\r\n<p class="western" style="margin-top: 0.18cm; margin-bottom: 0.18cm" align="CENTER">\r\n<br><br>\r\n</p>\r\n<p class="western" style="margin-bottom: 0cm"><br>\r\n</p>\r\n</li></ol>	2	\N	IN	2012	2	\N
4	0002	2014-05-24	teste	teste	<div><u><br></u></div>	2	\N	IN	2012	\N	\N
1	00001	2014-05-04	teste	teste	<br>	2	\N			\N	\N
\.


--
-- TOC entry 1770 (class 0 OID 18015)
-- Dependencies: 144
-- Data for Name: orgao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY orgao (id, codigo, descricao, status) FROM stdin;
4	01	Secretaria de Administração	\N
3	02	Secretaria de Saúde 	\N
11	06	Secretaria de Governo	\N
6	04	Secretaria de Indústria e Comércio 	\N
7	05	Secretaria de Educação	\N
5	03	Secretaria de Obras	\N
12	07	Secretaria de direitos humanos	\N
\.


--
-- TOC entry 1766 (class 0 OID 17927)
-- Dependencies: 136
-- Data for Name: tipo_legislacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_legislacao (id, codigo, descricao, status) FROM stdin;
15	LM	Lei Municipal	\N
16	LF	Lei Federal	\N
17	LE	Lei Estadual	\N
18	LC	Lei Complementar	\N
19	DM	Decreto Municipal	\N
20	DF	Decreto Federal	\N
21	DE	Decreto  Estadual	\N
22	PM	Portaria Municipal	\N
23	PF	Portaria Federal	\N
24	PE	Portaria Estadual	\N
25	RM	Resolu��o Municipal	\N
26	RF	Resolu��o Federal	\N
27	RE	Resolu��o Estadual	\N
28	ICI	Instru��o do Controle Interno	\N
29	ITC	Instru��o do Tribunal de Contas	\N
30	NTSTN	Nota T�cnica STN	\N
31	PL	Projeto de lei	\N
32	CF	Constitui��o Federal	\N
33	CM	Constitui��o Estadual	\N
\.


--
-- TOC entry 1767 (class 0 OID 17931)
-- Dependencies: 138
-- Data for Name: tipo_sistema; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_sistema (id, sigla_tipo_sistema, descricao, nome_sistema, status) FROM stdin;
\.


--
-- TOC entry 1771 (class 0 OID 18030)
-- Dependencies: 147
-- Data for Name: unidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY unidade (id, codigo, descricao, id_orgao, status) FROM stdin;
1	01	Departamento de Pessoal	4	\N
3	03	Hospital Santa Terezinha	3	\N
2	02	Hospital Nossa Senhora Aparecida	3	\N
\.


--
-- TOC entry 1768 (class 0 OID 17938)
-- Dependencies: 140
-- Data for Name: unidade_orcamentaria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY unidade_orcamentaria (id, codigo, descricao, id_unidade, status) FROM stdin;
6	02    	Setor de recrutamento	1	\N
5	01    	Posto de atendimento 1	2	\N
\.


--
-- TOC entry 1769 (class 0 OID 17942)
-- Dependencies: 142
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id, nome, cpf, identidade, nome_mae, senha, data_nascimento, "login", email, nivel, empresa, cargo_ou_funcao, status) FROM stdin;
2	master	11111111111			123456	2014-06-30	master		5	\N		\N
3	master2	333333			123456	\N	master2		5	\N		\N
\.


--
-- TOC entry 1773 (class 0 OID 18140)
-- Dependencies: 149
-- Data for Name: usuario_empresa; Type: TABLE DATA; Schema: public; Owner: horaciob
--

COPY usuario_empresa (id, empresa_id, usuario_id, status) FROM stdin;
\.


--
-- TOC entry 1749 (class 2606 OID 34620)
-- Dependencies: 156 156
-- Name: agenda_pkey; Type: CONSTRAINT; Schema: public; Owner: horaciob; Tablespace: 
--

ALTER TABLE ONLY agenda
    ADD CONSTRAINT agenda_pkey PRIMARY KEY (id);


--
-- TOC entry 1741 (class 2606 OID 18139)
-- Dependencies: 148 148
-- Name: empresa_usuaria_pkey; Type: CONSTRAINT; Schema: public; Owner: horaciob; Tablespace: 
--

ALTER TABLE ONLY empresa_usuaria
    ADD CONSTRAINT empresa_usuaria_pkey PRIMARY KEY (id);


--
-- TOC entry 1747 (class 2606 OID 34613)
-- Dependencies: 154 154
-- Name: pk_id_agenda; Type: CONSTRAINT; Schema: public; Owner: horaciob; Tablespace: 
--

ALTER TABLE ONLY "Agenda"
    ADD CONSTRAINT pk_id_agenda PRIMARY KEY (id);


--
-- TOC entry 1745 (class 2606 OID 18159)
-- Dependencies: 152 152
-- Name: pk_id_arquivo; Type: CONSTRAINT; Schema: public; Owner: horaciob; Tablespace: 
--

ALTER TABLE ONLY arquivo
    ADD CONSTRAINT pk_id_arquivo PRIMARY KEY (id);


--
-- TOC entry 1709 (class 2606 OID 17963)
-- Dependencies: 118 118
-- Name: pk_id_auditoria; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY auditoria
    ADD CONSTRAINT pk_id_auditoria PRIMARY KEY (id);


--
-- TOC entry 1711 (class 2606 OID 17965)
-- Dependencies: 120 120
-- Name: pk_id_codigo_irregularidade; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY codigo_irregularidade
    ADD CONSTRAINT pk_id_codigo_irregularidade PRIMARY KEY (id);


--
-- TOC entry 1713 (class 2606 OID 17967)
-- Dependencies: 122 122
-- Name: pk_id_departamento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT pk_id_departamento PRIMARY KEY (id);


--
-- TOC entry 1717 (class 2606 OID 17969)
-- Dependencies: 124 124
-- Name: pk_id_empresa; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT pk_id_empresa PRIMARY KEY (id);


--
-- TOC entry 1719 (class 2606 OID 17971)
-- Dependencies: 126 126
-- Name: pk_id_entidade; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY entidade
    ADD CONSTRAINT pk_id_entidade PRIMARY KEY (id);


--
-- TOC entry 1721 (class 2606 OID 17973)
-- Dependencies: 128 128
-- Name: pk_id_imagem; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY imagem
    ADD CONSTRAINT pk_id_imagem PRIMARY KEY (id);


--
-- TOC entry 1723 (class 2606 OID 17975)
-- Dependencies: 130 130
-- Name: pk_id_irregularidades; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY irregularidades
    ADD CONSTRAINT pk_id_irregularidades PRIMARY KEY (id);


--
-- TOC entry 1725 (class 2606 OID 17977)
-- Dependencies: 132 132
-- Name: pk_id_legislacao; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY legislacao
    ADD CONSTRAINT pk_id_legislacao PRIMARY KEY (id);


--
-- TOC entry 1727 (class 2606 OID 17979)
-- Dependencies: 134 134
-- Name: pk_id_normas_procedimentos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY normas_procedimentos
    ADD CONSTRAINT pk_id_normas_procedimentos PRIMARY KEY (id);


--
-- TOC entry 1737 (class 2606 OID 18027)
-- Dependencies: 144 144
-- Name: pk_id_orgao; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orgao
    ADD CONSTRAINT pk_id_orgao PRIMARY KEY (id);


--
-- TOC entry 1729 (class 2606 OID 17981)
-- Dependencies: 136 136
-- Name: pk_id_tipo_legislacao; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_legislacao
    ADD CONSTRAINT pk_id_tipo_legislacao PRIMARY KEY (id);


--
-- TOC entry 1731 (class 2606 OID 17983)
-- Dependencies: 138 138
-- Name: pk_id_tipo_sistema; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_sistema
    ADD CONSTRAINT pk_id_tipo_sistema PRIMARY KEY (id);


--
-- TOC entry 1739 (class 2606 OID 18037)
-- Dependencies: 147 147
-- Name: pk_id_unidade; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY unidade
    ADD CONSTRAINT pk_id_unidade PRIMARY KEY (id);


--
-- TOC entry 1733 (class 2606 OID 17985)
-- Dependencies: 140 140
-- Name: pk_id_unidade_orcamentaria; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY unidade_orcamentaria
    ADD CONSTRAINT pk_id_unidade_orcamentaria PRIMARY KEY (id);


--
-- TOC entry 1735 (class 2606 OID 17987)
-- Dependencies: 142 142
-- Name: pk_id_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT pk_id_usuario PRIMARY KEY (id);


--
-- TOC entry 1715 (class 2606 OID 17989)
-- Dependencies: 122 122
-- Name: unique_descricao_departamento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT unique_descricao_departamento UNIQUE (descricao);


--
-- TOC entry 1743 (class 2606 OID 18143)
-- Dependencies: 149 149
-- Name: usuario_empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: horaciob; Tablespace: 
--

ALTER TABLE ONLY usuario_empresa
    ADD CONSTRAINT usuario_empresa_pkey PRIMARY KEY (id);


--
-- TOC entry 1756 (class 2606 OID 18144)
-- Dependencies: 1740 148 149
-- Name: fk6982cc78d57c1373; Type: FK CONSTRAINT; Schema: public; Owner: horaciob
--

ALTER TABLE ONLY usuario_empresa
    ADD CONSTRAINT fk6982cc78d57c1373 FOREIGN KEY (empresa_id) REFERENCES empresa_usuaria(id);


--
-- TOC entry 1751 (class 2606 OID 18123)
-- Dependencies: 120 1710 130
-- Name: fk_id_codigo_irregularidade; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY irregularidades
    ADD CONSTRAINT fk_id_codigo_irregularidade FOREIGN KEY (codigo) REFERENCES codigo_irregularidade(id);


--
-- TOC entry 1753 (class 2606 OID 18128)
-- Dependencies: 122 1712 134
-- Name: fk_id_departamento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY normas_procedimentos
    ADD CONSTRAINT fk_id_departamento FOREIGN KEY (id_departamento) REFERENCES departamento(id);


--
-- TOC entry 1755 (class 2606 OID 18038)
-- Dependencies: 147 144 1736
-- Name: fk_id_orgao; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY unidade
    ADD CONSTRAINT fk_id_orgao FOREIGN KEY (id_orgao) REFERENCES orgao(id);


--
-- TOC entry 1754 (class 2606 OID 18043)
-- Dependencies: 147 140 1738
-- Name: fk_id_unidade; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY unidade_orcamentaria
    ADD CONSTRAINT fk_id_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id);


--
-- TOC entry 1752 (class 2606 OID 34590)
-- Dependencies: 1724 132 132
-- Name: fk_legislacao_vinculo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY legislacao
    ADD CONSTRAINT fk_legislacao_vinculo FOREIGN KEY (legislacao_vinculada) REFERENCES legislacao(id);


--
-- TOC entry 1750 (class 2606 OID 18114)
-- Dependencies: 140 122 1732
-- Name: id_unidade_orcamentaria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT id_unidade_orcamentaria FOREIGN KEY (id_unidade_orcamentaria) REFERENCES unidade_orcamentaria(id);


--
-- TOC entry 1781 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 1788 (class 0 OID 0)
-- Dependencies: 118
-- Name: auditoria; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE auditoria FROM PUBLIC;
REVOKE ALL ON TABLE auditoria FROM postgres;
GRANT ALL ON TABLE auditoria TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE auditoria TO horaciob;


--
-- TOC entry 1791 (class 0 OID 0)
-- Dependencies: 119
-- Name: auditoria_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE auditoria_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE auditoria_id_seq FROM postgres;
GRANT ALL ON SEQUENCE auditoria_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE auditoria_id_seq TO horaciob;


--
-- TOC entry 1792 (class 0 OID 0)
-- Dependencies: 120
-- Name: codigo_irregularidade; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE codigo_irregularidade FROM PUBLIC;
REVOKE ALL ON TABLE codigo_irregularidade FROM postgres;
GRANT ALL ON TABLE codigo_irregularidade TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE codigo_irregularidade TO horaciob;


--
-- TOC entry 1795 (class 0 OID 0)
-- Dependencies: 121
-- Name: codigo_irregularidade_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE codigo_irregularidade_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE codigo_irregularidade_id_seq FROM postgres;
GRANT ALL ON SEQUENCE codigo_irregularidade_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE codigo_irregularidade_id_seq TO horaciob;


--
-- TOC entry 1796 (class 0 OID 0)
-- Dependencies: 122
-- Name: departamento; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE departamento FROM PUBLIC;
REVOKE ALL ON TABLE departamento FROM postgres;
GRANT ALL ON TABLE departamento TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE departamento TO horaciob;


--
-- TOC entry 1799 (class 0 OID 0)
-- Dependencies: 123
-- Name: departamento_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE departamento_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE departamento_id_seq FROM postgres;
GRANT ALL ON SEQUENCE departamento_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE departamento_id_seq TO horaciob;


--
-- TOC entry 1800 (class 0 OID 0)
-- Dependencies: 124
-- Name: empresa; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE empresa FROM PUBLIC;
REVOKE ALL ON TABLE empresa FROM postgres;
GRANT ALL ON TABLE empresa TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE empresa TO horaciob;


--
-- TOC entry 1803 (class 0 OID 0)
-- Dependencies: 125
-- Name: empresa_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE empresa_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE empresa_id_seq FROM postgres;
GRANT ALL ON SEQUENCE empresa_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE empresa_id_seq TO horaciob;


--
-- TOC entry 1804 (class 0 OID 0)
-- Dependencies: 126
-- Name: entidade; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE entidade FROM PUBLIC;
REVOKE ALL ON TABLE entidade FROM postgres;
GRANT ALL ON TABLE entidade TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE entidade TO grupo1;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE entidade TO horaciob;


--
-- TOC entry 1807 (class 0 OID 0)
-- Dependencies: 127
-- Name: entidade_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE entidade_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE entidade_id_seq FROM postgres;
GRANT ALL ON SEQUENCE entidade_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE entidade_id_seq TO horaciob;


--
-- TOC entry 1809 (class 0 OID 0)
-- Dependencies: 128
-- Name: imagem; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE imagem FROM PUBLIC;
REVOKE ALL ON TABLE imagem FROM postgres;
GRANT ALL ON TABLE imagem TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE imagem TO grupo1;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE imagem TO horaciob;


--
-- TOC entry 1812 (class 0 OID 0)
-- Dependencies: 129
-- Name: imagem_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE imagem_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE imagem_id_seq FROM postgres;
GRANT ALL ON SEQUENCE imagem_id_seq TO postgres;
GRANT ALL ON SEQUENCE imagem_id_seq TO grupo1;
GRANT SELECT,UPDATE ON SEQUENCE imagem_id_seq TO horaciob;


--
-- TOC entry 1813 (class 0 OID 0)
-- Dependencies: 130
-- Name: irregularidades; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE irregularidades FROM PUBLIC;
REVOKE ALL ON TABLE irregularidades FROM postgres;
GRANT ALL ON TABLE irregularidades TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE irregularidades TO horaciob;


--
-- TOC entry 1816 (class 0 OID 0)
-- Dependencies: 131
-- Name: irregularidades_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE irregularidades_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE irregularidades_id_seq FROM postgres;
GRANT ALL ON SEQUENCE irregularidades_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE irregularidades_id_seq TO horaciob;


--
-- TOC entry 1817 (class 0 OID 0)
-- Dependencies: 132
-- Name: legislacao; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE legislacao FROM PUBLIC;
REVOKE ALL ON TABLE legislacao FROM postgres;
GRANT ALL ON TABLE legislacao TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE legislacao TO horaciob;


--
-- TOC entry 1820 (class 0 OID 0)
-- Dependencies: 133
-- Name: legislacao_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE legislacao_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE legislacao_id_seq FROM postgres;
GRANT ALL ON SEQUENCE legislacao_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE legislacao_id_seq TO horaciob;


--
-- TOC entry 1822 (class 0 OID 0)
-- Dependencies: 134
-- Name: normas_procedimentos; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE normas_procedimentos FROM PUBLIC;
REVOKE ALL ON TABLE normas_procedimentos FROM postgres;
GRANT ALL ON TABLE normas_procedimentos TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE normas_procedimentos TO horaciob;


--
-- TOC entry 1825 (class 0 OID 0)
-- Dependencies: 135
-- Name: normas_procedimentos_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE normas_procedimentos_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE normas_procedimentos_id_seq FROM postgres;
GRANT ALL ON SEQUENCE normas_procedimentos_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE normas_procedimentos_id_seq TO horaciob;


--
-- TOC entry 1826 (class 0 OID 0)
-- Dependencies: 144
-- Name: orgao; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE orgao FROM PUBLIC;
REVOKE ALL ON TABLE orgao FROM postgres;
GRANT ALL ON TABLE orgao TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE orgao TO horaciob;


--
-- TOC entry 1829 (class 0 OID 0)
-- Dependencies: 145
-- Name: orgao_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE orgao_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE orgao_id_seq FROM postgres;
GRANT ALL ON SEQUENCE orgao_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE orgao_id_seq TO horaciob;


--
-- TOC entry 1830 (class 0 OID 0)
-- Dependencies: 136
-- Name: tipo_legislacao; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE tipo_legislacao FROM PUBLIC;
REVOKE ALL ON TABLE tipo_legislacao FROM postgres;
GRANT ALL ON TABLE tipo_legislacao TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE tipo_legislacao TO horaciob;


--
-- TOC entry 1833 (class 0 OID 0)
-- Dependencies: 137
-- Name: tipo_legislacao_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE tipo_legislacao_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE tipo_legislacao_id_seq FROM postgres;
GRANT ALL ON SEQUENCE tipo_legislacao_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE tipo_legislacao_id_seq TO horaciob;


--
-- TOC entry 1834 (class 0 OID 0)
-- Dependencies: 138
-- Name: tipo_sistema; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE tipo_sistema FROM PUBLIC;
REVOKE ALL ON TABLE tipo_sistema FROM postgres;
GRANT ALL ON TABLE tipo_sistema TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE tipo_sistema TO horaciob;


--
-- TOC entry 1837 (class 0 OID 0)
-- Dependencies: 139
-- Name: tipo_sistema_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE tipo_sistema_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE tipo_sistema_id_seq FROM postgres;
GRANT ALL ON SEQUENCE tipo_sistema_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE tipo_sistema_id_seq TO horaciob;


--
-- TOC entry 1838 (class 0 OID 0)
-- Dependencies: 147
-- Name: unidade; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE unidade FROM PUBLIC;
REVOKE ALL ON TABLE unidade FROM postgres;
GRANT ALL ON TABLE unidade TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE unidade TO horaciob;


--
-- TOC entry 1841 (class 0 OID 0)
-- Dependencies: 146
-- Name: unidade_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE unidade_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE unidade_id_seq FROM postgres;
GRANT ALL ON SEQUENCE unidade_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE unidade_id_seq TO horaciob;


--
-- TOC entry 1842 (class 0 OID 0)
-- Dependencies: 140
-- Name: unidade_orcamentaria; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE unidade_orcamentaria FROM PUBLIC;
REVOKE ALL ON TABLE unidade_orcamentaria FROM postgres;
GRANT ALL ON TABLE unidade_orcamentaria TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE unidade_orcamentaria TO horaciob;


--
-- TOC entry 1845 (class 0 OID 0)
-- Dependencies: 141
-- Name: unidade_orcamentaria_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE unidade_orcamentaria_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE unidade_orcamentaria_id_seq FROM postgres;
GRANT ALL ON SEQUENCE unidade_orcamentaria_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE unidade_orcamentaria_id_seq TO horaciob;


--
-- TOC entry 1846 (class 0 OID 0)
-- Dependencies: 142
-- Name: usuario; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE usuario FROM PUBLIC;
REVOKE ALL ON TABLE usuario FROM postgres;
GRANT ALL ON TABLE usuario TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE usuario TO grupo1;


--
-- TOC entry 1849 (class 0 OID 0)
-- Dependencies: 143
-- Name: usuario_id_seq; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON SEQUENCE usuario_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE usuario_id_seq FROM postgres;
GRANT ALL ON SEQUENCE usuario_id_seq TO postgres;
GRANT SELECT,UPDATE ON SEQUENCE usuario_id_seq TO horaciob;


-- Completed on 2014-11-08 13:34:23

--
-- PostgreSQL database dump complete
--

