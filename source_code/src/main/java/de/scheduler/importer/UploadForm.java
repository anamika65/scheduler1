package de.scheduler.importer;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {

    private String name = null;

    private MultipartFile file = null;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public MultipartFile getFile() {
        return file;
    }
    public void setFile(MultipartFile file) {
        this.file = file;
        this.name = file.getOriginalFilename();
    }
}

