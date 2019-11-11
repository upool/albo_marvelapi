package com.albo.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.albo.enums.CharacterEnum;
import com.albo.enums.RoleEnum;
import com.albo.model.CharacterDataWrapper;
import com.albo.model.Comic;
import com.albo.model.ComicDataWrapper;
import com.albo.model.CreatorItem;
import com.albo.response.Colaborator;


/***
 * Marvel API call Implementation
 * @author PaulM
 *
 */
@Service("charactersService")
public class MarvelServiceImp implements IMarvelService {

	private static final Logger LOG = LoggerFactory.getLogger(MarvelServiceImp.class);
	private static int NOT_FOUND = -1;
	private static int NO_CHARACTER = 0;
	
	@Value("${config.ts}")
	private int ts;

	@Value("${config.apikey}")
	private String apikey;
	
	@Value("${config.hash}")
	private  String hash;

	RestTemplate restTemplate = null;
	
	/***
	 * Constructor
	 */
	public MarvelServiceImp() {
		restTemplate = new RestTemplate();
	}
	
	/***
	 * @see
	 */
	@Override
	public CharacterDataWrapper getCharacters() {
		String url = "https://gateway.marvel.com/v1/public/characters?ts=" + ts + "&apikey=" + apikey + "&hash=" + hash;
		LOG.info("Get the Character data wrapper");
		return restTemplate.getForObject(url, CharacterDataWrapper.class);
	}


	/***
	 * @see
	 */
	@Override
	public ComicDataWrapper getComics(int character) {
		String url = "https://gateway.marvel.com/v1/public/comics?characters=" + character + "&ts=" + ts + "&apikey=" + apikey + "&hash=" + hash;
		LOG.info("Get the Comic data wrapper for the collaborator " + character);
		return restTemplate.getForObject(url, ComicDataWrapper.class);
	}


	/***
	 * @see
	 */
	@Override
	public Colaborator getColaboratorInfo(String character) {
		LOG.info("Get Collaborator info");
		Colaborator colaborator = new Colaborator();
        int characterId = NO_CHARACTER;
		if(character.equals(CharacterEnum.ironman.name())) {
			characterId = CharacterEnum.ironman.getValor();
		}else if(character.equals(CharacterEnum.capamerica.name())) {
			characterId = CharacterEnum.capamerica.getValor();
		}
		ArrayList<Comic> comicList = new ArrayList<>();
		if(characterId != NO_CHARACTER) {
			ComicDataWrapper comicDataWrapper = getComics(characterId);		
			comicList = comicDataWrapper.getData().getResults();
		}
		
		ArrayList<CreatorItem> creatorItemList = null;
		for(Comic comic : comicList) {

			// get creator item list from comic
			creatorItemList = comic.getCreators().getItems();
			
			// filter only colorist, editor and writer creators
			creatorItemList.stream().filter(creatorItemFilter -> 
					creatorItemFilter.getRole().equals(RoleEnum.COLORIST.getValue()) 
					|| creatorItemFilter.getRole().equals(RoleEnum.EDITOR.getValue()) 
					|| creatorItemFilter.getRole().equals(RoleEnum.WRITER.getValue())
				)  // iterate the filtered list and add to your collection
				.collect(Collectors.toList()).forEach(creatorItem ->{
					String filterName = creatorItem.getName();
					if(creatorItem.getRole().equals(RoleEnum.COLORIST.getValue()) && colaborator.getColorists().indexOf(filterName) == NOT_FOUND) {
						colaborator.getColorists().add(filterName);
					}else if(creatorItem.getRole().equals(RoleEnum.EDITOR.getValue()) && colaborator.getEditors().indexOf(filterName) == NOT_FOUND) {
						colaborator.getEditors().add(filterName);
					}else if(creatorItem.getRole().equals(RoleEnum.WRITER.getValue()) && colaborator.getWriters().indexOf(filterName) == NOT_FOUND) {
						colaborator.getWriters().add(filterName);
					}
					
				});
		}
		creatorItemList = null;
		return colaborator;
	}
	
}
