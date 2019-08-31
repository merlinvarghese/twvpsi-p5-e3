package com.tw.vapasi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Distance.centimeter;
import static com.tw.vapasi.Distance.meter;
import static com.tw.vapasi.Distance.kilometer;


class DistanceTest
{
    @Test
    void expect1mEquals1cm()
    {
        Assertions.assertEquals(meter(1),centimeter(100));
    }
    @Test
    void expect100cmEquals100cm()
    {
        Assertions.assertEquals(centimeter(1),centimeter(1));
    }
    @Test
    void expect100cmEquals1m()
    {
        Assertions.assertEquals(centimeter(100),meter(1));
    }
    @Test
    void expect100000cmEquals1km()
    {
        Assertions.assertEquals(centimeter(100000),kilometer(1));
    }
    @Test
    void expect1mEquals1m()
    {
        Assertions.assertEquals(meter(1),meter(1));
    }
    @Test
    void expect3000mEquals3km()
    {
        Assertions.assertEquals(meter(3000),kilometer(3));
    }
    @Test
    void expect1kmEquals100000cm()
    {
        Assertions.assertEquals(kilometer(1),centimeter(100000));
    }
    @Test
    void expect2kmEquals2000m()
    {
        Assertions.assertEquals(kilometer(2),meter(2000));
    }
    @Test
    void expect100kmEquals100km()
    {
        Assertions.assertEquals(kilometer(100),kilometer(100));
    }



}
