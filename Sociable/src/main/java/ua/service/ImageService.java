package ua.service;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Image;
import ua.entity.form.ImageSaveForm;

public interface ImageService {

	Page<Image> findAll(Pageable pageable);

	void saveImage(ImageSaveForm form);
	
	void saveAvatar(ImageSaveForm form, String username);
	
	Page<Image> findAllByPrincipal(Pageable pageable, Principal principal);

	int getAvatar(String name);
}
