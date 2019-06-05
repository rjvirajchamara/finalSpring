package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.FileUpload;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class FileValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return FileUpload.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors){
        FileUpload fileUpload = (FileUpload) target;

        CommonsMultipartFile[] commonsMultipartFiles = fileUpload.getFiles();

        for(CommonsMultipartFile multipartFile : commonsMultipartFiles) {
            if(multipartFile.getSize() == 0) {
                errors.rejectValue("files", "missing.file");
            }
        }
    }

}