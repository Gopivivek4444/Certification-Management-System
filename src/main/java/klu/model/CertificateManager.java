package klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import klu.repository.CertificateRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class CertificateManager {

    @Autowired
    private CertificateRepository certificateRepository;

    public String uploadCertificate(MultipartFile file, String userId, String name, String status, String startDate, String expiryDate) {
        try {
            Certificate certificate = new Certificate();
            certificate.setName(name);
            certificate.setStatus(status);
            certificate.setUserId(userId);
            certificate.setFileType(file.getContentType());
            certificate.setImage(file.getBytes());
            certificate.setStartDate(LocalDate.parse(startDate));
            certificate.setExpiryDate(LocalDate.parse(expiryDate));
            certificateRepository.save(certificate);
            return "Certificate uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading certificate: " + e.getMessage();
        }
    }


    public List<Certificate> getUserCertificates(String userId) {
        return certificateRepository.findByUserId(userId);
    }

    public Certificate getCertificateById(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    public Certificate displayCertificate(String id) {
        return certificateRepository.findByUserId(id).get(0);
    }
}
