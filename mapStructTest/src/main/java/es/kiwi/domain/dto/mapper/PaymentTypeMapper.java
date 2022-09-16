package es.kiwi.domain.dto.mapper;

import es.kiwi.domain.PaymentType;
import es.kiwi.domain.dto.PaymentTypeView;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;

/**
 * @author nerea
 */
@Mapper
public interface PaymentTypeMapper {

    PaymentTypeMapper INSTANCE = Mappers.getMapper(PaymentTypeMapper.class);

    /**
     * 为了在这些枚举项之间建立桥梁，我们可以使用@ValueMappings注解，该注解中可以包含多个@ValueMapping注解。
     * 这里，我们将source设置为三个具体枚举项之一，并将target设置为CARD
     * @param paymentType
     * @return
     */
    @ValueMappings({
            @ValueMapping(source = "CARD_VISA", target = "CARD"),
            @ValueMapping(source = "CARD_MASTER", target = "CARD"),
            @ValueMapping(source = "CARD_CREDIT", target = "CARD")
    })
    PaymentTypeView paymentTypeToPaymentTypeView(PaymentType paymentType);

    /**
     * 让MapStruct将所有剩余的可用枚举项（在目标枚举中找不到相同名称的枚举项），直接转换为对应的另一个枚举项
     * @param paymentType
     * @return
     */
    @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "CARD")
    PaymentTypeView paymentTypeToPaymentTypeView1(PaymentType paymentType);

    /**
     * MapStruct不会像前面那样先处理默认映射，再将剩余的枚举项映射到target值。
     * 而是，直接将所有未通过@ValueMapping注解做显式映射的值都转换为target值
     * @param paymentType
     * @return
     */
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "CARD")
    PaymentTypeView paymentTypeToPaymentTypeView2(PaymentType paymentType);
}
