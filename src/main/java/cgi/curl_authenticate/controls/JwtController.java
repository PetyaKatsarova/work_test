package cgi.curl_authenticate.controls;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class JwtController {

    @GetMapping("/get-jwt-token")
    @ResponseBody
    public ResponseEntity<String> getJwtToken() {
        try {
            String url = "https://auth.trackunit.com/token";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("Authorization", "Basic MG9hOTQzaDkxNGVoRlVPQ1MzNTc6T3Y0OGlvX1dCcmVMaDU0YWRnQUM4dHFFN1QtUVFDZDRoVXFwazFaZQ==");
            headers.add("Cookie", "JSESSIONID=C6040AE23363D07C3E22244AC2B780A2; JSESSIONID=82FF41869E5057E3C5D2B8C108DF2600");

            // Define the request body
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "password");
            body.add("username", "TU-API-10095-7");
            body.add("password", "86mu)rwiZb#qYuaT");


            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);
            RestTemplate restTemplate = new RestTemplate();

            // Send the POST request and get the response
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                String jwtToken = response.getBody();
                return ResponseEntity.ok("Bearer " + jwtToken);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve JWT token");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
