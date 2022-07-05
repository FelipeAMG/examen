package com.example.examenp1.demo.service;

import java.util.List;

import com.example.examenp1.demo.model.Language;

public interface LanguageService {

	Language updateLanguage(Language language);
	
	List<Language> getAllLanguage();

	Language getLanguageById(long languageId);

	void deleteLanguage(long id);
}