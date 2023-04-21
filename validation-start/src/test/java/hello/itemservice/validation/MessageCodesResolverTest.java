package hello.itemservice.validation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver mcr = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = mcr.resolveMessageCodes("required", "item");
        for(String code : messageCodes){
            System.out.println("code = " + code);
        }
        assertThat(messageCodes).contains("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = mcr.resolveMessageCodes("required", "item", "itemName", String.class);
        for(String code : messageCodes) {
            System.out.println("code = " + code);
        }
    }
}
