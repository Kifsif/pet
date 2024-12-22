package gift.academic.pet.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UnauthorizedResponseManager {
    public Map<String, Map<String, Object>>  getUnoathorizedResponse(){
        Map<String, Object> innerMap = new HashMap<>();
        innerMap.put("code", 401);
        innerMap.put("message", "Unauthorized");

        Map<String, Map<String, Object>> outerMap = new HashMap<>();
        outerMap.put("error", innerMap);

        return outerMap;
    }
}