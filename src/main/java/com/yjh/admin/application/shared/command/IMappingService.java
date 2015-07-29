package com.yjh.admin.application.shared.command;

import java.util.List;

/**
 * Created by yjh on 2015/7/29.
 */
public interface IMappingService {
    <A, B> List<B> mapAsList(List<A> var1, Class<B> var2);

    <A, B> Object map(A sourceObject, Class<B> destinationClass, boolean cycles);
}