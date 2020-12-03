package com.medway.prescriptionservice.controller;

import com.medway.prescriptionservice.model.MedicineModel;
import com.medway.prescriptionservice.model.Prescriptions;
import com.medway.prescriptionservice.repository.DataRepository;
import com.medway.prescriptionservice.service.AWSS3ServiceImpl;
import com.medway.prescriptionservice.service.PrescriptionService;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1")
public class Controller {
    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private AWSS3ServiceImpl service;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DataRepository dr;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadToLocalFileSystem(@RequestParam("file") MultipartFile file, @RequestParam("username") String username, @RequestParam("prescriptionId") Long psid) throws TikaException, SAXException, IOException {

        File f = service.convertMultiPartFileToFile(file);
        String preUrl = service.uploadFile(f);

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(f);
        ParseContext pcontext = new ParseContext();
        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(inputstream, handler, metadata,pcontext);
        f.delete();

        String[] data = handler.toString().trim().split("\n");
        String med = "";
        List<String> medicines = new ArrayList<>();
        for (String x: data) {
            String temp = x.split(" ")[3];
            medicines.add(temp);
            med = med+temp+" ";
        }
        med = med.trim();
        Prescriptions p = new Prescriptions(psid, handler.toString(),medicines, preUrl);

        String url = "http://localhost:8811/api/v1/blogs/raw2";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("MedicineNames", med);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<List> response = restTemplate.postForEntity( url, request , List.class );
        prescriptionService.addPrescription(username,p);

//        return ResponseEntity.ok(prescriptionService.addPrescription(username,p));
        return response;
    }

    @PostMapping("/search")
    public ResponseEntity<?> dummy(@RequestParam("mednames") List<String> medicine){
        for (String med: medicine
             ) {
            System.out.println(med);

        }
        ArrayList<MedicineModel> mm = new ArrayList<>();
        mm.add(new MedicineModel("Crocin",001, LocalDate.now(),LocalDate.now(),27,50,20,10));
        mm.add(new MedicineModel("Dolo",002, LocalDate.now(),LocalDate.now(),27,50,20,10));
        mm.add(new MedicineModel("Paracetamol",002, LocalDate.now(),LocalDate.now(),0,50,20,10));

        return new ResponseEntity(mm,HttpStatus.OK);
    }

        @GetMapping("/getPrescription/{username}")
        public ResponseEntity<?> getPrescriptionData(@PathVariable("username") String username){
            return ResponseEntity.ok(prescriptionService.getPrescription(username));
        }


    //@GetMapping("/get")
    //public ResponseEntity get() {

       // if(dr.findByUsername("rajni").isPresent()){
         //   dr.delete(dr.findByUsername("rajni").get());
        //}
        //dr.save(new PrescriptionData("rajni",new Prescriptions(134l,"dfsd", List.of("h1","hello"))));

      //  return new ResponseEntity(dr.findAll(), HttpStatus.FOUND);
    //}

}
