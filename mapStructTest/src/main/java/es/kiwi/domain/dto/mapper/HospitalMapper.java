package es.kiwi.domain.dto.mapper;

import es.kiwi.domain.Hospital;
import es.kiwi.domain.dto.HospitalDTO;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/*
在@Mapper注解中添加（componentModel = "spring"），是为了告诉MapStruct，
在生成映射器实现类时，我们希望它能支持通过Spring的依赖注入来创建。
现在，就不需要在接口中添加 INSTANCE 字段了。
 */
// @Mapper(componentModel = "spring")
@Mapper//(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, uses = DoctorMapper.class)
public interface HospitalMapper {

    HospitalMapper INSTANCE = Mappers.getMapper(HospitalMapper.class);

    HospitalDTO toDto (Hospital hospital);

}
