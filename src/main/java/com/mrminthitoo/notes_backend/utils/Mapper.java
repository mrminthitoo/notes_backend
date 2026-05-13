package com.mrminthitoo.notes_backend.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass){
        return source.stream()
                .map(element->this.modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <D> D map(Object source, Class<D> destinationType){
        return this.modelMapper.map(source, destinationType);
    }
//
//    public <S, T> PageDto<T> mapPageToPageDto(Page<S> soruce, Class<T> targetClass){
//        PageDto<T> pageDto = new PageDto<>();
//        pageDto.setContent(this.mapList(soruce.getContent(), targetClass));
//        pageDto.setPageable(this.modelMapper.map(soruce.getPageable(), PageableDto.class));
//        pageDto.setTotalPages(soruce.getTotalPages());
//        pageDto.setTotalElements(soruce.getTotalElements());
//        pageDto.setNumberOfElements(soruce.getNumberOfElements());
//        pageDto.setSize(soruce.getSize());
//        pageDto.setNumber(soruce.getNumber());
//        pageDto.setSort(this.modelMapper.map(soruce.getSort(), SortDto.class));
//        pageDto.setFirst(soruce.isFirst());
//        pageDto.setLast(soruce.isLast());
//        pageDto.setEmpty(soruce.isEmpty());
//        return pageDto;
//    }

    public ModelMapper getModelMapper(){
        return this.modelMapper;
    }

}
