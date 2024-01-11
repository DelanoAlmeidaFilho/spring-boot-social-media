package io.github.delano_almeida_filho.social_media.providers.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import io.github.delano_almeida_filho.social_media.providers.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile file) {
        try {
            return (String) this.cloudinary.uploader().upload(file.getBytes(), Map.of()).get("url");
        } catch (IOException e) {
            throw new RuntimeException("Não foi possivel fazer upload do arquivo!");
        }
    }

    @Override
    public void delete(String url) {

        try {
            this.cloudinary.uploader().destroy(extractPublicId(url), Map.of());
        } catch (IOException e) {
            throw new RuntimeException("Não foi possivel fazer deleção do arquivo!");
        }
    }

    private String extractPublicId(String imageUrl) {

        int lastSlashIndex = imageUrl.lastIndexOf('/');

        String publicIdWithExtension = imageUrl.substring(lastSlashIndex + 1);

        int lastDotIndex = publicIdWithExtension.lastIndexOf('.');

        String publicId = publicIdWithExtension.substring(0, lastDotIndex);

        return publicId;
    }
}