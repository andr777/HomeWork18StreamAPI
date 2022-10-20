package pro.sky.HomeWork18StreamAPI.Service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18StreamAPI.Exceptions.BadRequestExeptions;

import org.apache.commons.lang3.StringUtils;

@Service
public class СheckNameFamile {


    public String СheckNameFamile(String str) {
        String[] strs = str.split("-");
        for (int i = 0; i < strs.length; i++) {
            if (!StringUtils.isAlpha(strs[i])) {
                throw new BadRequestExeptions();
            }
            strs[i] = StringUtils.capitalize(strs[i].toLowerCase());
        }
        return String.join("-",strs);
    }

}
