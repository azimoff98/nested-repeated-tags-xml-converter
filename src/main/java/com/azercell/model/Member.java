package com.azercell.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Member {

    private String name;
    private ValueLevelOne value;



    @lombok.Data
    public static class ValueLevelOne{
        private Array array;

    }
    @lombok.Data
    public static class Array{
        private Member.Data data;
    }

    @lombok.Data
    public static class Data{
        private ValueLevelTwo value;

    }
    @lombok.Data
    public static class ValueLevelTwo{
        private Struct struct;
    }
    @lombok.Data
    public static class Struct {
        private List<MemberLevelTwo> member;

    }
    @lombok.Data
    public static class MemberLevelTwo{
        private String name;
        private ValueLevelThree value;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ValueLevelThree{
        private String string;
        private Integer i4;
    }
}
