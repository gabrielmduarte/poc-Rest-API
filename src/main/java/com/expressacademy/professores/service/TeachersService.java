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
    private TeachersRepository repository;

    public void create(TeachersRequest request) {
        TeacherEntity teachersEntity = teacherMapper.toEntity(request);
        teachersEntity.setActive(true);

        repository.save(teachersEntity);
    }

    public List<TeacherResponse> findAll() {
        return repository.findByActiveTrue()
                .stream()
                .map(entity -> teacherMapper.toResponse(entity))
                .collect(Collectors.toList());
    }

    public TeacherResponse findById(Long id) {
        TeacherEntity entity = repository.findByIdAndActiveTrue(id)
                                            .orElseThrow(TeacherNotFoundException::new);

        return teacherMapper.toResponse(entity);
    }

    public void update(Long id, TeachersRequest request) {
        TeacherEntity entity = repository.findByIdAndActiveTrue(id)
                                            .orElseThrow(TeacherNotFoundException::new);

        AddressEntity address = new AddressEntity();

        address.setAddress(request.getPaymentInfo().getAddress().getAddress());
        address.setCity(request.getPaymentInfo().getAddress().getCity());
        address.setPostalCode(request.getPaymentInfo().getAddress().getPostalCode());
        address.setState(request.getPaymentInfo().getAddress().getState());

        BankDataEntity bankData = new BankDataEntity();

        bankData.setAccountNumber(request.getPaymentInfo().getBankData().getAccountNumber());
        bankData.setAgency(request.getPaymentInfo().getBankData().getAgency());
        bankData.setBank(request.getPaymentInfo().getBankData().getBank());
        bankData.setCode(request.getPaymentInfo().getBankData().getCode());
        bankData.setType(request.getPaymentInfo().getBankData().getType());

        PaymentInfoEntity paymentInfo = new PaymentInfoEntity();

        paymentInfo.setEmail(request.getPaymentInfo().getEmail());
        paymentInfo.setCpf(request.getPaymentInfo().getCpf());
        paymentInfo.setBankData(bankData);
        paymentInfo.setAddress(address);

        entity.setName(request.getName());
        entity.setPaymentInfo(paymentInfo);

        repository.save(entity);
    }

    public void delete(Long id) {
        TeacherEntity entity = repository.findByIdAndActiveTrue(id)
                .orElseThrow(TeacherNotFoundException::new);

        entity.setActive(false);

        repository.save(entity);
    }
}
