package com.sdp.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	void uploadFile(MultipartFile file);
}