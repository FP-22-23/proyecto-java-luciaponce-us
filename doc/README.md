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
