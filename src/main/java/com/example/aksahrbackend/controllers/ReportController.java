package com.example.aksahrbackend.controllers;
import com.example.aksahrbackend.models.AnswersModel;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.services.AnswersServiceInterface;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ReportController {

    @Autowired
    private AnswersServiceInterface answersServiceInterface;
    @Autowired
    ServletContext servletContext;

    private final TemplateEngine templateEngine;

    public ReportController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }


    //    @PostMapping("/generatePdfFile")

//    @RequestMapping("/get-answers")
    @GetMapping("report/{id}")
    public ResponseEntity<?> getAnswers(@PathVariable("id") long id,HttpServletRequest request, HttpServletResponse response) {

        try{
            System.out.println(id);
            AnswersModel answer= new AnswersModel();
            answer.APPLICANT_ID = id;
            GenericResponse<List<AnswersModel>> answersModels = this.answersServiceInterface.getAnswers(answer);

            WebContext context = new WebContext(request, response, servletContext);

            context.setVariable("data", answersModels.getData());

            String orderHtml = templateEngine.process("applicant", context);

            ByteArrayOutputStream target = new ByteArrayOutputStream();

               ConverterProperties converterProperties = new ConverterProperties();
               converterProperties.setBaseUri("http://localhost:8081");
            HtmlConverter.convertToPdf(orderHtml, target,converterProperties);

            byte[] bytes = target.toByteArray();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=applicant.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(bytes);
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<> ("99",e.getMessage(), null));
        }
    }
}