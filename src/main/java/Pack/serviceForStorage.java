package Pack;

import org.springframework.core.io.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Path;
import java.util.stream.Stream;


public interface serviceForStorage {


        void init();

        void store(MultipartFile file);

        Stream<Path> loadAll();

        Path load(String filename);

        Resource loadAsResource(String filename);

        void deleteAll();

    }

