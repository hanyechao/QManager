package com.company.project.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ProjectForTestcase  extends Project{

    @Getter
    @Setter
    private List<Testcase> params ; 
}
