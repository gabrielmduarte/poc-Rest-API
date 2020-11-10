package com.expressacademy.professores.service;

import com.expressacademy.professores.domain.*;
import com.expressacademy.professores.exception.TeacherNotFoundException;
import com.expressacademy.professores.mapper.TeachersMapper;
import com.expressacademy.professores.repository.TeachersRepository;
import com.expressacademy.professores.request.TeachersRequest;
import com.expressacademy.professores.response.TeacherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeachersService {

    @Autowired
    private TeachersMapper teacherMapper;

    @Autowired
    private TeachersRepository teacherRepository;

    public void create(TeachersRequest request) {
        TeacherEntity teacherEntity = teacherMapper.toEntity(request);
        teacherEntity.setActive(true);

        teacherRepository.save(teacherEntity);
    }

    public List<TeacherResponse> findAll() {
        return teacherRepository.findByActiveTrue()
                .stream()
                .map(entity -> teacherMapper.toResponse(entity))
                .collect(Collectors.toList());
    }

    public TeacherResponse findById(Long id) {
        TeacherEntity entity = teacherRepository.findByIdAndActiveTrue(id)
                                            .orElseThrow(TeacherNotFoundException::new);

        return teacherMapper.toResponse(entity);
    }

    public void update(Long id, TeachersRequest request) {
        TeacherEntity entity = teacherRepository.findByIdAndActiveTrue(id)
                                            .orElseThrow(TeacherNotFoundException::new);

        AddressEntity address = new AddressEntity();
        address.setState(request.getAddress().getState());
        address.setPostalCode(request.getAddress().getPostalCode());
        address.setCity(request.getAddress().getCity());
        address.setAddress(request.getAddress().getAddress());

        PaymentInfoEntity paymentInfo = new PaymentInfoEntity();
        paymentInfo.setBank(request.getPaymentInfo().getBank());
        paymentInfo.setAccountNumber(request.getPaymentInfo().getAccountNumber());
        paymentInfo.setAgency(request.getPaymentInfo().getAgency());
        paymentInfo.setType(request.getPaymentInfo().getType());

        entity.setAddress(address);
        entity.setPaymentInfo(paymentInfo);
        entity.setName(request.getName());
        entity.setCpf(request.getCpf());
        entity.setEmail(request.getEmail());

        teacherRepository.save(entity);
    }

    public void delete(Long id) {
        TeacherEntity entity = teacherRepository.findByIdAndActiveTrue(id)
                .orElseThrow(TeacherNotFoundException::new);

        entity.setActive(false);

        teacherRepository.save(entity);
    }

    public TeacherEntity findByIdAndReturnEntity(Long id) {
        return teacherRepository.findByIdAndActiveTrue(id)
                .orElseThrow(TeacherNotFoundException::new);
    }

}
