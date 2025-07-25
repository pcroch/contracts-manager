package api.contractManager.controller.template.v1;

import api.contractManager.service.PingService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/v1/pingController")
public class PingControllerV1 {

    private static final Logger log = LoggerFactory.getLogger(PingControllerV1.class);

    private final PingService pingService;

    public PingControllerV1(PingService pingService) {
        this.pingService = pingService;
    }

    @RequestMapping("/ping")
    @GetMapping(value = "/url", produces = "application/json")
    public ResponseEntity<String> getPing() {
        HttpHeaders headers = new HttpHeaders();
        log.debug("Log happened");
        headers.add("Custom-Header", this.getClass().getSimpleName() + " endpoints has been pinged");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .headers(headers)
                .body(pingService.getPingBody());
    }
}
