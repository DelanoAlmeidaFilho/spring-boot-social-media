package io.github.delano_almeida_filho.social_media.providers;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    public String upload(MultipartFile file);

    public void delete(String url);
}
