# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autora: Lucía Ponce

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.anime**: Paquete que contiene los tipos del proyecto.
  * **fp.anime.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**: Paquete que contiene las clases de utilidad. 
  * **fp.common**: Paquete que contiene los tipos auxiliares.
* **/data**: Contiene el dataset del proyecto.
    * **animes.csv**: Archivo csv que contiene datos de diferentes animes.
    
## Estructura del *dataset*

El dataset original Anime Data se puede obtener de la URL (https://www.kaggle.com/datasets/mishraboi/anime-data). Originalmente tiene 55 columnas y cada fila contiene datos sobre un anime registrado en myanimelist.com. El dataset usado en este proyecto tiene 52 columnas, pues se eliminaron las columnas Yaoi, Yuri y Hentai.
A continuación se describen las columnas del dataset:

* **csv_id**: de tipo entero, indica el índice del anime dentro del csv.
* **anime_id**: de tipo entero, indica el id del anime dentro de la página myanimelist.
* **anime_name**: de tipo cadena, contiene el nombre del anime.
* **studio_id**: de tipo entero, indica el id del estudio que produjo el anime.
* **episodes_total**: de tipo float, es el número de episodios que tiene el anime.
* **source_material**: de tipo cadena, indica el recurso del que surgió el anime.
* **air_date**: de tipo cadena, indica la fecha en la que el anime fue estrenado. Por ejemplo: ```Jan 25, 1996   Mar 2, 1985```
* **overall_rating**: de tipo float, se trata de una valoración media de los espectadores con valores del 0 al 10.
* **members**: de tipo entero, son los seguidores que tiene el anime.
* **synopsis**: de tipo cadena, se trata de un breve resumen sobre el argumento del anime.
* **number of tags**: de tipo entero, indica el número de etiquetas de género que tiene el anime.
    * **Action**: de tipo float, indica si el anime pertenece al género de acción.
    * **Adventure**: de tipo float, indica si el anime pertenece al género de aventura.
    * **Cars**: de tipo float, indica si el anime pertenece al género de coches.
    * **Comedy**: de tipo float, indica si el anime pertenece al género de comedia.
    * **Dementia**: de tipo float, indica si el anime pertenece al género de locura.
    * **Demons**: de tipo float, indica si el anime pertenece al género de demonios.
    * **Drama**: de tipo float, indica si el anime pertenece al género de drama.
    * **Ecchi**: de tipo float, indica si el anime tiene un ligero contenido sexual.
    * **Fantasy**: de tipo float, indica si el anime pertenece al género de fantasía.
    * **Game**: de tipo float, indica si el anime pertenece al género de videojuegos.
    * **Harem**: de tipo float, indica si el anime pertenece a un género en el que un hombre está rodeado de muchas mujeres.
    * **Historical**: de tipo float, indica si el anime pertenece al género histórico.
    * **Horror**: de tipo float, indica si el anime pertenece al género de horror.
    * **Josei**: de tipo float, indica si el anime está dirigido a mujeres adultas.
    * **Kids**: de tipo float, indica si el anime está dirigido a niños.
    * **Magic**: de tipo float, indica si el anime pertenece al género de magia.
    * **Martial_Arts**: de tipo float, indica si el anime pertenece al género de artes marciales.
    * **Mecha**: de tipo float, indica si el anime pertenece al género de robots pilotados.
    * **Military**: de tipo float, indica si el anime pertenece al género militar.
    * **Music**: de tipo float, indica si el anime pertenece al género musical.
    * **Mystery**: de tipo float, indica si el anime pertenece al género de misterio.
    * **Parody**: de tipo float, indica si el anime es una parodia.
    * **Police**: de tipo float, indica si el anime pertenece al género policial.
    * **Psycological**: de tipo float, indica si el anime pertenece al género psicológico.
    * **Romance**: de tipo float, indica si el anime pertenece al género de romance.
    * **Samurai**: de tipo float, indica si el anime pertenece al género de samurais.
    * **School**: de tipo float, indica si el anime pertenece al género escolar.
    * **Sci-Fi**: de tipo float, indica si el anime pertenece al género excesivamente futurista.
    * **Seinen**: de tipo float, indica si el anime está dirigido a hombres adultos.
    * **Shoujo**: de tipo float, indica si el anime está dirigido a mujeres adolescentes.
    * **Shoujo_Ai**: de tipo float, indica si el anime se centra en el amor entre chicas.
    * **Slice_of_Life**: de tipo float, indica si el anime pertenece al género de recuentos de la vida.
    * **Space**: de tipo float, indica si el anime pertenece al género del espacio.
    * **Sports**: de tipo float, indica si el anime pertenece al género de deportes.
    * **Super_Power**: de tipo float, indica si el anime pertenece al género de superpoderes.
    * **Supernatural**: de tipo float, indica si el anime pertenece al género sobrenatural.
    * **Thriller**: de tipo float, indica si el anime pertenece al género de terror.
    * **Vampire**: de tipo float, indica si el anime pertenece al género de vampiros.
* **studio_name**: se tipo cadena, indica el nombre del estudio que produjo el anime.

## Tipos implementados

### Tipo Base - Anime
Representa un anime concreto.

**Propiedades**:

* *anime_id*, de tipo *Integer*, consultable. Indica el id del anime.
* *nombre*, de tipo *String*, consultable. Contiene el nombre del anime.
* *episodios*, de tipo *Integer*, consultable y modificable. Indica el número de episodios que tiene el anime.
* *origen*, de tipo *Source*, consultable. Indica de dónde se inspiró el anime. Puede tomar los valores BOOK, CARD_GAME, MANGA, GAME, NOVEL, MUSIC, ORIGINAL, RADIO, OTHER.
* *estreno*, de tipo *LocalDateTime*, consultable. Es la fecha de estreno del anime.
* *valoracion*, de tipo *Double*, consultable y modificable. Se trata de una valoración media de los espectadores con valores del 0.0 al 10.0.
* *seguidores*, de tipo *Integer*, consultable y modificable. Son los seguidores que tiene el anime.
* *sinopsis*, de tipo *String*, consultable. Se trata de un breve resumen sobre el argumento del anime.
* *genero*, de tipo *Set*<*String*>, consultable. Es una lista formada por el/los género(s) al/a los que pertenece el anime.
* *estudio*, de tipo *Studio*, consultable y modificable. Indica el estudio al que pertenece el anime. Contiene el id y el nombre del estudio.

**Propiedades derivadas**:

* *getFormatoCorto()*, de tipo *String*, consultable. Obtiene una cadena con el siguiente formato: nombre ("año de estreno") --> ["nº de episodios" episodios]
* *getPopularidad()*, de tipo *Double*, consultable. Se calcula según la siguiente fórmula: (seguidores/1000)*valoracion
* *getOriginal()*, de tipo *Boolean*, consultable. Indica si el anime es original (true) o proviene de otra fuente (false).

**Constructores**:

* C1: Tiene un parámetro por cada propiedad básica del tipo.
* C2: Crea un objeto de tipo ```Anime``` a partir de los siguientes parámetros: ```Integer anime_id, String nombre, Source origen, LocalDateTime estreno, String sinopsis, Set<String> genero, Studio estudio```. Además, tendrá 1 episodio, 0.0 de valoración y 0 seguidores.

**Restricciones**:

* R1: El nombre no puede ser nulo ni estar vacío.
* R2: El anime debe tener 1 episodio o más.
* R3: La fecha de estreno no puede ser posterior a la fecha actual.

**Criterio de igualdad**: Dos animes son iguales si lo son su anime_id, nombre, origen y estreno.

**Criterio de ordenación**: Por nombre y estreno.

**Tipos auxiliares**:

* Source, tipo enumerado. Puede tomar los valores BOOK, CARD_GAME, MANGA, GAME, NOVEL, MUSIC, ORIGINAL, RADIO, OTHER.
* Studio, tipo clase. Se describe más abajo.
* Checkers, tipo clase. Contiene el código de las restricciones.

## Tipo auxiliar - Studio
Representa un estudio concreto.

**Propiedades**:

* *id*, de tipo *Integer*, consultable.
* *nombre*, de tipo *String*, consultable y modificable.

**Constructor**:
* C1: Tiene un parámetro por cada propiedad básica del tipo.

**Restricciones**:

* R1: El id no puede ser negativo.
* R2: El nombre no puede ser nulo ni estar vacío.

**Criterio de igualdad**: Dos estudios son iguales si su id y su nombre son iguales.

**Tipos auxiliares**:

* Checkers, tipo clase. Contiene el código de las restricciones.

### Tipo auxiliar - Checkers
Contiene métodos para aplicar distintas restricciones.

**Métodos estáticos:**

* *void checkVacio(String s):* Comprueba que la String que se le pasa por parámetro no esté vacía ni sea nula.
* *void checkEpisodios(Integer ep):* Comprueba que el número de episodios del anime sea estrictamente mayor que cero.
* *void checkEstreno(LocalDateTime fecha):* Comprueba que la fecha de estreno no sea posterior a la fecha actual.
* *void checkId(Integer id):* Comprueba que el id especificado por parámetro no es negativo.
* *void checkGenero(String genero):* Comprueba si el género especificado por parámetro pertenece a los géneros que contiene el dataset. Si el género no es correcto, lanzará una excepción indicando los géneros presentes en el dataset.

## Factoría - FactoriaPartidas

Clase de factoría para construir objetos de tipo Animes.

* *Animes leerAnimes(String fichero)*: Crea un objeto tipo Animes a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

## Tipo Contenedor - Animes

Clase contenedora de los objetos de tipo Anime.

**Propiedades:**

* *animes*, de tipo *List<Anime>*, consultable. Lista de animes.

**Constructores:**

* C1: Constructor por defecto. Crea un objeto de tipo Animes sin ningún anime almacenado.
* C2: Constructor con un parámetro tipo *Collection<Anime>*. Crea un objeto de tipo Animes con los animes incluidos en la colección dada como parámetro.

**Criterio de igualdad:** Dos Animes son iguales si lo son sus propiedades animes.

**Otras operaciones:**

* *Integer getNumeroAnimes():* Devuelve el número de animes que hay en el tipo contenedor.
* *void agregarAnime(Anime a):* Agrega un anime al tipo contenedor.
* *void agregarAnimes(Collection<Anime> as):* Agrega una colección de animes al tipo contenedor.
* *void eliminarAnime(Anime a):* Elimina un anime del tipo contenedor.
* *void eliminarAnime(int i):* Elimina el anime del tipo contenedor al que corresponde su índice.
* *Boolean existeAnimeValoraciónMayorA(Double valoracion):* Función que dada una valoración devuelve un booleano que indica si existen animes con valoración estrictamente mayor a esta.
* *Double mediaValoracionAnimes():* Devuelve la media de las valoraciones de los animes que se encuentran en el tipo contenedor.
* *List<Anime> getAnimesGenero(String genero):* Obtiene la lista de animes que pertenecen al género indicado por parámetro.
* *Map<Source,List<Anime>> getAnimesPorOrigen():* Clasifica los animes por su origen y los almacena en un diccionario.
* *Map<Studio,Integer> getNumeroAnimesPorEstudio():* Cuenta los animes que pertenecen a cada estudio.

