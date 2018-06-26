package com.cliang.application.dao;

import com.cliang.application.entity.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserMapper {
    @InsertProvider(type = UserMapperProvider.class,method = "bathInsert")
    int insertAll(@Param("list") List<User> users);

    class UserMapperProvider{
        public String bathInsert(Map map){
            List<User> users = (List<User>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO user ");
            sb.append("(name,gender,age) values");
            MessageFormat mf = new MessageFormat("(#'{'list[{0}].name}), #'{'list[{0}].gender}),#'{'list[{0}].age})");
            for (int i = 0; i < users.size(); i++) {
                sb.append(mf.format(new Object[]{i}));
                if (i < users.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }
}
