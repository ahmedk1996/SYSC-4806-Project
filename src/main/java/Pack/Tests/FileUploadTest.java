package Pack.Tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import Pack.serviceForStorage;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FileUploadTest{

    @Autowired
    private MockMvc mvc;

    @MockBean
    private serviceForStorage storageService;


    @Test
    public void shouldSaveUploadedFile() throws Exception {
        MockMultipartFile fileMock = new MockMultipartFile("file", "UploadTest.txt",
                "text/plain", "Spring Framework".getBytes());
        this.mvc.perform(fileUpload("/upload").file(fileMock)).andExpect(status().isFound()).andExpect(header().string("Location", "/upload"));

        then(this.storageService).should().store(fileMock);
    }



}
