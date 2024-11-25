package a.michalovskij.eif.viko.lt.sportsman.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Atidaryti visus kelius CORS
                .allowedOrigins("http://localhost:3000")  // Leidžiame prieigą iš vietinio serverio, kur veiks Swagger UI
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Leidžiame naudoti GET, POST, PUT, DELETE metodus
                .allowedHeaders("*");  // Leidžiame visus antraštės laukus
    }
}
