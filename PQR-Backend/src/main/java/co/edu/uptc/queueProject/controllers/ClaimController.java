package co.edu.uptc.queueProject.controllers;

import org.springframework.web.bind.annotation.RestController;
import co.edu.uptc.queueProject.models.Claim;
import co.edu.uptc.queueProject.services.ClaimService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.LinkedList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/claim")
public class ClaimController {

    ClaimService claimService = new ClaimService();

    @GetMapping("/getClaim")
    public ResponseEntity<Object> getClaim() {
        List<Claim> claims;

        claims = claimService.getClaim();
        return ResponseEntity.status(HttpStatus.OK).body(claims);
    }

    @PostMapping("addClaim")
    public ResponseEntity<Object> addOrder(@RequestBody Claim claim) {
        claimService.addClaim(claim);
        return ResponseEntity.status(HttpStatus.OK).body(claim);
    }

    @DeleteMapping("/deleteClaim")
    public ResponseEntity<Object> deleteOrder() {
        Claim claim = claimService.deleteClaim();
        return ResponseEntity.ok().body(claim);
    }

    @GetMapping("/firstClaim")
    public ResponseEntity<Object> getFirstClaim() {

        LinkedList<Claim> claims = claimService.getClaim();
        Claim lastClaim = claimService.firstClaim(claims);
        return ResponseEntity.ok().body(lastClaim);

    }
}
