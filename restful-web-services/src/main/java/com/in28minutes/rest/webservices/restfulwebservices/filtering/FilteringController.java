package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    //    field1, field2
    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        return getMappingJacksonValueForObjectFilteringOutPropertiesExcept(
                someBean, "field1", "field2"
        );

//        static filtering:
//        using @JsonIgnore on bean's field lvl OR @JsonIgnoreProperties({"fieldName1", "fieldName2"}) on bean class
//        return someBean;
    }

    //    field2, field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = List.of(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value3", "value4", "value5")
        );

        return getMappingJacksonValueForObjectFilteringOutPropertiesExcept(
                list, "field2", "field3"
        );
//        using static bean annotations
//        return List.of(
//                new SomeBean("value1", "value2", "value3"),
//                new SomeBean("value3", "value4", "value5")
//                );
    }

    private MappingJacksonValue getMappingJacksonValueForObjectFilteringOutPropertiesExcept(
            Object object, String... propertyNames
    ) {

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(object);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(propertyNames);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
