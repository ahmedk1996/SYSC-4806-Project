package Pack;

import javax.persistence.*;
import java.util.*;

@Entity
public class Student {
    @Id
    private Integer id;

    private String name;

    private Integer projectId;

    private String program;

    public Student(){

    }

    public Student(String name, Integer id, String program){
        this.name = name;
        this.id = id;
        this.program = program;
        this.projectId = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
