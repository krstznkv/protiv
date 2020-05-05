package com.example.demo.entity.platov;

import lombok.Data;

@Data
public class PlatovRequest {
    String from;
   String to;
   String  dep_date;
   String  ret_date;
   int adults;
    int children;

}
