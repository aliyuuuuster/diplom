package ru.aliia.userapp.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.aliia.userapp.services.PredictService;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Controller
@RequestMapping("/images")
public class PredictController {

    PredictService predictService;

    @GetMapping("/tune")
    public String getTunePage() {
        return "tune";
    }

    @GetMapping("/predict")
    public String getPredictPage() {
        return "predict";
    }

    @GetMapping("/upload")
    public String getUploadPage() {
        return "upload";
    }

    @PostMapping("/predict")
    public String predict(@RequestParam("file") MultipartFile multipart,
                                          Model model) {
        model.addAttribute("html", predictService.predict(multipart));
        model.addAttribute("file", "/files/" + multipart.getOriginalFilename());
        return "result";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipart) {
        predictService.upload(multipart);
        return "redirect:/upload";
    }

    @PostMapping("/tune")
    @ResponseBody
    public String tune(@RequestParam("file") MultipartFile multipart) {
        predictService.tune(multipart);
        return "redirect:/tune";
    }

}
