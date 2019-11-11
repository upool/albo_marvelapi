package com.albo.service;

import com.albo.model.CharacterDataWrapper;
import com.albo.model.ComicDataWrapper;
import com.albo.response.Colaborator;

/***
 * Define the methods from Marvel API
 * @author PaulM
 *
 */
public interface IMarvelService {

	/***
	 * Get the characters info
	 * @return Character wrapper object
	 */
	CharacterDataWrapper getCharacters();
	
	/***
	 * Get the comics info
	 * @param character ID
	 * @return Comic wrapper object
	 */
	ComicDataWrapper getComics(int character);
	
	/***
	 * Get the information of a character's collaborators
	 * @param character nickname
	 * @return the object of colaborators
	 */
    Colaborator getColaboratorInfo(String character);
}
