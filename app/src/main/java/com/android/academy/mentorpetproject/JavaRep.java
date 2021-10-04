package com.android.academy.mentorpetproject;

import java.util.ArrayList;
import java.util.List;

public class JavaRep {

    List<Repository.OrderDetail> getList(){
        List<Repository.OrderDetail> list = new ArrayList<>();
        list.add(getReturnedOrder());
        list.add(getNotReturnedOrder());
        list.add(getReturnedOrder());
        list.add(getReturnedOrder());
        list.add(getReturnedOrder());
        list.add(getNotReturnedOrder());
        list.add(getNotReturnedOrder());
        list.add(getReturnedOrder());
        list.add(getNotReturnedOrder());
        list.add(getReturnedOrder());
        list.add(getReturnedOrder());
        list.add(getReturnedOrder());
        list.add(getNotReturnedOrder());
        list.add(getReturnedOrder());
        list.add(getReturnedOrder());
        return list;
    }


    Repository.OrderDetail getReturnedOrder(){
        return new Repository.OrderDetail
                ("28 вересня 2021","L123456788","$568.52",true);
    }

    Repository.OrderDetail getNotReturnedOrder(){
        return new Repository.OrderDetail("28 вересня 2021","L123456788","$568.52",false);
    }

}
