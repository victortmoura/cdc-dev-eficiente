package br.com.deveficiente.apicdc.detalhelivro;

import org.springframework.web.multipart.MultipartFile;

@FunctionalInterface
public interface Uploader {

	String upload(MultipartFile file);
	
}
