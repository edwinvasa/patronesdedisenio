en este modulo se trabajará con el patrón de diseño llamado **Factory**. 
Este es un patron de **tipo creacional**.

"_Permite la creación de objetos de un subtipo determinado a través de una clase Factory.
Esto es especialmente util cuando no sabemos, en tiempo de diseño, el subtipo qe vamos a utilizar o cuando queremos delegar la lógica de creación de objetos a una clase Factory.
utilizando este patrón podemos crear instancias dinamicamente mediante la configuración estableciendo cual será la implementación a utilizar en un archivo de texto, XML, properties o mediante cualquier otra estrategia._"

_Introducción a los patrones de diseño - Oscar Blancarte._

Script para crear la tabla Product en postgres:

CREATE TABLE IF NOT EXISTS public.product
(
idProduct integer NOT NULL,
name character varying(80) NOT NULL,
price double precision,
PRIMARY KEY (idProduct)
)
WITH (
OIDS = FALSE
);

ALTER TABLE public.product
OWNER to postgres;
