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

El dataset original Anime Data se puede obtener de la URL (https://www.kaggle.com/datasets/mishraboi/anime-data). Originalmente tiene 55 columnas y cada fila contiene datos sobre un anime registrado en myanimelist.com. El dataset usado en este proyecto tiene 13 columnas. A continuación se describen las 13 columnas del dataset:

* **number**: de tipo entero, indica el índice del anime dentro del csv.
* **anime_id**: de tipo entero, indica el id del anime dentro de la página myanimelist.
* **anime_name**: de tipo cadena, contiene el nombre del anime.
* **studio_id**: de tipo entero, indica el id del estudio que produjo el anime.
* **episodes_total**: de tipo entero, es el número de episodios que tiene el anime.
* **source_material**: de tipo enumerado, indica el recurso del que surgió el anime. Puede tomar los valores: 4-koma manga, Book, Card game, Digital manga, Game, Light novel, Manga, Music, Novel, Original, Other, Picture Book, Radio, Visual novel, Web manga o bien valores nulos(//podria asignarle Others en ese caso).

// sin editar a partir de aquí
* **black_rating**: de tipo entero, tiene el valor ELO del jugador de negras. 
* **moves**: de tipo cadena, contiene una secuencia con los movimientos de la partida. Los movimientos están separados por espacios en blanco. Por ejemplo, ```d4 d5 c4 c6 cxd5 e6 dxe6 fxe6 Nf3 Bb4+ Nc3 Ba5 Bf4```.
* **opening_name**: de tipo cadena, indica la salida y la defensa de la partida. Esto no se
corresponde con el primer o segundo movimiento, sino que son las salidas y sus distintas variantes, por ejemplo, ```Queen's Pawn Game: Mason Attack```.
* **fecha**: de tipo fecha. Indica la fecha en la que se jugó la partida.
* **duracion**: de tipo entero. Indica la duración en minutos de la partida.
