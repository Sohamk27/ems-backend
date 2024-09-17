package com.soham.ems_backend.service.impl;

import com.soham.ems_backend.dto.EmployeeDto;
import com.soham.ems_backend.entity.Employee;
import com.soham.ems_backend.exception.ResourceNotFoundException;
import com.soham.ems_backend.mapper.EmployeeMapper;
import com.soham.ems_backend.repository.EmployeeRepository;
import com.soham.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedemployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedemployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with given ID not found" + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
