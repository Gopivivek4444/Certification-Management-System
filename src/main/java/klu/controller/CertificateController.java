package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import klu.model.Certificate;
import klu.model.CertificateManager;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateManager certificateManager;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCertificate(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") String userId,
            @RequestParam("name") String name,
            @RequestParam("status") String status,
            @RequestParam("startDate") String startDate,
            @RequestParam("expiryDate") String expiryDate) {
        String result = certificateManager.uploadCertificate(file, userId, name, status, startDate, expiryDate);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File upload failed");
    }


    @GetMapping("/view")
    public ResponseEntity<List<Certificate>> viewCertificates(@RequestParam("userId") String userId) {
        if (userId == null || userId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<Certificate> certificates = certificateManager.getUserCertificates(userId);
        if (certificates.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(certificates);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadCertificate(@PathVariable Long id) {
        Certificate certificate = certificateManager.getCertificateById(id);
        if (certificate != null && certificate.getImage() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + certificate.getName());
            headers.add("Content-Type", certificate.getFileType()); // Set MIME type
            return new ResponseEntity<>(certificate.getImage(), headers, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
    @GetMapping("displaycertpdf")
    public ResponseEntity<byte[]> displaycertPdf(HttpServletRequest request) throws Exception {
    	String id  = request.getParameter("userId");
      Certificate product = certificateManager.displayCertificate(id);
         
         // Assuming the PDF file is stored as a Blob in the database
      byte[] pdfBytes = product.getImage();
         
      return ResponseEntity.ok()
                 .contentType(MediaType.APPLICATION_PDF)
                 .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"certificate.pdf\"") // Inline view in browser
                 .body(pdfBytes);
    }
    
    @GetMapping("/track")
    public String trackCertificate(@RequestParam("userId") String userId, HttpServletRequest request) {
        List<Certificate> certificates = certificateManager.getUserCertificates(userId);
        if (!certificates.isEmpty()) {
            request.setAttribute("certificate", certificates.get(0)); // Pass first certificate
        }
        return "trackCertificate";
    }


}
