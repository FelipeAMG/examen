package com.example.examenp1.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.examenp1.demo.exception.ResourceNotFoundException;
import com.example.examenp1.demo.model.Language;
import com.example.examenp1.demo.repositories.LanguageRepository;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	LanguageRepository languageRepository;

	@Override
	public Language updateLanguage(Language language) {
		Optional<Language> languageDb = this.languageRepository.findById(language.getId());

		if (languageDb.isPresent()) {
			Language languageUpdate = languageDb.get();
			languageUpdate.setId(language.getId());
			languageUpdate.setCode(language.getCode());
			languageUpdate.setName(language.getName());

			return languageUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + language.getId());
		}
	}

	@Override
	public List<Language> getAllLanguage() {
		return this.languageRepository.findAll();
	}

	@Override
	public Language getLanguageById(long languageId) {
		Optional<Language> languageDb = this.languageRepository.findById(languageId);

		if (languageDb.isPresent()) {
			return languageDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + languageId);
		}
	}

	@Override
	public void deleteLanguage(long languageId) {
		Optional<Language> languageDb = this.languageRepository.findById(languageId);

		if (languageDb.isPresent()) {
			this.languageRepository.delete(languageDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + languageId);
		}
	}
}
