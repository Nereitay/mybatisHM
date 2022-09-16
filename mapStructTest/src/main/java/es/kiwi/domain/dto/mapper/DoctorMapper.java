package es.kiwi.domain.dto.mapper;

import es.kiwi.domain.Doctor;
import es.kiwi.domain.DoctorPatientSummary;
import es.kiwi.domain.Education;
import es.kiwi.domain.Patient;
import es.kiwi.domain.dto.DoctorDTO;
import es.kiwi.util.Validator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import javax.xml.bind.ValidationException;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;


@Mapper(uses = {PatientMapper.class, Validator.class}, imports = {LocalDateTime.class, UUID.class})
/*
由于表达式只是字符串，我们必须在表达式中指定使用的类。但是这里的表达式并不是最终执行的代码，只是一个字母的文本值。
因此，我们要在 @Mapper 中添加 imports = {LocalDateTime.class, UUID.class}
 */
//@Mapper(uses = {PatientMapper.class}, componentModel = "spring", imports = {LocalDateTime.class, UUID.class})
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    //如果source取值为null，则会使用默认值
    @Mappings({
            //我们将id硬编码为-1
            //@Mapping(target = "id", constant = "-1"),
            @Mapping(source = "speciality", target = "specialization", defaultValue = "Information not available")
    })
    DoctorDTO toDto(Doctor doctor);

    @Mappings({
            @Mapping(source = "patientDTOList", target = "patients"),
            @Mapping(source = "specialization", target = "speciality")
    })
    Doctor toModel(DoctorDTO doctorDto);

    /**
     * @InheritConfiguration 如果对一个方法添加 @InheritConfiguration 注解，MapStruct会检索其它的已配置方法，寻找可用于当前方法的注解配置。
     * 一般来说，这个注解都用于mapping方法后面的update方法
     * @InheritInverseConfiguration 两个方法的配置不会是完全相同的，实际上，它们应该是相反的。
     * 将Model 转为 DTO，以及将 DTO 转为 Model——映射前后的字段相同，但是源属性字段与目标属性字段是相反的
     * 我们可以在第二个方法上使用@InheritInverseConfiguration注解，避免写两遍映射配置
     * @param doctorDTO
     * @param doctor
     */
    @InheritConfiguration
    void updateModel(DoctorDTO doctorDTO, @MappingTarget Doctor doctor);

    /**
     * 如果 Education 类和 Doctor 类包含同名的字段，我们必须让映射器知道使用哪一个，否则它会抛出一个异常。
     * 举例来说，如果两个模型都包含一个id字段，我们就要选择将哪个类中的id映射到DTO属性中
     *
     * @param doctor
     * @param education
     * @return
     */
    @Mappings({
            @Mapping(source = "doctor.speciality", target = "specialization"),
            @Mapping(source = "education.degreeName", target = "degree")
    })
    DoctorDTO toDtoFromMultipleSources(Doctor doctor, Education education);

    @Mappings({
            @Mapping(source = "speciality", target = "specialization"),
            @Mapping(source = "patients", target = "patientDTOList")
    })
    DoctorDTO toDtoWithPatient(Doctor doctor);


    @Mappings({
            @Mapping(target = "externalId", expression = "java(UUID.randomUUID().toString())"),
            @Mapping(source = "doctor.availability", target = "availability", defaultExpression = "java(LocalDateTime" +
                    ".now())"),
            @Mapping(source = "doctor.patients", target = "patientDTOList"),
            @Mapping(source = "doctor.speciality", target = "specialization")
    })
    DoctorDTO toDtoWithExpression(Doctor doctor);

    /**
     * 添加自定义方法
     * 通过default方法直接实现一个映射。然后我们可以通过实例直接调用该方法，没有任何问题
     * @param doctor
     * @param education
     * @return
     */
    default DoctorPatientSummary toDoctorPatientSummary(Doctor doctor, Education education) {

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


    /**
     * MapStruct提供了对异常处理的支持
     * 如果映射前后的一对属性的类型与Validator中的方法出入参类型一致，那该字段映射时就会调用Validator中的方法，所以该方式请谨慎使用
     * @param doctor
     * @return
     * @throws ValidationException
     */
    @Mapping(source = "doctor.patients", target = "patientDTOList")
    @Mapping(source = "doctor.speciality", target = "specialization")
    DoctorDTO toDtoThrowException(Doctor doctor) throws ValidationException;



}
