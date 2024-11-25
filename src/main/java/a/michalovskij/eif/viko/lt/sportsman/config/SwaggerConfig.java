package a.michalovskij.eif.viko.lt.sportsman.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public GroupedOpenApi publicApi() {
                return GroupedOpenApi.builder()
                        .group("public")  // Sukuriame grupę su pavadinimu "public" - Создаем группу с именем "public"
                        .pathsToMatch("/**")  // Nustatome, kad visi keliai būtų įtraukti į grupę - Устанавливаем, чтобы все пути были включены в группу
                        .build();
        }
}
