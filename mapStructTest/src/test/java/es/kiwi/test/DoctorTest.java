package es.kiwi.test;

import es.kiwi.domain.Doctor;
import es.kiwi.domain.Education;
import es.kiwi.domain.Patient;
import es.kiwi.domain.dto.DoctorDTO;
import es.kiwi.domain.dto.PatientDTO;
import es.kiwi.domain.dto.mapper.DoctorMapper;
import es.kiwi.domain.dto.mapper.PatientMapper;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorTest {

    /**
     * 基本映射
     */
    @Test
    public void test01() {

        Doctor doctorJason = Doctor.builder().id(1).name("Jason").build();

        DoctorDTO doctorDTOJason = DoctorMapper.INSTANCE.toDto(doctorJason);

        System.out.println("原始类型 doctor : " + doctorJason);
        System.out.println("转变后DTO后 ：" + doctorDTOJason);
    }

    /**
     * 不同属性名称
     */
    @Test
    public void test02() {
        Doctor doctorJason = Doctor.builder().id(1).name("Jason").speciality("A").build();

        DoctorDTO doctorDTOJason = DoctorMapper.INSTANCE.toDto(doctorJason);

        System.out.println("原始类型 doctor : " + doctorJason);
        System.out.println("转变后DTO后 ：" + doctorDTOJason);

    }

    /**
     * 多个源类
     */
    @Test
    public void test03() {
        Doctor doctorJason = Doctor.builder().id(1).name("Jason").speciality("A").build();
        Education education = Education.builder().degreeName("PHD").institute("FFF").yearOfPassing(1985).build();

        DoctorDTO doctorDTOJason = DoctorMapper.INSTANCE.toDtoFromMultipleSources(doctorJason, education);

        System.out.println("原始类型 doctor : " + doctorJason);
        System.out.println("原始类型 education : " + education);
        System.out.println("转变后DTO后 ：" + doctorDTOJason);

    }

    /**
     * 子对象映射
     */
    @Test
    public void test04() {

        List<Patient> patients = Arrays.asList(Patient.builder().id(1).name("Orange").build(),
                Patient.builder().id(2).name("Caqui").build());
        Doctor doctorJason = Doctor.builder().id(1).name("Jason").speciality("A").patients(patients).build();


        DoctorDTO doctorDTOJason = DoctorMapper.INSTANCE.toDtoWithPatient(doctorJason);

        System.out.println("原始类型 doctor : " + doctorJason);

        System.out.println("转变后DTO后 ：" + doctorDTOJason);

    }

    /**
     * 更新现有实例
     */
    @Test
    public void test05() {
        Patient orange = Patient.builder().id(1).name("Orange").build();
        Patient caqui = Patient.builder().id(2).name("Caqui").build();

        List<Patient> patients = new ArrayList<>();
        patients.add(orange);
        patients.add(caqui);

        Doctor doctorJason = Doctor.builder().id(1).name("Jason").speciality("A").patients(patients).build();

        System.out.println("原始类型 doctor : " + doctorJason);

        PatientDTO banana = PatientDTO.builder().id(3).name("Banana").build();
        PatientDTO caqui1 = PatientDTO.builder().id(1).name("Caqui").build();

        List<PatientDTO> patientDTOList = new ArrayList<>();
        patientDTOList.add(banana);
        patientDTOList.add(caqui1);

        DoctorDTO doctorDTO = DoctorDTO.builder().id(1).name("Jason").specialization("B").patientDTOList(patientDTOList).build();

        DoctorMapper.INSTANCE.updateModel(doctorDTO, doctorJason);
        System.out.println("更新后 ：" + doctorJason);

    }

    /**
     * 数据类型映射
     */
    @Test
    public void test06() {
        PatientDTO banana = PatientDTO.builder().id(3).name("Banana").dateOfBirth(LocalDate.now()).build();
        Patient patient = PatientMapper.INSTANCE.fromDto(banana);

        System.out.println("原始类型 patientDTO : " + banana);

        System.out.println("转变后 patient ：" + patient);
    }
}
