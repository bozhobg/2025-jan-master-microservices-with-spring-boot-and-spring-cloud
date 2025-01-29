package com.in28minutes.spring.learnspringframework.enterprise.exapmle.business;

import com.in28minutes.spring.learnspringframework.enterprise.exapmle.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessService {

//    Field injction
//    @Autowired
    private DataService dataService;

//    Ctor injection -> @Autowired recognized if on field for ctor DI!
//
    @Autowired
    public BusinessService(DataService dataService) {
        super();
        System.out.println("Ctor injection!");
        this.dataService = dataService;
    }

//    Setter injection
//    @Autowired
    public void setDataService(DataService dataService) {
        System.out.println("Setter injection!");
        this.dataService = dataService;
    }

    public long calculateSum() {
        List<Integer> data = dataService.getData();
        return data.stream().reduce(Integer::sum).get();
    }
}
