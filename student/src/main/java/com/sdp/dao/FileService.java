package com.sdp.dao;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface FileService {

	ModelAndView uploadFile(MultipartFile file);
}