package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class SecutityConfigurationApplication {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpsecu) throws Exception {
//
//        return httpsecu
//                //desactiver le protocole csrf pour ne pas bloquer les url
//                .csrf((csrf) -> csrf.disable())
//                // les autorisations
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/avis").authenticated()
//                        .anyRequest().permitAll())
//                .cors(Customizer.withDefaults())
//                //filtrer qui va permettre lautorisation du jeton ne garde pas les les informations
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                //sappui dessus pour authentifier lutilisateur
//                .authenticationProvider(authenticationProvider())
//                // bajouter le filtre qui permet lacces au jeton en permettan lacces a une endpoint quand tu es deja authentifie
//                .addFilterBefore(jwtSecurityFilter, UsernamePasswordAuthenticationFilter.class)
//                //construction du bean(class dinstanciation)
//                .build();
//
//   }

    // Configure CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowCredentials(true)
                        .allowedHeaders("*")
                        .allowedMethods(HttpMethod.OPTIONS.name(), HttpMethod.HEAD.name(), HttpMethod.DELETE.name(), HttpMethod.POST.name(), HttpMethod.GET.name())
                        .allowedOrigins("http://localhost:4200");
            }
        };

//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:4200") // Autoriser les requêtes depuis Angular
//                        .allowedMethods("*") // Autoriser toutes les méthodes HTTP
//                        .allowedHeaders("*") // Autoriser tous les en-têtes
//                        .allowCredentials(true); // Autoriser les cookies et les identifiants
//            }
//        };
    }
}
