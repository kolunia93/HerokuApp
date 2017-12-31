package ua.service.implementation;

import java.io.File;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Image;
import ua.entity.User;
import ua.entity.form.ImageSaveForm;
import ua.repository.ImageRepository;
import ua.repository.UserRepository;
import ua.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private FileWriterImpl fileWriter;
	
	public Page<Image> findAll(Pageable pageable) {
		System.out.println(pageable.getPageNumber());
		return imageRepository.findAll(pageable);
	}
	
	@Override
	@Transactional
	public void saveImage(ImageSaveForm form) {	
		Image image=new Image();
		User user=userRepository.findByUsername(form.getName());
		image.setComment(form.getComment());
		image.setDate(LocalDateTime.now());
		image.setName(form.getName());
		image.setUser(user);
		imageRepository.saveAndFlush(image);
		String path=form.getName()+ File.separator+form.getFolder();
		if (fileWriter.write(path, form.getFile(),image.getId() )) {
			if(user.getVersion()==null)user.setVersion(0);
			else user.setVersion(user.getVersion()+1);
			user.setAvatar(imageRepository.findAllByPrincipal(user.getUsername()).size());
			userRepository.save(user);
		}
	}
	
	@Override
	@Transactional
	public void saveAvatar(ImageSaveForm form, String username) {
		User user=userRepository.findByUsername(username);
		Image image=new Image();
		image.setComment(form.getComment());
		image.setDate(LocalDateTime.now());
		image.setName(form.getName());
		image.setUser(user);
		imageRepository.saveAndFlush(image);
		String path=username+ File.separator+form.getFolder();
		if (fileWriter.write(path, form.getFile(),image.getId() )) {		
			if(user.getVersion()==null) {user.setVersion(0);}
			else { user.setVersion(user.getVersion()+1);}
				user.setAvatar(image.getId());
				userRepository.saveAndFlush	(user);			
		}
	}

	public Page<Image> findAllByPrincipal(Pageable pageable, Principal principal) {
		
		return imageRepository.findPagebleByUserName(principal.getName(), pageable);
	}

	public int getAvatar(String username) {
		int size=0;
		List<Image>images=imageRepository.findAllByPrincipal(username);
		for (Image i:images ) {
			if (size<i.getId()) {
				size=i.getId();
			}
		}
		return size;
	}

	

	





	
}
