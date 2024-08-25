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
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowCredentials(true)
                        .allowedMethods(HttpMethod.OPTIONS.name(), HttpMethod.HEAD.name(), HttpMethod.DELETE.name(), HttpMethod.POST.name(), HttpMethod.GET.name())
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }
}
