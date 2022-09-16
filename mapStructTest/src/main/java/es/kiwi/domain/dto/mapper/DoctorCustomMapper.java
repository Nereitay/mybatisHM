package es.kiwi.domain.dto.mapper;

import es.kiwi.domain.Doctor;
import es.kiwi.domain.DoctorPatientSummary;
import es.kiwi.domain.Education;
import es.kiwi.domain.Patient;
import es.kiwi.domain.dto.DoctorDTO;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 创建自定义映射器
 * 前面我们一直是通过接口来设计映射器功能，其实我们也可以通过一个带 @Mapper 的 abstract 类来实现一个映射器。
 * MapStruct也会为这个类创建一个实现，类似于创建一个接口实现
 */
@Mapper
public abstract class DoctorCustomMapper {

    public DoctorPatientSummary toDoctorPatientSummary(Doctor doctor, Education education) {

        return DoctorPatientSummary.builder()
                .doctorId(doctor.getId())
                .doctorName(doctor.getName())
                .patientCount(doctor.getPatients().size())
                .patientIds(doctor.getPatients()
                        .stream()
                        .map(Patient::getId)
                        .collect(Collectors.toList()))
                .institute(education.getInstitute())
                .specialization(education.getDegreeName())
                .build();
    }

    @BeforeMapping
    protected void validate(Doctor doctor) {
        if(doctor.getPatients() == null){
            doctor.setPatients(new ArrayList<>());
        }
    }

    @AfterMapping //注意lombok生成的builer不能正常生成
    protected void updateResult(@MappingTarget DoctorDTO doctorDto) {
        doctorDto.setName(doctorDto.getName().toUpperCase());
        doctorDto.setDegree(doctorDto.getDegree().toUpperCase());
        doctorDto.setSpecialization(doctorDto.getSpecialization().toUpperCase());
    }

    @Mapping(source = "doctor.patients", target = "patientDTOList")
    @Mapping(source = "doctor.speciality", target = "specialization")
    public abstract DoctorDTO toDoctorDto(Doctor doctor);


}


