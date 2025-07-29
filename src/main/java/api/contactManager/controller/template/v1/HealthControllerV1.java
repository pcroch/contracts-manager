package api.contactManager.controller.template.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HealthControllerV1 extends BaseRestController {

    @GetMapping("/health")
    public ResponseEntity<Map<String,String>> health() {
        return ResponseEntity
                .status(HttpStatus.OK).body(Map.of("Status", "Up"));
    }

}
