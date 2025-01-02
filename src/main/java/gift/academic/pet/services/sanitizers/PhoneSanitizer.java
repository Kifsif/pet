package gift.academic.pet.services.sanitizers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


public class PhoneSanitizer {
    public static String sanitizePhone(String phoneNumber){
        phoneNumber = StringUtils.strip(phoneNumber, "+");
        phoneNumber = StringUtils.strip(phoneNumber);
        return phoneNumber;
    }
}
