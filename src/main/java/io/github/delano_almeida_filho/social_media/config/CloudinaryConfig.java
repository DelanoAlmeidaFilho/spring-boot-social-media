package io.github.delano_almeida_filho.social_media.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {
    @Value("${api.upload.cloudinary.name}")
    private String name;

    @Value("${api.upload.cloudinary.key}")
    private String key;

    @Value("${api.upload.cloudinary.secret}")
    private String secret;

    @Bean
    public Cloudinary getCloudinary() {
        Map<String, Object> config = new HashMap<>();

        config.put("cloud_name", name);
        config.put("api_key", key);
        config.put("api_secret", secret);
        config.put("secure", true);

        return new Cloudinary(config);
    }
}
