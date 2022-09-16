package es.kiwi.domain.dto.mapper;

import es.kiwi.domain.Patient;
import es.kiwi.domain.dto.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDTO toDto(Patient patient);

    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "dd/MMM/yyyy")
    Patient fromDto(PatientDTO patientDTO);

    // 数字格式转换示例
    //@Mapping(source = "price", target = "price", numberFormat = "$#.00")
}
