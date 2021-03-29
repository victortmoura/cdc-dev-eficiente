package br.com.deveficiente.apicdc.detalhelivro;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class LocalUploader implements Uploader {

	@Override
	public String upload(MultipartFile file) {
		System.out.println("Enviando arquivo");
		return "http://s3.amazon.com"+file.getOriginalFilename();
	}

}
