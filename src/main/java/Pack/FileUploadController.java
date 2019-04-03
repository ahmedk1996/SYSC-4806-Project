package Pack;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class FileUploadController {

    private final serviceForStorage serviceStorage;

    @Autowired
    public FileUploadController(serviceForStorage serviceStorage) {
        this.serviceStorage = serviceStorage;
    }


    @GetMapping("/upload")
    public String listUploadedFiles(Model model) throws IOException, ParseException {


        LocalDateTime now = LocalDateTime.now();
        String s = now.toString().substring(0, 10).replace('-', '/');
        String f = now.getHour() + ":" + now.getMinute();
        String l = s + " " + f;
        Date dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(l);

        System.out.println("Current time is:" + dtf);

        if (dtf.compareTo(CoordinatorController.date) > 0){
            return "OverdueError";
        } else {
            model.addAttribute("files", serviceStorage.loadAll().map(
                    path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                            "serveFile", path.getFileName().toString()).build().toString())
                    .collect(Collectors.toList()));

            return "uploadTemplate";
        }


    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = serviceStorage.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {



        serviceStorage.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/upload";
    }



}
